package com.stock.management.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.management.modal.StockLog;
import com.stock.management.repository.StockLogRepository;


@Service
public class StockLogServiceImpl implements StockLogService {
	
	@Autowired
	StockLogRepository stockLogRepository;
	
	
	@Override
	public StockLog save(StockLog stockLog){
		Date date = new Date();
		stockLog.setDate(date);
		return stockLogRepository.save(stockLog);
	}
	@Override
	public List<StockLog> fetchAllStocks(){
		return stockLogRepository.findAll();
	}
}
