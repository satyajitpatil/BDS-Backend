package com.cognizant.BDS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="blood_requirement")
public class BloodRequirement {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="req_id")
	private long id;
	@Column(name="blood_group")
	private String bloodGroup;
	@JoinColumn(name="first_name")
	private String firstName;
	@JoinColumn(name="last_name")
	private String lastName;
	@JoinColumn(name="state_id")
	private String state;
	@Column(name="area")
	private String area;
	@Column(name="pincode")
	private int pincode;
	@Column(name="contact_number")
	private long contactNumber;
	@Column(name="user_id")
	private int requesterId;//user
	
		

	public BloodRequirement(long id, String bloodGroup, String firstName, String lastName, String state, String area,
			int pincode, long contactNumber, int requesterId) {
		super();
		this.id = id;
		this.bloodGroup = bloodGroup;
		this.firstName = firstName;
		this.lastName = lastName;
		this.state = state;
		this.area = area;
		this.pincode = pincode;
		this.contactNumber = contactNumber;
		this.requesterId = requesterId;
	}


	public BloodRequirement() {
	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getBloodGroup() {
		return bloodGroup;
	}


	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getArea() {
		return area;
	}


	public void setArea(String area) {
		this.area = area;
	}


	public int getPincode() {
		return pincode;
	}


	public void setPincode(int pincode) {
		this.pincode = pincode;
	}


	public long getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}


	public int getRequesterId() {
		return requesterId;
	}


	public void setRequesterId(int requesterId) {
		this.requesterId = requesterId;
	}


	@Override
	public String toString() {
		return "BloodRequirement [id=" + id + ", bloodGroup=" + bloodGroup + ", firstName=" + firstName + ", lastName="
				+ lastName + ", state=" + state + ", area=" + area + ", pincode=" + pincode + ", contactNumber="
				+ contactNumber + ", requesterId=" + requesterId + "]";
	}


	
	
	
	
}
