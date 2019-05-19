package com.stock.management.controller;

import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stock.management.modal.Item;
import com.stock.management.modal.StockLog;
import com.stock.management.modal.Transaction;
import com.stock.management.modal.User;
import com.stock.management.service.TransactionServiceImpl;

@RestController
@RequestMapping(value = "/stockcloud")
public class TransactionController {

	
	@Autowired
	TransactionServiceImpl service;
	
	@RequestMapping(value = "/savetransaction", method = RequestMethod.POST)
	public Transaction saveTransaction(@RequestBody Transaction transaction) {

		return service.saveTransaction(transaction);
	}
	
	@RequestMapping(value = "/viewTransactions",method = RequestMethod.GET)
	public List<Transaction> fetchAllTransactions() {
		return service.fetchAllTransactions();
	}
	
	
	@RequestMapping(value = "/test")
	public Transaction test() {

		Transaction transaction = new Transaction();
		StockLog stocklog = new StockLog();
		Item item = new Item();
		
		transaction.setId(1);
		//Date date = new Date();
		//transaction.setDate(date);
		//transaction.setUser("kav");
		
		stocklog.setId(1);
		stocklog.setQty(40);
		
		item.setId(1);
		item.setName("Soap");
		item.setUnitprice(50.0);
		
		List<Item> items = new ArrayList<Item>();
		items.add(item);
		//stocklog.setItems(items);
		
		List<StockLog> stocklogs = new ArrayList<StockLog>();
		stocklogs.add(stocklog);
		//transaction.setStocklog(stocklogs);
		return transaction;
	}
	
}
