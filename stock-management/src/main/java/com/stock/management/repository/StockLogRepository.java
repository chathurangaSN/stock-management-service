package com.stock.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.management.modal.StockLog;

public interface StockLogRepository extends JpaRepository<StockLog, Integer> {

}
