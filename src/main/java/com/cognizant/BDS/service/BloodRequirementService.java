package com.cognizant.BDS.service;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.BDS.model.BloodRequirement;
import com.cognizant.BDS.repository.BloodRequirementRepository;

@Service
public class BloodRequirementService {
                @Autowired
                private BloodRequirementRepository bloodRequirementRepository;

                public BloodRequirementService(BloodRequirementRepository bloodRequirementRepository) {
                                super();
                                this.bloodRequirementRepository = bloodRequirementRepository;
                }
                
                public Integer getTodaysRequest() {
                	LocalDate date = LocalDate.now();
                	return bloodRequirementRepository.getTodaysRequest(date.toString());
                }
                
                public Set<BloodRequirement> getAllBloodRequirement(){
                                return bloodRequirementRepository.getAllBloodRequirement();
                }
                
                public Set<BloodRequirement> getBloodRequirementByStateAndAreaAndBloodGroup(String state, String area, int pincode, String bloodGroup){
                                int stateId = bloodRequirementRepository.getStateIdByStateName(state);
                                return bloodRequirementRepository.getBloodRequirementByStateAndAreaAndBloodGroup(stateId, area, pincode, bloodGroup);
                }

                public Set<BloodRequirement> getBloodRequirementByState(String state) {
                                int stateId = bloodRequirementRepository.getStateIdByStateName(state);
                                return bloodRequirementRepository.getBloodRequirementByState(stateId);
                }

                public  Set<BloodRequirement> getBloodRequirementByStateAndArea(String state, String area) {
                                int stateId = bloodRequirementRepository.getStateIdByStateName(state);
                                return bloodRequirementRepository.getBloodRequirementByStateAndArea(stateId,area);
                }

                public  Set<BloodRequirement> getBloodRequirementByBloodGroup(String bloodGroup) {
                                // TODO Auto-generated method stub
                                return bloodRequirementRepository.getBloodRequirementByBloodGroup(bloodGroup);
                }

                public int addBloodRequirement(BloodRequirement bloodrequirement) {
                                
                                int stateId = bloodRequirementRepository.getStateIdByStateName(bloodrequirement.getState());
                                return bloodRequirementRepository.addBloodRequirement(bloodrequirement.getBloodGroup(),stateId, bloodrequirement.getArea(),bloodrequirement.getPincode(),bloodrequirement.getContactNumber(),bloodrequirement.getRequesterId());
                                
                }
}
