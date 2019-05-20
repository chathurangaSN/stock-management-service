package com.stock.management.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.management.modal.Item;
import com.stock.management.modal.OpenStock;
import com.stock.management.modal.OpenStockDetails;
import com.stock.management.modal.StockLog;
import com.stock.management.modal.Transaction;
import com.stock.management.modal.User;
import com.stock.management.repository.TransactionRepository;

@Service
public class TransactionServiceImpl {

	@Autowired
	TransactionRepository transactionRepository;
	
	public Transaction saveTransaction(Transaction transaction) {
		
//		for (StockLog stocklog : transaction.getStocklog()) {
//			stocklog.setTransaction(transaction);
//			
//			for(Item item : stocklog.getItems()) {
//				item.setStocklog(stocklog);
//			}
//		}
		return transactionRepository.save(transaction);
	}
	
	
	public List<Transaction> fetchAllTransactions() {
		return transactionRepository.findAll();
	}
	


public Transaction fetchTransaction(Integer id) {
		Optional<Transaction> optional = transactionRepository.findById(id);
		
		if(optional.isPresent()) {
			return optional.get();
			
		}else {
			return null;
		}
	}

public void updateTransaction(Integer id, Transaction transaction) {
	
	List<Transaction> transactionlist =  transactionRepository.findAll();
	for (int i = 0; i < transactionlist.size(); i++) {
		if (transactionlist.get(i) != null) {
			if (transactionlist.get(i).getId() == id) {
				transactionlist.get(i).setReference(transaction.getReference());
				transactionlist.get(i).setType(transaction.getType());	
					transactionRepository.save(transactionlist.get(i));
				}
			}
		}	
	 
}
	
	public void deleteTransactions(Integer id) {
		 
		transactionRepository.deleteById(id);
		
	}
	
}