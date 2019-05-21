package com.stock.management.controller;

import java.util.List;

import javax.swing.text.html.HTML;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stock.management.modal.StockLog;
import com.stock.management.service.StockLogService;




@RestController
@RequestMapping(value = "/stockapi")
public class StockLogController {
	
	@Autowired
	StockLogService stockLogService;
	
	@RequestMapping(value ="/addstocklog",method = RequestMethod.POST)
	public StockLog save(@RequestBody StockLog stockLog){
		return stockLogService.save(stockLog);
	}
//	@RequestMapping(value ="/getstocklog", method = RequestMethod.GET)
//	public List<StockLog> fetchAllStocks(){
//		return stockLogService.fetchAllStocks();
//	}
	
	@RequestMapping(value ="/getstocklog", method = RequestMethod.GET)
	public String fetchAllStocks(Model model){
		 model.addAllAttributes(stockLogService.fetchAllStocks());
		return "stockLog";
	}
	
	
}
