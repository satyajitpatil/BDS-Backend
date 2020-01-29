package com.cognizant.BDS.repository;

import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.BDS.model.BloodRequirement;

public interface BloodRequirementRepository extends JpaRepository<BloodRequirement, Long> {
	
	@Query(value = "select count(*) from blood_requirement",nativeQuery = true)
	public int getTodaysRequest(String date);

       @Query(value = "SELECT blood_requirement.req_id, "
                     + "blood_requirement.blood_group, "
                     + "user.first_name, "
                     + "user.last_name, "
                     + "state.state,"
                     + "blood_requirement.area, "
                     + "blood_requirement.pincode,"
                     + "blood_requirement.contact_number, "
                     + "blood_requirement.user_id "
                     + "FROM blood_requirement "
                     + "inner join state on (state.state_id = blood_requirement.state_id) "
                     + "inner join user on (user.user_id = blood_requirement.user_id); ", nativeQuery = true)
       public Set<BloodRequirement> getAllBloodRequirement();
       
       @Query(value = "SELECT blood_requirement.req_id, "
                     + "blood_requirement.blood_group, "
                     + "user.first_name, "
                     + "user.last_name, "
                     + "state.state,"
                     + "blood_requirement.area, "
                     + "blood_requirement.pincode,"
                     + "blood_requirement.contact_number, "
                     + "blood_requirement.user_id "
                     + "FROM blood_requirement "
                     + "inner join state on (state.state_id = blood_requirement.state_id) "
                     + "inner join user on (user.user_id = blood_requirement.user_id) "
                     + "and blood_requirement.state_id = ? "
                     + "and blood_requirement.area = ? "
                     + "and blood_requirement.pincode = ? "
                     + "and blood_requirement.blood_group = ?;", nativeQuery = true)
       public Set<BloodRequirement> getBloodRequirementByStateAndAreaAndBloodGroup(int stateId, String area, int pincode, String bloodGroup);



       @Query(value = "SELECT blood_requirement.req_id, "
                     + "blood_requirement.blood_group, "
                     + "user.first_name, "
                     + "user.last_name, "
                     + "state.state,"
                     + "blood_requirement.area, "
                     + "blood_requirement.pincode,"
                     + "blood_requirement.contact_number, "
                     + "blood_requirement.user_id "
                     + "FROM blood_requirement "
                     + "inner join state on (state.state_id = blood_requirement.state_id) "
                     + "inner join user on (user.user_id = blood_requirement.user_id) "
                     + "and blood_requirement.state_id = ? ;", nativeQuery = true)
       public Set<BloodRequirement> getBloodRequirementByState(int stateId);

       @Query(value = "SELECT blood_requirement.req_id, "
                     + "blood_requirement.blood_group, "
                     + "user.first_name, "
                     + "user.last_name, "
                     + "state.state,"
                     + "blood_requirement.area, "
                     + "blood_requirement.pincode,"
                     + "blood_requirement.contact_number, "
                     + "blood_requirement.user_id "
                     + "FROM blood_requirement "
                     + "inner join state on (state.state_id = blood_requirement.state_id) "
                     + "inner join user on (user.user_id = blood_requirement.user_id) "
                     + "and blood_requirement.state_id = ? "
                     + "and blood_requirement.area = ?; "
                     , nativeQuery = true)
       public Set<BloodRequirement> getBloodRequirementByStateAndArea(int stateId, String area);

       @Query(value = "SELECT blood_requirement.req_id, "
                     + "blood_requirement.blood_group, "
                     + "user.first_name, "
                     + "user.last_name, "
                     + "state.state,"
                     + "blood_requirement.area, "
                     + "blood_requirement.pincode,"
                     + "blood_requirement.contact_number, "
                     + "blood_requirement.user_id "
                     + "FROM blood_requirement "
                     + "inner join state on (state.state_id = blood_requirement.state_id) "
                     + "inner join user on (user.user_id = blood_requirement.user_id) "
                     + "and blood_requirement.blood_group = ?;", nativeQuery = true)   
       public Set<BloodRequirement> getBloodRequirementByBloodGroup(String bloodGroup);
       
       
       @Query(value = "SELECT state_id from state where state=?;",nativeQuery = true)
       public int getStateIdByStateName(String stateName);
       
       
       @Modifying
       @Transactional
       @Query(value = "INSERT INTO blood_requirement (blood_group, state_id, area, pincode,contact_number,user_id) values(?,?,?,?,?,?);", nativeQuery = true)
       int addBloodRequirement(String blood_group, int state_id , String area, int pincode,long contact_number,long user_id);
       
}

