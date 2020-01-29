package com.cognizant.BDS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "faq")
public class FAQ {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "faq_id")
	private int faqId;
	@Column(name = "question")
	private String question;
	@Column(name = "answer")
	private String answer;
	@Column(name = "is_answered")
	private boolean answered;
	@Column(name = "user_id")
	private int userId;

	public FAQ() {
		
	}

	public FAQ(int faqId, String question, String answer, boolean answered, int userId) {
		super();
		this.faqId = faqId;
		this.question = question;
		this.answer = answer;
		this.answered = answered;
		this.userId = userId;
	}

	public int getFaqId() {
		return faqId;
	}

	public void setFaqId(int faqId) {
		this.faqId = faqId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public boolean answered() {
		return answered;
	}

	public void setAnswered(boolean answered) {
		this.answered = answered;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

}
