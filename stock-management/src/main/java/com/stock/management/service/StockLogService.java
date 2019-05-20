package com.stock.management.service;

import java.util.List;

import com.stock.management.modal.StockLog;

public interface StockLogService {
	public StockLog save(StockLog stockLog);
	public List<StockLog> fetchAllStocks();
}