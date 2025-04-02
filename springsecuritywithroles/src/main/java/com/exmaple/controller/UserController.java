package com.exmaple.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exmaple.entity.User;
import com.exmaple.service.UserService;

@RestController
public class UserController {

	private final UserService userService;

	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("/register")
	public User register(@RequestBody User user) {
		return userService.register(user);
	}

	@PostMapping("/login")
	public String login(@RequestBody User user) {
		return userService.verify(user);
	}
}
