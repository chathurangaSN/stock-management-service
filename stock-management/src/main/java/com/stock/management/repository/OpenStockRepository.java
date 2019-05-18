package com.stock.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.management.modal.OpenStock;

//----- Sahan Part -----
public interface OpenStockRepository extends JpaRepository<OpenStock, Integer> {

}
