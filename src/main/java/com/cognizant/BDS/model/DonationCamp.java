package com.cognizant.BDS.model;

import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "donation_camp")
public class DonationCamp {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "camp_id")
	private long id;
	@Column(name = "blood_bank_id")
	private long bloodBankId;
	@Column(name = "blood_bank_name")
	private String organiserName;
	@Column(name = "camp_name")
	private String campName;
	@Column(name = "camp_date")
	private LocalDate date;
	@Column(name = "start_time")
	private LocalTime startTime;
	@Column(name = "end_time")
	private LocalTime endTime;
	@Column(name = "venue")
	private String location;
	@Column(name = "city")
	private String city;
	
}
