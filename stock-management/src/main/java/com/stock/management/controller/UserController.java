package com.stock.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stock.management.modal.User ;
import com.stock.management.service.UserService;

@RestController
@RequestMapping(value="/stock")
public class UserController {
	
	@Autowired
	UserService userService;
	
	//Add a new user
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public User saveUserDetails(@RequestBody User user){
		return userService.saveUserDetails(user);
		
		
	}
	
	//View All users
	@RequestMapping(value = "/viewUsers",method = RequestMethod.GET)
	public List<User> fetchAllUsers() {
		return userService.fetchAllUsers();
	}

}
