package com.stock.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.management.modal.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
