package com.cognizant.BDS.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.BDS.model.FAQ;
import com.cognizant.BDS.service.FAQService;

@RestController
public class FAQController {

	@Autowired
	private FAQService faqService;		
		
	public FAQController() {
		
	}

	@GetMapping(value="/unAnswered")
	public ResponseEntity<Set<FAQ>> getAllUnAnsweredQuestions(){
		return new ResponseEntity<Set<FAQ>>(faqService.getAllUnAnsweredQuestions(),HttpStatus.OK);	
	}
	
	@GetMapping(value="/answered")
	public ResponseEntity<Set<FAQ>> getAllAnsweredQuestions(){
		return new ResponseEntity<Set<FAQ>>(faqService.getAllAnsweredQuestions(),HttpStatus.OK);	
	}
	
	@GetMapping(value="/myQuestion/{id}")
	public ResponseEntity<Set<FAQ>> getMyQuestions(@PathVariable("id") int userId){
		return new ResponseEntity<Set<FAQ>>(faqService.getMyQuestions(userId),HttpStatus.OK);	
	}
	
	@PostMapping(value="/postQuestion")
	public void postQuestion(@RequestBody FAQ faq){
		faqService.postQuestion(faq);	
	}
	
	@PostMapping(value="/answerQuestion")
	public void answerQuestionByAdmin(@RequestBody FAQ faq){
		faqService.answerQuestionByAdmin(faq);	
	}
	
}
