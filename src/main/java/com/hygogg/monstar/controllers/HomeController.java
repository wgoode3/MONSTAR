package com.hygogg.monstar.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hygogg.monstar.models.Drink;
import com.hygogg.monstar.models.Review;
import com.hygogg.monstar.models.User;
import com.hygogg.monstar.services.DrinkService;
import com.hygogg.monstar.services.ReviewService;


@Controller
public class HomeController {
	
	private final DrinkService drinkService;
	private final ReviewService reviewService;
	
	public HomeController(DrinkService drinkService, ReviewService reviewService) {
		this.drinkService = drinkService;
		this.reviewService = reviewService;
	}

	@RequestMapping("/")
	public String index(Model model) {
		return "index.jsp";
	}
	
	@RequestMapping("/drinks/all")
	public String allDrinks(Model model) {
		List<Drink> drinks = drinkService.getAll();
		model.addAttribute("drinks", drinks);
		return "allDrinks.jsp";
	}
	
	@RequestMapping("/drinks/new")
	public String newDrink(Model model, HttpSession session) {
		model.addAttribute("drink", new Drink());
		User u = (User) session.getAttribute("user");
		if(u == null) {
			return "redirect:/drinks/all";
		}
		model.addAttribute("user", u);
		return "newDrink.jsp";
	}
	
	@RequestMapping(value="/drinks", method=RequestMethod.POST)
	public String createDrink(@Valid @ModelAttribute("drink") Drink drink, BindingResult result, HttpSession session) {
		User u = (User) session.getAttribute("user");
		if(u == null) {
			return "redirect:/drinks/all";
		}
		if(result.hasErrors()) {
			return "newDrink.jsp";
		} else {
			drinkService.create(drink);
			return "redirect:/drinks/all";
		}
	}
	
	@RequestMapping(value="/drinks/{id}/edit")
	public String editDrink(@PathVariable("id") Long id, Model model) {
		model.addAttribute("drink", drinkService.getOne(id));
		return "editDrink.jsp";
	}
	
    @RequestMapping(value="/drinks/{id}", method=RequestMethod.PUT)
    public String update(@Valid @ModelAttribute("drink") Drink d, BindingResult result) {
        if (result.hasErrors()) {
            return "editDrink.jsp";
        } else {
        	drinkService.update(d);
            return "redirect:/drinks/all";
        }
    }
    
    @RequestMapping(value="/drinks/{id}", method=RequestMethod.DELETE)
    public String remove(@PathVariable("id") Long id) {
    	drinkService.remove(id);
    	return "redirect:/drinks/all";
    }
    
    @RequestMapping("/drinks/{id}")
    public String showDrink(@PathVariable("id") Long id, Model model, HttpSession session) {
    	model.addAttribute("drink", drinkService.getOne(id));
    	model.addAttribute("user", session.getAttribute("user"));
    	model.addAttribute("review", new Review());
    	return "drink.jsp";
    }
    
    @RequestMapping(value="/drink/{id}/review", method=RequestMethod.POST)
    public String leaveReview(@Valid @ModelAttribute("review") Review r, @PathVariable("id") Long id, BindingResult result, Model model, HttpSession session) {
    	if(r.getUser() == null) {
    		return "redirect:/drinks/" + id;
    	}
    	if(result.hasErrors()) {
    		model.addAttribute("drink", drinkService.getOne(id));
    		model.addAttribute("user", session.getAttribute("user"));
    		return "drink.jsp";
    	}
    	reviewService.create(r);
    	return "redirect:/drinks/" + id;
    }
	
}
