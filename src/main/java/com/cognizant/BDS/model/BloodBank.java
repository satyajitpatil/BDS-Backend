package com.cognizant.BDS.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "available_blood")
public class BloodBank {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "blood_bank_id")
	private int bloodBankId;
	@Column(name = "blood_bank_name")
	private String bloodBankName;
	@JoinColumn(name = "state_id")
	private String state;
	@Column(name = "area")
	private String city;
	@Column(name = "pincode")
	private int pincode;
	@Column(name = "contact_number")
	private long contactNumber;
	@Column(name = "password")
	private String password;
	
	
	
	public BloodBank() {
		
	}

	

	public BloodBank(int bloodBankId, String bloodBankName, String state, String city, int pincode, long contactNumber,
			String password) {
		super();
		this.bloodBankId = bloodBankId;
		this.bloodBankName = bloodBankName;
		this.state = state;
		this.city = city;
		this.pincode = pincode;
		this.contactNumber = contactNumber;
		this.password = password;
	}



	public int getBloodBankId() {
		return bloodBankId;
	}

	public void setBloodBankId(int bloodBankId) {
		this.bloodBankId = bloodBankId;
	}

	public String getBloodBankName() {
		return bloodBankName;
	}

	public void setBloodBankName(String bloodBankName) {
		this.bloodBankName = bloodBankName;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	@Override
	public String toString() {
		return "BloodBank [bloodBankId=" + bloodBankId + ", bloodBankName=" + bloodBankName + ", state=" + state
				+ ", city=" + city + ", pincode=" + pincode + ", contactNumber=" + contactNumber + ", password="
				+ password + "]";
	}

	
	

	
}
