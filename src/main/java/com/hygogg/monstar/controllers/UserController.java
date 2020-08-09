package com.hygogg.monstar.controllers;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.hygogg.monstar.models.User;
import com.hygogg.monstar.services.UserService;


@Controller
public class UserController {

	private final UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/sign_in")
	public String signIn(Model model, HttpServletRequest request) {
		model.addAttribute("user", new User());
		model.addAttribute("validLogin", request.getParameter("validLogin"));
		return "signIn.jsp";
	}
	
	@RequestMapping(value="/sign_in", method=RequestMethod.POST)
	public String login(@RequestParam Map<String, String> body, HttpSession session) {
		User u = userService.login(body.get("email"), body.get("password"));
		if(u == null) {
			return "redirect:/sign_in?validLogin=false";
		}
		session.setAttribute("user", u);
		return "redirect:/";
	}
	
	@RequestMapping(value="/sign_up", method=RequestMethod.POST)
	public String register(@Valid @ModelAttribute("user") User u, BindingResult result, HttpSession session) {
		if(userService.findByEmail(u.getEmail()) != null) {
			result.rejectValue("email", "Unique", "Email is already in use!");
		}
		if(!u.getPassword().equals(u.getConfirm())) {
			result.rejectValue("confirm", "Match", "Confirm Password must match Password!");
		}
		if(result.hasErrors()) {
			return "signIn.jsp";
		} else {
			User user = userService.registerUser(u);
			session.setAttribute("user", user);
			return "redirect:/";
		}
	}
	
	@RequestMapping(value="/sign_out", method=RequestMethod.DELETE)
	public String logout(HttpSession session) {
		session.removeAttribute("user");
		return "redirect:/";
	}
	
}
