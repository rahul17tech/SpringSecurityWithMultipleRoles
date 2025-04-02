package com.exmaple.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class WelcomeController {

	@GetMapping
	public String welcome() {
		return "<h1> Welcome </h1>";
	}

	@GetMapping("/csrf")
	public CsrfToken getCsrf(HttpServletRequest req) {
		return (CsrfToken) req.getAttribute("_csrf");
	}
}
