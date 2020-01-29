package com.cognizant.BDS.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.BDS.model.BloodBank;
import com.cognizant.BDS.model.User;

@Repository
public interface BloodBankRepository extends JpaRepository<BloodBank, Long> {

	@Query(value = "select b.blood_bank_id, " 
			+ "b.blood_bank_name, " 
			+ "s.state, " 
			+ "b.area, " 
			+ "b.pincode, "
			+ "b.contact_number, "
			+ "b.password "
			+ "from blood_bank b , state s "
			+ "where b.state_id = s.state_id  and area = ?;", nativeQuery = true)
	public Set<BloodBank> getBloodBanksByCity(String city);

	@Query(value = "select b.blood_bank_id, b.blood_bank_name, s.state, b.area, b.pincode, b.contact_number, b.password from blood_bank b, state s where b.state_id = s.state_id AND b.blood_bank_name = ?", nativeQuery = true)
	Optional<BloodBank> findBloodBank(String bloodBankName);
	
	@Query(value = "select b.blood_bank_id, b.blood_bank_name, s.state, b.area, b.pincode, b.contact_number, b.password from blood_bank b, state s where b.state_id = s.state_id AND b.blood_bank_name = ?", nativeQuery = true)
	public BloodBank getBloodBankByName(String bloodBankName);

	@Modifying
	@Transactional
	@Query(value = "Insert into blood_bank(blood_bank_name, contact_number, password, state_id, area, pincode) values (?,?,?,?,?,?)", nativeQuery = true)
	public Integer addBloodBank(String bloodBankName, long contactNumber, String password, int stateId, String area,
			int pincode);
	
	@Modifying
	@Transactional
	@Query(value = "insert into available_blood(blood_group,blood_bank_name,state_id,area,pincode,contact_number,units) value(?,?,?,?,?,?,?);", nativeQuery = true)
	public void addDefaultBloodGroupsWithUnits(String bloodGroup,String bloodBankName, int stateId,String city,int pincode,long contactNumber,int units);

}
