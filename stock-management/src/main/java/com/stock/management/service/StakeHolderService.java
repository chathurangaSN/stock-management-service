package com.stock.management.service;

import com.stock.management.modal.StakeHolder;

public interface StakeHolderService {
	
	StakeHolder saveStakeHolders(StakeHolder stakeHolders);
	
	StakeHolder fetchStakeHolder(Integer id);
}
