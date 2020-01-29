package com.cognizant.BDS.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.BDS.model.BloodBank;
import com.cognizant.BDS.service.BloodBankService;

@RestController
@RequestMapping(value = "/BloodBank")
public class BloodBankController {
	
	@Autowired
	private BloodBankService bloodBankService;

	public BloodBankController() {
		
	}
	
	@GetMapping(value = "/getBloodBanks/{city}")
	public ResponseEntity<Set<BloodBank>> getBloodBanksByCity(@PathVariable("city") String city){
		return new ResponseEntity<Set<BloodBank>>(bloodBankService.getBloodBanksByCity(city), HttpStatus.OK);
	}
	
	@GetMapping(value = "/getBloodBankByName/{bloodBankName}")
	public ResponseEntity<BloodBank> getBloodBankByName(@PathVariable("bloodBankName") String bloodBankName){
		return new ResponseEntity<BloodBank>(bloodBankService.getBloodBankByName(bloodBankName), HttpStatus.OK);
	}
}
