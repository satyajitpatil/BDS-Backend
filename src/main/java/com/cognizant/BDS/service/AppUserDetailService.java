package com.cognizant.BDS.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.cognizant.BDS.controller.AuthenticationController;
import com.cognizant.BDS.model.BloodBank;
import com.cognizant.BDS.model.User;
import com.cognizant.BDS.repository.BloodBankRepository;
import com.cognizant.BDS.repository.UserRepository;

@Component
public class AppUserDetailService implements UserDetailsService {
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BloodBankRepository bloodBankRepository;

	AppUser appUser;
	User user;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		user = userRepository.findUserByUsername(username).get();
		System.out.println("inside APPUSERDETAILSERVICE " + user);
		if (user == null) {
			LOGGER.info("USER NOT FOUND");
			throw new UsernameNotFoundException("Username not found");
		} else {
			appUser = new AppUser(user);
		}
		System.out.println("inside APPUSERDETAILSERVICE appuser " + appUser);

		return appUser;
	}

	public User getUserByUserName(String userName) {
		User user = userRepository.getUserByUsername(userName);
		user.setPassword("Not Allowed to fetch");
		return user;
	}

	public int registerAsDonor(int userId) {
		return userRepository.updateToDonor(userId);
	}

	// signup as user
	public void signUp(User user) throws Exception {
		Optional<User> userObj = userRepository.findUserByUsername(user.getUserName());

		if (userObj.isPresent()) {
			LOGGER.info("USER NOT FOUND");
			throw new Exception("User already exists");
			// TODO: Custom exception
		} else {
			System.out.println("ifNotPresent");
			String pass = user.getPassword();
			user.setPassword(passwordEncoder().encode(pass));
			// userRepository.save(user);
			int state_id = userRepository.getStateIdByStateName(user.getState());
			System.out.println(state_id);
			userRepository.addUser(user.getUserName(), user.getFirstName(), user.getLastName(), user.getAge(),
					user.getGender(), user.getContactNumber(), user.getEmail(), user.getPassword(), user.getWeight(),
					state_id, user.getArea(), user.getPincode(), user.getBloodGroup());
			System.out.println("ifNotPresent2");
			User newUser = userRepository.findUserByUsername(user.getUserName()).get();
			userRepository.addUserRole(newUser.getUserId(), 1);
			System.out.println("ifNotPresent3");

		}
	}

	// signup as bloodbank
	public void signUpBloodBank(BloodBank bloodBank) throws Exception {
		Optional<BloodBank> bloodBankObj = bloodBankRepository.findBloodBank(bloodBank.getBloodBankName());

		if (bloodBankObj.isPresent()) {
			LOGGER.info("BLOOD BANK already exists");
			throw new Exception("BLOOD BANK already exists");
		} else {
			try {
				System.out.println("ifNotPresent");
				String pass = bloodBank.getPassword();
				bloodBank.setPassword(passwordEncoder().encode(pass));
	
				// get state id
				int state_id = userRepository.getStateIdByStateName(bloodBank.getState());
				System.out.println(state_id);
	
				// add in user table for login purpose
				userRepository.addUser(bloodBank.getBloodBankName(), bloodBank.getBloodBankName(), "", 0, "NO",
						bloodBank.getContactNumber(), "NO-Mail", bloodBank.getPassword(), 0, state_id, bloodBank.getCity(),
						bloodBank.getPincode(), "NO");
	
				// add in blood bank table
				bloodBankRepository.addBloodBank(bloodBank.getBloodBankName(), bloodBank.getContactNumber(),
						bloodBank.getPassword(), state_id, bloodBank.getCity(), bloodBank.getPincode());
				System.out.println("ifNotPresent2");
	
				// add default bloodgroups with units in available_blood table
				String bloodGroups[] = {"B+","A+","O+","AB+","B-","A-","AB-","O-"};
				for(String type:bloodGroups) {
					System.out.println(type);
					bloodBankRepository.addDefaultBloodGroupsWithUnits(type,bloodBank.getBloodBankName(),state_id,bloodBank.getCity(),bloodBank.getPincode(),bloodBank.getContactNumber(),0);
				}
				
	
				// get blood bank from user table
				User newBloodBank = userRepository.findUserByUsername(bloodBank.getBloodBankName()).get();
	
				// add role to blood bank from user table
				userRepository.addUserRole(newBloodBank.getUserId(), 3);
				System.out.println("ifNotPresent3");
			}
			catch(Exception ex) {
				System.out.println("not able to create blood bank account");
			}
		}
	}

	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
