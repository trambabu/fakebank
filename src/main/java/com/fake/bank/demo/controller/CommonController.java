package com.fake.bank.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;

import com.fake.bank.demo.exception.RestBadRequestException;
import com.fake.bank.demo.exception.RestObjectNotFoundException;
import com.fake.bank.demo.service.UserService;
import com.fake.bank.demo.user.Users;
import com.fake.bank.demo.user.role.Role;
import com.fake.bank.demo.user.role.UserRole;
import com.fake.bank.demo.utils.Messages;

@RestController
public class CommonController {
	
	@Autowired
	UserService userService;
	
	
	/*
	 * Find the user by Id
	 */
	public Users getUserById(Long id) {
		
		if (id < 0) {
			throw new RestBadRequestException (Messages.INVALID_OBJECT_ID);
		}
	
		Users user = userService.findById(id);
		
		if (user == null) {
			throw new RestObjectNotFoundException (Messages.OBJECT_NOT_FOUND + id);
		}
		
		return user;
	}
	
	/*
	 * Gets current authenticated user
	 */
	public Users getAuthenticatedUser () {
		
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		Users user = userService.findByUsername(auth.getName());
		
		Set<UserRole> ur = user.getUserRoles();
		List<Role> roles = new ArrayList<Role>();
		
		for (UserRole r: ur) {
			roles.add(r.getRole());
		}
		return userService.findByUsername(auth.getName());
	}
	
	/*
	 * Checks the current role of the user
	 */
	public boolean hasRole(Users user, String roleName) {
		return userService.hasRole(user, roleName);
	}

}
