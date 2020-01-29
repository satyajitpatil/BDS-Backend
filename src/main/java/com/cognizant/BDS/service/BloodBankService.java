package com.cognizant.BDS.service;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.BDS.repository.BloodBankRepository;

import com.cognizant.BDS.model.BloodBank;

@Service
public class BloodBankService {
	
	@Autowired
	private BloodBankRepository bloodBankRepository;

	public BloodBankService() {
		
	}
	
	public Set<BloodBank> getBloodBanksByCity(String city){
		return bloodBankRepository.getBloodBanksByCity(city);
	}
	
	public BloodBank getBloodBankByName(String bloodBankName){
		return bloodBankRepository.getBloodBankByName(bloodBankName);
	}
	
}
