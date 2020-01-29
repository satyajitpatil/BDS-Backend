package com.cognizant.BDS.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.BDS.model.AvailableBlood;
import com.cognizant.BDS.service.AvailableBloodService;

@RestController
@RequestMapping(value = "/availableblood")
public class AvailableBloodController {

	@Autowired
	private AvailableBloodService availableBloodService;

	public AvailableBloodController() {
	}

	@RequestMapping()
	public ResponseEntity<Set<AvailableBlood>> getAllAvailableBlood() {
		return new ResponseEntity<Set<AvailableBlood>>(availableBloodService.getAvailableBlood(), HttpStatus.OK);
	}

	// this function is for admin
	@GetMapping(value = "/forAdmin/{bloodGroup}")
	public ResponseEntity<Integer> getAvailableBloodByBloodGroupForAdmin(
			@PathVariable("bloodGroup") String bloodGroup) {
		return new ResponseEntity<Integer>(availableBloodService.getAvailableBloodByBloodGroupForAdmin(bloodGroup),
				HttpStatus.OK);
	}
	
	// this function is for hospital
	@GetMapping(value = "/forHospital/{bloodGroup}/{bloodBankName}")
	public ResponseEntity<Integer> getAvailableBloodByBloodGroupForAdmin(
			@PathVariable("bloodGroup") String bloodGroup,@PathVariable("bloodBankName") String bloodBankName) {
		return new ResponseEntity<Integer>(availableBloodService.getAvailableBloodByBloodGroupForHospital(bloodGroup,bloodBankName),
				HttpStatus.OK);
	}
	
	//by state and area
	@GetMapping(value = "/{bloodGroup}/{area}")
	public ResponseEntity<Set<AvailableBlood>> getAvailableBloodByStateAndArea(@PathVariable("bloodGroup") String bloodGroup, @PathVariable("area") String area){
		return new ResponseEntity<Set<AvailableBlood>>(availableBloodService.getAvailableBloodByStateAndArea(bloodGroup, area) ,HttpStatus.OK);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<AvailableBlood> getAvailableBloodById(@PathVariable("id") int id){
		return new ResponseEntity<AvailableBlood>(availableBloodService.getAvailableBloodById(id) ,HttpStatus.OK);
	}
	
	@GetMapping(value = "/decreament/{id}")
	public void decreamentBloodStockByOne(@PathVariable("id") int id){
		availableBloodService.decreamentBloodStockByOne(id);
	}
	
	@GetMapping(value = "/updateUnitsByHospital/{type}/{unit}/{bloodBankName}")
	public void updateUnitsByHospital(@PathVariable("type") String type,@PathVariable("unit") int unit,@PathVariable("bloodBankName") String bloodBankName){
		availableBloodService.updateUnitsByHospital(type,unit,bloodBankName);
	}

}
