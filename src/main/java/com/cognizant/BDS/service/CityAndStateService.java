package com.cognizant.BDS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.BDS.repository.CityAndStateRepository;
import com.cognizant.BDS.repository.UserRepository;

@Service
public class CityAndStateService {
	
	@Autowired
	private CityAndStateRepository cityAndStateRepository;

	public CityAndStateService(CityAndStateRepository cityAndStateRepository) {
		
	}
	
	public List<String> getStates(){
		return cityAndStateRepository.getStates();
	}
	
	public List<String> getCities(String state){
		if(state.equals("ALL")) {
			return cityAndStateRepository.getCities();
		}
		else {
			int stateId = cityAndStateRepository.getStateIdByState(state);
			return cityAndStateRepository.getCitiesByStates(stateId);
		}		
	}
	
	
}
