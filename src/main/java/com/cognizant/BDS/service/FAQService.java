package com.cognizant.BDS.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.BDS.model.FAQ;
import com.cognizant.BDS.repository.FAQRepository;

@Service
public class FAQService {
	
	@Autowired
	private FAQRepository faqRepository;

	public FAQService() {
		
	}
	
	public Set<FAQ> getAllUnAnsweredQuestions(){
		return faqRepository.getAllUnAnsweredQuestions();
	}
	
	public Set<FAQ> getAllAnsweredQuestions(){
		return faqRepository.getAllAnsweredQuestions();
	}
	
	public Set<FAQ> getMyQuestions(int userId){
		return faqRepository.getMyQuestions(userId);
	}
	
	public int postQuestion(FAQ faq) {
		return faqRepository.postQuestions(faq.getQuestion(),faq.getUserId());
	}
	
	public int answerQuestionByAdmin(FAQ faq){
		return faqRepository.answerQuestion(faq.getAnswer(), faq.getFaqId());
	}
	
	
}
