package com.example.UserRepo.controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.UserRepo.model.User;
import com.example.UserRepo.service.UserService;

@Controller
public class AuthenticationController {
	
	@Autowired
	UserService userService;

	@GetMapping("/register")
	public ModelAndView register() {
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("register");
		return modelAndView;
	}
	
	@PostMapping("/register")
	public ModelAndView registerUser(@Valid User user,BindingResult bindingResult, ModelMap modelmap) {
		ModelAndView modelAndView = new ModelAndView();
		if (bindingResult.hasErrors()) {
			modelAndView.addObject("successMessage", "Error in filled values!");
			modelmap.addAttribute("bindingResult", bindingResult);
		}
		else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User registered successfully!");
		}
		modelAndView.addObject("user", new User());
		modelAndView.setViewName("register");
		return modelAndView;
	}
	
	@PostMapping("/user/register")
	public @ResponseBody User registerUser(@RequestBody User user) {
		return userService.saveUser(user);
	}
	
	@PutMapping("/user/{id}")
	public @ResponseBody User UpdateUser(@RequestBody User user, @PathVariable Integer id) {
		return userService.updateUser(user, id);
	}
	
	@DeleteMapping("/user/{id}")
	public @ResponseBody Map<String, String> deleteUser(@PathVariable Integer id) {
		return userService.deleteUser(id);
	}
	
	@GetMapping("/users")
	public @ResponseBody List<User> showAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("/user/{id}")
	public @ResponseBody User getUser(@PathVariable Integer id) {
		return userService.getUser(id);
	}
}
