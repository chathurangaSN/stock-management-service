//nilaksha
package com.stock.management.service;

//import java.util.LinkedList;
//import java.util.List;
import java.util.List;

import com.stock.management.modal.StakeHolder;


public interface StakeHolderService {
	
	StakeHolder saveStakeHolders(StakeHolder stakeHolders);
	
	StakeHolder fetchStakeHolder(Integer id);
	
	//StakeHolder fetchAllStakeHolder();
	List<StakeHolder> fetchAllUsers();
	
	 void updateStakeHolder(Integer id,StakeHolder stakeHolder);

	void deleteStakeHolder(Integer id);
}
