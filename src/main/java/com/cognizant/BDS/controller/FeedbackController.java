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
import com.cognizant.BDS.service.FeedbackService;

@RestController
public class FeedbackController {
	
	@Autowired
	private FeedbackService feedbackService;

	
	@RequestMapping(value="/feedback")
	public ResponseEntity<Set<Feedback>> getAllFeedbacks(){
		return new ResponseEntity<Set<Feedback>>(feedbackService.getAllFeedbacks(),HttpStatus.OK);
	}
	
	@PostMapping(value="/addFeedback")
	public void addFeedback(@RequestBody Feedback feedback) {
		feedbackService.addFeedback(feedback);
		
	}

}
