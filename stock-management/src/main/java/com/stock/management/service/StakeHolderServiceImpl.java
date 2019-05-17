package com.stock.management.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stock.management.modal.StakeHolder;
import com.stock.management.repository.StakeHolderRepository;

@Service
public class StakeHolderServiceImpl implements StakeHolderService {

		@Autowired
		StakeHolderRepository stakeHolderRepository;

		@Override
		public StakeHolder saveStakeHolders(StakeHolder stakeHolders) {
			// TODO Auto-generated method stub
			return stakeHolderRepository.save(stakeHolders);
		}

		@Override
		public StakeHolder fetchStakeHolder(Integer id) {
			Optional<StakeHolder> optional = stakeHolderRepository.findById(id);
			
			if(optional.isPresent()) {
				return optional.get();
				
			}else {
				return null;
			}
		}
	

}


