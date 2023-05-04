package com.divya.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.divya.security.entity.UserInfo;
import com.divya.security.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@PostMapping("/saveuser")
	public String saveUser(@RequestBody UserInfo userInfo) {
		
		userService.saveUser(userInfo);
		
		return "user saved in data successfully";
	}
}
