package com.stock.management.service;


import java.util.List;

import com.stock.management.modal.User;

public interface UserService {
	User saveUserDetails(User user);
	List<User> fetchAllUsers();

}
