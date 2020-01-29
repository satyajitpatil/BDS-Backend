package com.cognizant.BDS.service;

import com.cognizant.BDS.repository.AvailableBloodRepository;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cognizant.BDS.model.AvailableBlood;

@Service
public class AvailableBloodService {
	
	@Autowired
	private AvailableBloodRepository availableBloodRepository;

	public AvailableBloodService() {
		
	}
	
	public Set<AvailableBlood> getAvailableBlood(){
		//System.out.println(availableBloodRepository.getAvailableBlood());
		return availableBloodRepository.getAvailableBlood();
	}	
	
	
	//get blood units for admin
	public Integer getAvailableBloodByBloodGroupForAdmin(String bloodGroup) {
		Integer sum = 0;
		if(bloodGroup.equals("ALL")) {
			sum = availableBloodRepository.getAvailableBloodByAllBloodGroupForAdmin();		
			if(sum!=null) {
				return sum;
			}
			else {
				sum = 0;
			}
		}
		else {
			sum = availableBloodRepository.getAvailableBloodByBloodGroupForAdmin(bloodGroup);		
			if(sum!=null) {
				return sum;
			}
			else {
				sum = 0;
			}
		}
				
		return sum;
	}
	
	//by state and area
	public Set<AvailableBlood> getAvailableBloodByStateAndArea(String bloodGroup, String area){
		return availableBloodRepository.getAvailableBloodByStateAndArea(bloodGroup, area);
	}
	
	public AvailableBlood getAvailableBloodById(int id){
		return availableBloodRepository.getAvailableBloodById(id);
	}
	
	public void decreamentBloodStockByOne(int id) {
		availableBloodRepository.decreamentBloodStockByOne(id);
	}
	
	public void updateUnitsByHospital(String type, int unit, String bloodBankName) {
		availableBloodRepository.updateUnitsByHospital(unit,type,bloodBankName);
	}
	
	public Integer getAvailableBloodByBloodGroupForHospital(String bloodGroup, String bloodBankName) {
		return availableBloodRepository.getAvailableBloodByBloodGroupForHospital(bloodGroup, bloodBankName);
	}
	
}
