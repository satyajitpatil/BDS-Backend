package com.cognizant.BDS.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.BDS.model.Slot;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long> {

		@Query(value = "SELECT slot.slot_id, "
				+ "slot.hospital_name, "
				+ "city.city, " 
				+ "slot.date, "
				+ "slot.time, "
				+ "slot.donor_id "
				+ "FROM slot, city " 
				+ "WHERE slot.city_id = city.id;", nativeQuery = true)
		public Set<Slot> getAllSlot();
		
		@Query(value = "SELECT id from city where city=?;",nativeQuery = true)
		public int getCityIdByCityName(String cityName);
		
		@Query(value = "select count(slot.slot_id) from slot where slot.hospital_name=? and slot.city_id=? and slot.date=? and slot.time =?;",nativeQuery = true)
		public Long getCountOfSlotByInput(String hospitalName, int cityId, String date, String time);
		
		
		//insert slot
		@Modifying
		@Transactional
		@Query(value = "INSERT INTO slot (hospital_name, city_id, date, time, donor_id) values(?,?,?,?,?);", nativeQuery = true)
		public int insertSlot(String hospitalName, int city_id , String date, String time, int donorId);
		
		
	}

	

