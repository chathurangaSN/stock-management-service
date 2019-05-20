//nilaksha
package com.stock.management.service;

//import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.stock.management.modal.StakeHolder;
import com.stock.management.modal.StakeHolderTelephone;
import com.stock.management.repository.StakeHolderRepository;

@Service
public class StakeHolderServiceImpl implements StakeHolderService {

		@Autowired
		StakeHolderRepository stakeHolderRepository;

		@Override
		public StakeHolder saveStakeHolders(StakeHolder stakeHolders) {
			for (StakeHolderTelephone telephone : stakeHolders.getTelephones()){
				telephone.setStakeholder(stakeHolders);
			}

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

		@Override
		public List<StakeHolder> fetchAllUsers() {
			// TODO Auto-generated method stub
			return stakeHolderRepository.findAll();
		}

		@Override
		public void updateStakeHolder(Integer id, StakeHolder stakeHolder) {
			// TODO Auto-generated method stub
			List<StakeHolder> stakeholder =  stakeHolderRepository.findAll();
			for (int i = 0; i < stakeholder.size(); i++) {
				
					StakeHolder s=stakeholder.get(i);
					if(s.getId().equals(id)) {
						
						stakeholder.set(id, (StakeHolder) stakeholder);
						return;
					}
				}	
			  
			
		}

		@Override
		public void deleteStakeHolder(Integer id) {
			// TODO Auto-generated method stub
			stakeHolderRepository.deleteById(id);
			
		}
	

}


