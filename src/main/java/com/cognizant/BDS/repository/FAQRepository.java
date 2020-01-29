package com.cognizant.BDS.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.BDS.model.FAQ;

@Repository
public interface FAQRepository extends JpaRepository<FAQ, Long> {
	
	@Query(value = "select * from faq where is_answered = false;",nativeQuery = true)
	public Set<FAQ> getAllUnAnsweredQuestions();
	
	@Query(value = "select * from faq where is_answered = true;",nativeQuery = true)
	public Set<FAQ> getAllAnsweredQuestions();
	
	@Query(value = "select * from faq where user_id = ?;",nativeQuery = true)
	public Set<FAQ> getMyQuestions(int userId);
	
	//PostQuestions
	@Modifying
	@Transactional
	@Query(value = "insert into faq(question,user_id) values(?,?);",nativeQuery = true)
	public int postQuestions(String question, int userId);
	
	//answer questions for admin
	@Modifying
	@Transactional
	@Query(value = "update faq set answer = ?, is_answered = 1 where faq_id = ?;",nativeQuery = true)
	public int answerQuestion(String answer , int faqId);
	

}
