package com.cognizant.BDS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

@Entity
@Table(name = "feedback")
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "feedback_id")
	private Long feedbackId;
	@Column(name = "hospital_name")
	private String hospitalName;
	@JoinColumn(name = "city_id")
	private String city;
	@Column(name = "comments")
	private String comment;
	@Column(name = "user_id")
	private int userId;
	public Feedback() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Feedback(Long feedbackId, String hospitalName, String city, String comment, int userId) {
		super();
		this.feedbackId = feedbackId;
		this.hospitalName = hospitalName;
		this.city = city;
		this.comment = comment;
		this.userId = userId;
	}
	public Long getFeedbackId() {
		return feedbackId;
	}
	public void setFeedbackId(Long feedbackId) {
		this.feedbackId = feedbackId;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	
	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", hospitalName=" + hospitalName + ", city=" + city + ", comment="
				+ comment + ", userId=" + userId + "]";
	}
	
	
	
	
	
	
}
