package com.cognizant.BDS.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.BDS.model.AvailableBlood;

public interface AvailableBloodRepository extends JpaRepository<AvailableBlood, Long> {

	@Query(value = "Select available_blood.blood_id, " + "available_blood.blood_group, "
			+ "available_blood.blood_bank_name, " + "state.state, " + "available_blood.area, "
			+ "available_blood.pincode, " + "available_blood.contact_number, " + "available_blood.units "
			+ "FROM available_blood, state " + "where available_blood.state_id = state.state_id;", nativeQuery = true)
	public Set<AvailableBlood> getAvailableBlood();

	// get units of bloodGroup for admin
	@Query(value = "select sum(units) from available_blood where blood_group = ?;", nativeQuery = true)
	public Integer getAvailableBloodByBloodGroupForAdmin(String bloodGroup);

	// get units of bloodGroup for hospital
	@Query(value = "select units from available_blood where blood_group = ? and blood_bank_name = ?;", nativeQuery = true)
	public Integer getAvailableBloodByBloodGroupForHospital(String bloodGroup, String bloodBankName);

	// get units of all bloodGroups for admin
	@Query(value = "select sum(units) from available_blood;", nativeQuery = true)
	public Integer getAvailableBloodByAllBloodGroupForAdmin();

	// get request by blood group,area
	@Query(value = "Select available_blood.blood_id, " + "available_blood.blood_group, "
			+ "available_blood.blood_bank_name, " + "state.state, " + "available_blood.area, "
			+ "available_blood.pincode, " + "available_blood.contact_number, " + "available_blood.units "
			+ "FROM available_blood, state " + "where available_blood.state_id = state.state_id "
			+ "and available_blood.blood_group = ? " + "and available_blood.area = ? ;", nativeQuery = true)
	public Set<AvailableBlood> getAvailableBloodByStateAndArea(String bloodGroup, String area);

	@Query(value = "Select available_blood.blood_id, " + "available_blood.blood_group, "
			+ "available_blood.blood_bank_name, " + "state.state, " + "available_blood.area, "
			+ "available_blood.pincode, " + "available_blood.contact_number, " + "available_blood.units "
			+ "FROM available_blood, state " + "where available_blood.state_id = state.state_id "
			+ "and available_blood.blood_id = ?;", nativeQuery = true)
	public AvailableBlood getAvailableBloodById(int id);

	@Modifying
	@Transactional
	@Query(value = "update available_blood set units = units - 1 where blood_id = ? and units>0;", nativeQuery = true)
	public void decreamentBloodStockByOne(int id);

	@Modifying
	@Transactional
	@Query(value = "update available_blood set units = ? where blood_group = ? and blood_bank_name = ?;", nativeQuery = true)
	public void updateUnitsByHospital(int units, String bloodGroup, String bloodBankName);
}
