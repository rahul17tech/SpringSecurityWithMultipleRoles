package com.exmaple.controller;

import java.util.Set;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.exmaple.entity.User;
import com.exmaple.service.RoleService;

@RestController
public class RoleController {

	private final RoleService roleService;

	public RoleController(RoleService roleService) {
		this.roleService = roleService;
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@PutMapping("/assign/{username}")
	public User assignRoles(@PathVariable String username, @RequestBody Set<String> roleNames) {
		return roleService.assignRolesToUser(username, roleNames);
	}
}
