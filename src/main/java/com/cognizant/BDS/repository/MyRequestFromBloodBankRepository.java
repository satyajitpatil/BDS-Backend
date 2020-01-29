package com.cognizant.BDS.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.BDS.model.MyRequestFromBloodBank;

@Repository
public interface MyRequestFromBloodBankRepository extends JpaRepository<MyRequestFromBloodBank, Long>{
	
	@Query(value = "select m.mapping_id, "
			+ "m.available_blood_id, "
			+ "a.blood_group, "
			+ "u.first_name, "
			+ "u.last_name, "
			+ "b.blood_bank_name, "
			+ "m.is_approved, "
			+ "m.is_rejected, "
			+ "m.is_pending "
			+ "FROM blood_request_from_bank_mapping m "
			+ "inner join available_blood a on (a.blood_id = m.available_blood_id) " 
			+ "inner join blood_bank b on (b.blood_bank_id = m.blood_bank_id) "
			+ "inner join user u on (u.user_id = m.requestor_id) "
			+ "where requestor_id = ?;",nativeQuery = true)
	public Set<MyRequestFromBloodBank> getMyRequests(int userId);
	
	@Query(value="select m.mapping_id, "
			+ "m.available_blood_id, "
			+ "a.blood_group, "
			+ "u.first_name, "
			+ "u.last_name, "
			+ "b.blood_bank_name, "
			+ "m.is_approved, "
			+ "m.is_rejected, "
			+ "m.is_pending "
			+ "FROM blood_request_from_bank_mapping m "
			+ "inner join available_blood a on (a.blood_id = m.available_blood_id) "
			+ "inner join blood_bank b on (b.blood_bank_id = m.blood_bank_id) "
			+ "inner join user u on (u.user_id = m.requestor_id) "
			+ "where m.blood_bank_id = ? and m.is_pending = 1;",nativeQuery=true)
	public Set<MyRequestFromBloodBank> getHospitalsPendingRequests(int bloodBankId);
	
	@Modifying
	@Transactional
	@Query(value = "update blood_request_from_bank_mapping set is_approved = 1 ,is_rejected = 0 ,is_pending = 0 where mapping_id = ?;",nativeQuery = true)
	public int accept(int id);
	
	@Modifying
	@Transactional
	@Query(value = "update blood_request_from_bank_mapping set is_approved = 0 ,is_rejected = 1 ,is_pending = 0 where mapping_id = ?;",nativeQuery = true)
	public int reject(int id);
	
	@Modifying
	@Transactional
	@Query(value = "insert into blood_request_from_bank_mapping (available_blood_id,requestor_id,blood_bank_id,is_approved,is_rejected,is_pending) values(?,?,?,?,?,?);",nativeQuery = true)
	public int requestBlood(int availableBloodid ,int requestorId ,int bloodBankId, boolean isApproved, boolean isRejected, boolean isPending);
}
