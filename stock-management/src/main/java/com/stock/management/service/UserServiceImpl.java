package com.stock.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.management.modal.UserTelephone;
import com.stock.management.modal.User;
import com.stock.management.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserRepository userRepository;

	//Add a new user
	@Override
	public User saveUserDetails(User user) {
		for(UserTelephone usertelephone: user.getUsertelephones()){
			 usertelephone.setUser(user);
		 }
		
		return userRepository.save(user);
	}

	//View All users
	@Override
	public List<User> fetchAllUsers() {
		return userRepository.findAll();
	}
	
	

}
