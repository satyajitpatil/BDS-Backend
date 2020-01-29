package com.cognizant.BDS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.BDS.model.FAQ;

@Repository
public interface CityAndStateRepository extends JpaRepository<FAQ, Long> {
	
	@Query(value = "select state from state;", nativeQuery = true)
	public List<String> getStates();
	
	@Query(value = "select city from city where state_id = ?;", nativeQuery = true)
	public List<String> getCitiesByStates(int stateId);
	
	@Query(value = "select city from city;", nativeQuery = true)
	public List<String> getCities();
	
	@Query(value = "select state_id from state where state = ?;", nativeQuery = true)
	public int getStateIdByState(String state);

}
