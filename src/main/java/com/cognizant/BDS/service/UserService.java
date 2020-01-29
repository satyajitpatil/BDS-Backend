package com.cognizant.BDS.service;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.BDS.model.User;
import com.cognizant.BDS.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	public UserService() {
		
	}
	
	public Integer getCountOfDonors() {
		return userRepository.getCountOfDonors();				
	}
	
	public Set<User> getDonors(String city,String bloodGroup){
		return userRepository.getDonors(city,bloodGroup);
	}
	
	
}
