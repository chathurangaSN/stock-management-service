package com.stock.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.management.modal.Item;
import com.stock.management.modal.StockLog;
import com.stock.management.modal.Transaction;
import com.stock.management.modal.User;
import com.stock.management.repository.TransactionRepository;

@Service
public class TransactionServiceImpl {

	@Autowired
	TransactionRepository transactionRepository;
	
	public Transaction saveTransaction(Transaction transaction) {
		
		for (StockLog stocklog : transaction.getStocklog()) {
			stocklog.setTransaction(transaction);
			
			for(Item item : stocklog.getItems()) {
				item.setStocklog(stocklog);
			}
		}
		return transactionRepository.save(transaction);
	}
	
	
	public List<Transaction> fetchAllTransactions() {
		return transactionRepository.findAll();
	}
	
}