package com.exmaple.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

	private record Product(Integer productId, String productName, double price) {
	}

	List<Product> products = new ArrayList<>(List.of(new Product(1, "iPhone", 999.0), new Product(2, "Mac Pro", 2099.0))

	);

	@GetMapping
	@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')")
	public List<Product> getProducts() {
		return products;
	}

	@PostMapping
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Product saveProducts(@RequestBody Product p) {
		products.add(p);
		return p;
	}

}
