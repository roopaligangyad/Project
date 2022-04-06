package com.cg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Admin;
import com.cg.exception.InvalidAdminException;
import com.cg.exception.InvalidInputException;
import com.cg.services.AdminService;

@RestController
@RequestMapping("/edu/admin")
public class AdminController {
	@Autowired
	private AdminService adminService;

	@GetMapping("/admin-login")
	public Admin adminLogin(@RequestParam("adminUsername") final String username,
			@RequestParam("adminPassword") final String password) throws InvalidAdminException {
		final String pattern = "^[a-zA-Z0-9]*$";
		if (username == "") {
			throw new InvalidInputException("Username cannot be null :");
		} else if (password == "") {
			throw new InvalidInputException("Password cannot be null :");
		} else if (!(username.matches(pattern))) {
			throw new InvalidInputException("Username can only contain alphanumeric characters ");
		} else if (!(password.matches(pattern))) {
			throw new InvalidInputException("Password can only contain alphanumeric characters ");
		} else {
			return adminService.adminLogin(username, password);
		}
	}

}
