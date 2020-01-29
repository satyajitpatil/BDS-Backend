package com.cognizant.BDS.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.BDS.model.MyRequestFromBloodBank;
import com.cognizant.BDS.repository.MyRequestFromBloodBankRepository;

@Service
public class MyRequestFromBloodBankService {
	
	@Autowired
	private MyRequestFromBloodBankRepository myRequestFromBloodBankRepository;
	
	
	
	public MyRequestFromBloodBankService(MyRequestFromBloodBankRepository myRequestFromBloodBankRepository) {
		super();
		this.myRequestFromBloodBankRepository = myRequestFromBloodBankRepository;
	}



	public Set<MyRequestFromBloodBank> getMyRequests(int userId){
		System.out.println(myRequestFromBloodBankRepository.getMyRequests(userId));
		return myRequestFromBloodBankRepository.getMyRequests(userId);		
	}
	
	public Set<MyRequestFromBloodBank> getHospitalsPendingRequests(int bloodBankId){
		System.out.println(myRequestFromBloodBankRepository.getHospitalsPendingRequests(bloodBankId));
		return myRequestFromBloodBankRepository.getHospitalsPendingRequests(bloodBankId);	
	}
	
	public int accept(int id)
	{
		return myRequestFromBloodBankRepository.accept(id);
	}
	public int reject(int id)
	{
		return myRequestFromBloodBankRepository.reject(id);
	}
	
	public void requestBlood(int userId, int bloodBankId, int availableBloodId) {
		myRequestFromBloodBankRepository.requestBlood(availableBloodId,userId,bloodBankId,false,false,true);
	}
}
