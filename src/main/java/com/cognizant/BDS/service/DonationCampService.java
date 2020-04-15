package com.cognizant.BDS.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cognizant.BDS.model.DonationCamp;
import com.cognizant.BDS.repository.DonationCampRepository;

@Service
public class DonationCampService {
	
	@Autowired
	private DonationCampRepository donationCampRepository;

	public DonationCampService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<DonationCamp> getUpcomingDonationCamps(String city){
		return donationCampRepository.getUpcomingDonationCamps(city);
	}
	
	public void registerForDOnation(int donorId, int campId) throws Exception {
	  
	 int val = donationCampRepository.checkIfAlreadyRegistered(campId, donorId);
	 System.out.println("val --- "+val);
	 if(val == 0) {
		donationCampRepository.registerForDonation(campId,donorId); 
		System.out.println("val --- registered");
     }
	 else {
	   throw new Exception("not zero");
	 }
	}
	
	public DonationCamp getDonationDetail(int id) {
		return donationCampRepository.getDonationCampById(id);
	}
	
	public void addDonationCamp(DonationCamp donationCamp){
	  donationCampRepository.addDonationCamp(donationCamp.getBloodBankId(), donationCamp.getOrganiserName(), donationCamp.getCampName(), donationCamp.getDate(), donationCamp.getLocation(), donationCamp.getStartTime(), donationCamp.getEndTime());
	}
	
	public List<DonationCamp> getMyRegisteredDonationCamp(int donorId) {
	  return donationCampRepository.getMyRegisteredDonationCamp(donorId);
	}
}
