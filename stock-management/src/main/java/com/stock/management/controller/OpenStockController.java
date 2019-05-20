package com.stock.management.controller;
//----- Sahan Part -----

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
	
	public final String responseSuccess = "Success";
	public final String responseFailed = "Failed";
	public final String messageSuccessPOST = "Succesfully added into database";
	public final String messageFailedPOST = "Failed to add values into database";
	public final String messageSuccessGET = "Succesfully withdrawed from database";
	public final String messageFailedGET = "Failed to withdraw from database";
	public final String messageSuccessPUT = "Succesfully updated database";
	public final String messageFailedPUT = "Failed to update database";
	public final String messageSuccessDELETE = "Succesfully delete from database";
	public final String messageFailedDELETE = "Failed to Delete from database";
	
	public Response oncall(boolean ifsuccess, String type) {
		Response response = new Response();
		String messagefailed = "";
		String messagesuccess = "";
		switch (type) {
		case "POST":
			messagefailed = messageFailedPOST;
			messagesuccess = messageSuccessPOST;
			break;
		case "GET":
			messagefailed = messageFailedGET;
			messagesuccess = messageSuccessGET;
			break;
		case "PUT":
			messagefailed = messageFailedPUT;
			messagesuccess = messageSuccessPUT;
			break;
		case "DELETE":
			messagefailed = messageFailedDELETE;
			messagesuccess = messageSuccessDELETE;
			break;
		default:
			break;
		}
		if(ifsuccess) {
			response.setResponse(responseSuccess);
			response.setMessage(messagesuccess);
		}else {
			response.setResponse(responseFailed);
			response.setMessage(messagefailed);
		}
		
		return response;
	}
	
	class Response{
	   	 
    	String response;
    	String message;
		public String getResponse() {
			return response;
		}
		public void setResponse(String response) {
			this.response = response;
		}
		public String getMessage() {
			return message;
		}
		public void setMessage(String message) {
			this.message = message;
		}
    	
    	
    }
	
	@Autowired
    OpenStockService stockService;

	// create  stock log with its respective details
	@RequestMapping(value = "/openStockAll", method = RequestMethod.POST)
    public ResponseEntity<?> saveOpenStock(@Valid @RequestBody OpenStock openStock)  {
	
        if(openStock.equals(null) ) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(oncall(false,"POST"));
		}else {
			openStock.setDate(ZonedDateTime.now(ZoneId.of("UTC-4")));
			stockService.saveOpenStock(openStock);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(oncall(true,"POST"));
		}
        
    }
