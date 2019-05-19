package com.stock.management.controller;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
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

	//find user by id
	@RequestMapping(value = "/user/{id}",method = RequestMethod.GET)
	public ResponseEntity<User> findUserById(@PathVariable Integer id) {
        Optional<User> user = userService.findUserById(id);
        if (!user.isPresent()) {
            return ResponseEntity.notFound().build();
        }else {

        return ResponseEntity.ok(user.get());
        }
    }
	
	
	//Delete user
	@RequestMapping(value = "/deleteUser/{id}",method = RequestMethod.DELETE)
	public void deleteUser(@PathVariable Integer id) {
		userService.deleteUser(id);
    }
	
	//Delete All users
	@RequestMapping(value = "/deleteAllUsers",method = RequestMethod.DELETE)
	public void deleteAllUsers() {
		userService.deleteAllUsers();
    }
	
	//update user
	@RequestMapping(value = "/updateUser/{id}",method = RequestMethod.PUT)
	public ResponseEntity<User> updateStudent(@RequestBody User user, @PathVariable Integer id) {

		Optional<User> optionalUser = userService.findUserById(id);

		if (!optionalUser.isPresent())
			return ResponseEntity.notFound().build();

		user.setId(id);
		
		userService.saveUserDetails(user);

		return ResponseEntity.noContent().build();
}
	
}
