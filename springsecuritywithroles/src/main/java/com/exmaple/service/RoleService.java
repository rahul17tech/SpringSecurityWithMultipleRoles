package com.exmaple.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.exmaple.entity.Role;
import com.exmaple.entity.User;
import com.exmaple.repository.RoleRepository;
import com.exmaple.repository.UserRepository;

@Service
public class RoleService {

	private final RoleRepository roleRepository;
	private final UserRepository userRepository;

	public RoleService(RoleRepository roleRepository, UserRepository userRepository) {
		this.roleRepository = roleRepository;
		this.userRepository = userRepository;
	}

	public User assignRolesToUser(String username, Set<String> roleNames) {
		User user = userRepository.findByUsername(username);
		if (user == null) {
			throw new RuntimeException("User not found");
		}

		Set<Role> roles = new HashSet<>();
		for (String roleName : roleNames) {
			Role role = roleRepository.findByRoleName(roleName);
			if (role == null) {
				throw new RuntimeException("Role not found: " + roleName);
			}
			roles.add(role);
		}

		user.setRoles(roles);
		return userRepository.save(user);
	}

}
