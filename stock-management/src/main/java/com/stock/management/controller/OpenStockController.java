package com.stock.management.controller;
//----- Sahan Part -----

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stock.management.modal.OpenStock;
import com.stock.management.modal.OpenStockDetails;
import com.stock.management.service.OpenStockService;


@RestController
@RequestMapping(value = "/openstock")
public class OpenStockController {

	@Autowired
    OpenStockService stockService;

	// create  stock log with its respective details
	@RequestMapping(value = "/openStockAll", method = RequestMethod.POST)
    public OpenStock saveOpenStock(@RequestBody OpenStock openStock) {

        return stockService.saveOpenStock(openStock);
    }
	// fetch all stock logs with its respective stock details
    @RequestMapping(value = "/openStockAll", method = RequestMethod.GET)
//    public List<OpenStock> fetchAllOpenStock() {
//
//        return stockService.fetchAllOpenStock();
//    }
 
    public ResponseEntity<List<OpenStock>> fetchEmployee() {
		
    	List<OpenStock> openStocks = stockService.fetchAllOpenStock();
		if(openStocks == null || openStocks.size() == 0) {
			System.out.println("true");
			return ResponseEntity.noContent().build();
		}else {
			System.out.println("false");
			return ResponseEntity.ok(stockService.fetchAllOpenStock());
			
		}
	}
    
    // create a new stock log only
    @RequestMapping(value = "/openStockLog", method = RequestMethod.POST)
    public OpenStock createOpenStock(@RequestBody OpenStock openStock) {

        return stockService.createOpenStock(openStock);
    }
    
    // create a new open stock detail entry for an existing stock log // not validated 
    @RequestMapping(value = "/openStockDetails/{id}", method = RequestMethod.POST)
    public OpenStockDetails createOpenStockDetails(@PathVariable Integer id, @RequestBody OpenStockDetails details) {

    	return stockService.createOpenStockDetails(id, details);
    }
    
    // update existing stock details entry
    @RequestMapping(value = "/openStockDetails/{id}", method = RequestMethod.PUT)
    public void updateOpenStockDetails(@PathVariable Integer id, @RequestBody OpenStockDetails details){
     
    	stockService.updateOpenStockDetails(id, details);
    }
    
    // delete existing stock details entry
    @RequestMapping(value = "/openStockDetails/{id}", method = RequestMethod.DELETE)
    public void deleteOpenStockDetails(@PathVariable Integer id){
     
    	stockService.deleteOpenStockDetails(id);
    }
}
