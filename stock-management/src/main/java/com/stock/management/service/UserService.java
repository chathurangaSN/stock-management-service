package com.stock.management.service;


import java.util.List;
import java.util.Optional;

import com.stock.management.modal.User;

public interface UserService {
	User saveUserDetails(User user);
	List<User> fetchAllUsers();
	Optional<User> findUserById(Integer id);
//	User updateUser(User user);
	void deleteUser(Integer id);
	void deleteAllUsers();
	

}