//	public OpenStock saveOpenStock(@RequestBody OpenStock openStock) {
//		openStock.setDate(ZonedDateTime.now(ZoneId.of("UTC-4")));
//		return stockService.saveOpenStock(openStock);
//	  }
    
	// fetch all stock logs with its respective stock details
    @RequestMapping(value = "/openStockAll", method = RequestMethod.GET)
    public ResponseEntity<?> fetchAllOpenStock() {
    	List<OpenStock> openStocks = stockService.fetchAllOpenStock();
		if(openStocks == null || openStocks.size() == 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(oncall(false,"GET"));
		}else {
			return ResponseEntity.ok(stockService.fetchAllOpenStock());			
		}
	}
    
    // create a new stock log only
    @RequestMapping(value = "/openStockLog", method = RequestMethod.POST)
    public ResponseEntity<?> createOpenStock(@RequestBody OpenStock openStock) {
//    	openStock.setDate(ZonedDateTime.now(ZoneId.of("UTC-4")));
//        return stockService.createOpenStock(openStock);
    	
    	if(openStock.equals(null) ) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(oncall(false,"POST"));
		}else {
			System.out.println("not null");
			if(openStock.getUser() == null || openStock.getUser()<1 ) {
				throw new RuntimeException("Please provide valid open stock log information");
			}else if (openStock.getReason() == null) {
				throw new RuntimeException("Please provide valid open stock log information");
			} else{
				openStock.setDate(ZonedDateTime.now(ZoneId.of("UTC-4")));
				stockService.createOpenStock(openStock);
				return ResponseEntity.status(HttpStatus.ACCEPTED).body(oncall(true,"POST"));
			}
			
		}
    }
    
    // update existing stock details entry
    @RequestMapping(value = "/openStockLog/{id}", method = RequestMethod.PUT) // open stock log id
    public ResponseEntity<?> updateOpenStockLog(@PathVariable Integer id, @RequestBody OpenStock details){
    	
    	List<OpenStock> openStocks = stockService.fetchAllOpenStock();
    	
    	 if(details.equals(null) || id == null || id < 1 || id> openStocks.size()) {
 			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(oncall(false,"PUT"));
 		}else {
 			stockService.updateOpenStockLog(id, details);
 			return ResponseEntity.status(HttpStatus.ACCEPTED).body(oncall(true,"PUT"));
 		}
    }
    
    // fetch a stock log by id
    @RequestMapping(value = "/openStockLog/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> fetchOpenStockById(@PathVariable Integer id) {
    	List<OpenStock> openStocks = stockService.fetchAllOpenStock();
		if(openStocks == null || openStocks.size() == 0) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(oncall(false,"GET"));
		}else {
			
			if(id == null || id < 1 || id> openStocks.size()) {
				
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(oncall(false,"GET"));
			}else {
				OpenStock openStock = stockService.fetchOpenStock(id);
				return ResponseEntity.ok(openStock);
			}
			
			
		}
	}
    
    // delete existing stock log with its details
    @RequestMapping(value = "/openStockLog/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteOpenStockLog(@PathVariable Integer id){
    	
    	List<OpenStock> openStocks = stockService.fetchAllOpenStock();
    	if(openStocks == null || id == null || id < 1 || id> openStocks.size()) {
//    		throw new RuntimeException("Please provide valid open stock log id");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(oncall(false,"DELETE"));
		}else {
			stockService.deleteOpenStockLog(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(oncall(true,"DELETE"));
		}
    	
    }
    
    // create a new open stock detail entry for an existing stock log // not validated 
    @RequestMapping(value = "/openStockDetails/{id}", method = RequestMethod.POST)
    public ResponseEntity<?> createOpenStockDetails(@PathVariable Integer id, @RequestBody OpenStockDetails details) {

//    	return stockService.createOpenStockDetails(id, details);
    	List<OpenStock> openStocks = stockService.fetchAllOpenStock();
    	if(openStocks == null || openStocks.size() == 0) {
//    		throw new RuntimeException("Please provide valid open stock log id");
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(oncall(false,"DELETE"));
		}else {
			stockService.deleteOpenStockLog(id);
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(oncall(true,"DELETE"));
		}
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
    
    // delete all existing stock details entry for stock log id // not working
    @RequestMapping(value = "/openStockDetailsAll/{id}", method = RequestMethod.DELETE)
    public void deleteAllOpenStockDetails(@PathVariable Integer id){
     
    	 stockService.deleteAllOpenStockDetails(id);
    	
    }

    // fetch all stock details by stock log by id
    @RequestMapping(value = "/openStockDetailsAll/{id}", method = RequestMethod.GET)
    public ResponseEntity<List<OpenStockDetails>> fetchAllOpenStockDetailsById(@PathVariable Integer id) {
    	OpenStock openStock = stockService.fetchOpenStock(id);
		if(openStock == null ) {
			System.out.println("true");
			return ResponseEntity.noContent().build();
		}else {
			System.out.println("false");
			return ResponseEntity.ok(openStock.getOpenStockDetails());
		}
	}
    
    // fetch stock details by its id
    @RequestMapping(value = "/openStockDetails/{id}", method = RequestMethod.GET)
    public ResponseEntity<OpenStockDetails> fetchOpenStockDetailsById(@PathVariable Integer id) {
    	OpenStockDetails openStocksDetails = stockService.fetchAllOpenStockDetails(id);
		if(openStocksDetails == null ) {
			System.out.println("true");
			return ResponseEntity.noContent().build();
		}else {
			System.out.println("false");
			return ResponseEntity.ok(openStocksDetails);
		}
	}
}












