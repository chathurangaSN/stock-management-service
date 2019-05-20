
//nilaksha
package com.stock.management.controller;

//import java.util.LinkedList;
//import java.util.List;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.stock.management.modal.OpenStockDetails;
import com.stock.management.modal.StakeHolder;
import com.stock.management.service.StakeHolderService;


@RestController
@RequestMapping(value = "/stakeholder")
public class StakeHolderController {
	@Autowired
	StakeHolderService stakeHolderService;
	
	@RequestMapping(value = "/stakeholders", method = RequestMethod.POST)
	public  StakeHolder saveStakeHolders(@RequestBody StakeHolder stakeHolder) {
		
		return stakeHolderService.saveStakeHolders(stakeHolder);
	}
	
	@RequestMapping(value = "/stakeholders/{id}", method = RequestMethod.GET)
	public ResponseEntity<StakeHolder> fetchEmployee(@PathVariable Integer id) {
		
		StakeHolder StakeHolder = stakeHolderService.fetchStakeHolder(id);
		if(StakeHolder == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(StakeHolder);
		}
	}
	@RequestMapping(value = "/viewStakeHolders",method = RequestMethod.GET)
	public List<StakeHolder> fetchAllUsers() {
		return stakeHolderService.fetchAllUsers();
	}
	
	 @RequestMapping(value = "/updatestakeholder/{id}", method = RequestMethod.PUT)
	    public void updateStakeHolder(@PathVariable Integer id, @RequestBody  StakeHolder stakeHolder){
	     
		 stakeHolderService.updateStakeHolder(id, stakeHolder);
	    }
	    
	 @RequestMapping(value = "/deletestakeholder/{id}", method = RequestMethod.DELETE)
	    public void deleteStakeHolder(@PathVariable Integer id){
	     
	    	stakeHolderService.deleteStakeHolder(id);
	    }
	
}
