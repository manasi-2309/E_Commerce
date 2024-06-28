package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.User;
import com.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping("/")
	public String getUsers(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "users";
	}

	@GetMapping("/new")
	public String showUserForm(Model model) {
		model.addAttribute("user", new User());
		return "user-form";
	}

	@RequestMapping(value = "/add-user", method = { RequestMethod.GET, RequestMethod.POST })
	public String saveUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/users/";
	}

	@GetMapping("/edit/{id}")
	public String showEditUserForm(@PathVariable Long id, Model model) {
		model.addAttribute("user", userService.getUserById(id));
		return "user-form";
	}

	@PostMapping("/{id}")
	public String updateUser(@PathVariable Long id, @ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/users/";
	}

	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable Long id) {
		System.out.println(id);
		userService.deleteUser(id);
		return "redirect:/users/";
	}
}
