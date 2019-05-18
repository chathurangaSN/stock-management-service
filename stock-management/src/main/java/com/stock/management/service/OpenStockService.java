package com.stock.management.service;

import java.util.List;

import com.stock.management.modal.OpenStock;
import com.stock.management.modal.OpenStockDetails;

//----- Sahan Part -----
public interface OpenStockService {

	OpenStock saveOpenStock(OpenStock openStock);
	
    List<OpenStock> fetchAllOpenStock();
    
    OpenStock createOpenStock(OpenStock openStock);
    
    OpenStockDetails createOpenStockDetails(Integer id, OpenStockDetails details);
    
    void updateOpenStockDetails(Integer id, OpenStockDetails details);
    
    void deleteOpenStockDetails(Integer id);
}
