package com.cognizant.BDS.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.BDS.model.MyRequestFromBloodBank;
import com.cognizant.BDS.service.AvailableBloodService;
import com.cognizant.BDS.service.MyRequestFromBloodBankService;

@RestController
@RequestMapping(value = "/myRequests")
public class MyRequestFromBloodBankController {
	
	@Autowired
	private MyRequestFromBloodBankService myRequestFromBloodBankService;
	
	
	
	public MyRequestFromBloodBankController(MyRequestFromBloodBankService myRequestFromBloodBankService) {
		
	}



	@GetMapping(value = "/{requestor_id}")
	public ResponseEntity<Set<MyRequestFromBloodBank>> getMyRequests(@PathVariable("requestor_id") int userId){
		return new ResponseEntity<Set<MyRequestFromBloodBank>>(myRequestFromBloodBankService.getMyRequests(userId),HttpStatus.OK);
	} 
	
	@GetMapping(value = "/bloodBankRequest/{bb_id}")
	public ResponseEntity<Set<MyRequestFromBloodBank>> getHospitalsPendingRequests(@PathVariable("bb_id") int bloodBankId){
		return new ResponseEntity<Set<MyRequestFromBloodBank>>(myRequestFromBloodBankService.getHospitalsPendingRequests(bloodBankId),HttpStatus.OK);
	}
	
	@GetMapping(value = "/accept/{id}")
	public void accept(@PathVariable("id") int id){
		myRequestFromBloodBankService.accept(id);
	}
	@GetMapping(value = "/reject/{id}")
	public void reject(@PathVariable("id") int id){
		myRequestFromBloodBankService.reject(id);
	}
	
	@GetMapping(value = "/requestBlood/{userId}/{bloodBankId}/{availableBloodId}")
	public void requestBlood(@PathVariable("userId") int userId,@PathVariable("bloodBankId") int bloodBankId,@PathVariable("availableBloodId") int availableBloodId){
		myRequestFromBloodBankService.requestBlood(userId,bloodBankId,availableBloodId);
	}

}
