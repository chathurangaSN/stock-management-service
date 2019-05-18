package com.stock.management.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.management.modal.OpenStock;
import com.stock.management.modal.OpenStockDetails;
import com.stock.management.repository.OpenStockDetailsRepository;
import com.stock.management.repository.OpenStockRepository;

//----- Sahan Part -----

@Service
public class OpenStockServiceImpl implements OpenStockService{

	@Autowired
 	OpenStockRepository openStockRepository;
 	
 	@Autowired
 	OpenStockDetailsRepository openStockDetailsRepository;

	@Override
	public OpenStock saveOpenStock(OpenStock openStock) {
		
		for(OpenStockDetails openStockDetails:openStock.getOpenStockDetails()) {
            openStockDetails.setOpenStock(openStock);
        }
        return openStockRepository.save(openStock);
	}

	@Override
	public List<OpenStock> fetchAllOpenStock() {
		
		return openStockRepository.findAll();
	}

	@Override
	public OpenStock createOpenStock(OpenStock openStock) {
		
		 return openStockRepository.save(openStock);
	}

	@Override
	public OpenStockDetails createOpenStockDetails(Integer id, OpenStockDetails details) {
		
		List<OpenStock> openStock =  fetchAllOpenStock();
		for (int i = 0; i < openStock.size(); i++) {
			if (openStock.get(i).getId() == id) {
				details.setOpenStock(openStock.get(i));
				return openStockDetailsRepository.save(details);
			}
		}
		return null;
	    
	}
	
	@Override
	public void updateOpenStockDetails(Integer id, OpenStockDetails details) {
		
		List<OpenStock> openStock =  openStockRepository.findAll();
		for (int i = 0; i < openStock.size(); i++) {
			if (openStock.get(i).getOpenStockDetails() != null) {
				List<OpenStockDetails> openStockDetails = openStock.get(i).getOpenStockDetails();
				for (int j = 0; j < openStockDetails.size(); j++) {
					if (openStockDetails.get(j).getId() == id) {
						openStockDetails.get(j).setItemId(details.getItemId());
						openStockDetails.get(j).setQuantity(details.getQuantity());
						
						 openStockRepository.save(openStock.get(i));
					}
				}
			}	
		}  
	}
	
	@Override
	public void deleteOpenStockDetails(Integer id) {
		 
		openStockDetailsRepository.deleteById(id);
		
	}
}
