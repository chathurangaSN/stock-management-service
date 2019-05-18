package com.stock.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stock.management.modal.OpenStockDetails;

//----- Sahan Part -----
public interface OpenStockDetailsRepository extends JpaRepository<OpenStockDetails, Integer> {

}
