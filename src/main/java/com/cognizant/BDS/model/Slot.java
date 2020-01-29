package com.cognizant.BDS.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SecondaryTable;
import javax.persistence.Table;

@Entity
@Table(name="slot")
public class Slot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="slot_id")
	private long slotId;
	@Column(name="hospital_name")
	private String hospitalName;
	@JoinColumn(name="city_id")
	private String city;
	@Column(name="date")
	private LocalDate date;
	@Column(name="time")
	private LocalTime time;
	@Column(name="donor_id")
	private int donorId;
	
	public Slot(Long slotId, String hospitalName, String city, LocalDate date, LocalTime time, int donorId) {
		super();
		this.slotId = slotId;
		this.hospitalName = hospitalName;
		this.city = city;
		this.date = date;
		this.time = time;
		this.donorId = donorId;
	}

	
	public Slot() {
		
	}


	public Long getSlotId() {
		return slotId;
	}

	public void setSlotId(Long slotId) {
		this.slotId = slotId;
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

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	public int getDonorId() {
		return donorId;
	}

	public void setDonorId(int donorId) {
		this.donorId = donorId;
	}
	
	
	
	
	
	
}
