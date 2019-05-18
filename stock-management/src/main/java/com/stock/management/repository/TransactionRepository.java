package com.stock.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stock.management.modal.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction,Integer> {

}