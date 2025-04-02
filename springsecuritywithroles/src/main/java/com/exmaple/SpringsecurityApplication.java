package com.exmaple;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.exmaple.entity.Role;
import com.exmaple.entity.User;
import com.exmaple.repository.RoleRepository;
import com.exmaple.repository.UserRepository;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class SpringsecurityApplication implements CommandLineRunner {

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityApplication.class, args);
	}

	@Override
	@Transactional
	public void run(String... args) throws Exception {
		Role admin = new Role();
		admin.setRoleName("ROLE_ADMIN");
		roleRepository.save(admin);

		Role user = new Role();
		user.setRoleName("ROLE_USER");
		roleRepository.save(user);

		User sreeja = new User();
		sreeja.setUsername("Sreeja");
		sreeja.setPassword(new BCryptPasswordEncoder().encode("sreeja"));
		sreeja.setRoles(Set.of(admin));

		userRepository.save(sreeja);

	}

}
