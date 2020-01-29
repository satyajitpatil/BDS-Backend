package com.cognizant.BDS.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.BDS.model.Feedback;
import com.cognizant.BDS.model.Slot;

import com.cognizant.BDS.service.SlotService;

@RestController
public class SlotController {

	@Autowired
	private SlotService slotService;


	@RequestMapping(value="/slot")
	public ResponseEntity<Set<Slot>> getAllSlot(){
		return new ResponseEntity<Set<Slot>>(slotService.getAllSlot(),HttpStatus.OK);
	}
	
	@PutMapping(value = "/checkSlot")
	public ResponseEntity<Long> checkIfASlotIsBooked(@RequestBody Slot slot){
		return new ResponseEntity<Long>(slotService.checkIfASlotIsBooked(slot),HttpStatus.OK);
	}
	
	@PostMapping(value = "/slotBooking")
	public void bookSlot(@RequestBody Slot slot){
		slotService.bookSlot(slot);
	}
	
}
