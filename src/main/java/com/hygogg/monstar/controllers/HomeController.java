package com.hygogg.monstar.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.hygogg.monstar.models.Drink;
import com.hygogg.monstar.services.DrinkService;


@Controller
public class HomeController {
	
	private final DrinkService drinkService;
	
	public HomeController(DrinkService drinkService) {
		this.drinkService = drinkService;
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
	public String newDrink(Model model) {
		model.addAttribute("drink", new Drink());
		return "newDrink.jsp";
	}
	
	@RequestMapping(value="/drinks", method=RequestMethod.POST)
	public String createDrink(@Valid @ModelAttribute("drink") Drink drink, BindingResult result) {
		if(result.hasErrors()) {
			return "newDrink.jsp";
		} else {
			drinkService.create(drink);
			return "redirect:/drinks/all";
		}
	}
	
	@RequestMapping(value="/drinks/{id}")
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
	
}
