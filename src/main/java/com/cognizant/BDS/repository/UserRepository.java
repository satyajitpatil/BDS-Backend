package com.cognizant.BDS.repository;

import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.BDS.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "SELECT user.user_id, " + "user.user_name, " + "user.first_name, " + "user.last_name, "
			+ "user.age, " + "user.gender, " + "user.contact_number, " + "user.email, " + "user.password, "
			+ "user.weight, " + "state.state, " + "user.area, " + "user.pincode, " + "user.blood_group ,"
			+ "user.is_donor " + "FROM user,state "
			+ "WHERE user.state_id = state.state_id AND user_name=?;", nativeQuery = true)
	Optional<User> findUserByUsername(String username);

	@Modifying
	@Transactional
	@Query(value = "Insert into user(user_name, first_name, last_name, age, gender, contact_number, email, password, weight, state_id, area, pincode, blood_group) values (?,?,?,?,?,?,?,?,?,?,?,?,?)", nativeQuery = true)
	Integer addUser(String userName, String firstName, String lastName, int age, String gender, long contactNumber,
			String email, String password, double weight, int stateId, String area, int pincode, String blooGroup);

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO user_role (ur_us_id, ur_ro_id) values (?,?)", nativeQuery = true)
	Integer addUserRole(long userId, long rollId);

	@Query(value = "SELECT state_id from state where state=?;", nativeQuery = true)
	public int getStateIdByStateName(String stateName);

	/*
	 * @Query(value =
	 * "SELECT user_id from user where user_name = ?;",nativeQuery = true)
	 * public int getUserIdByUserName(String userName);
	 */

	@Query(value = "SELECT user.user_id, " + "user.user_name, " + "user.first_name, " + "user.last_name, "
			+ "user.age, " + "user.gender, " + "user.contact_number, " + "user.email, " + "user.password, "
			+ "user.weight, " + "state.state, " + "user.area, " + "user.pincode, " + "user.blood_group,"
			+ "user.is_donor " + "FROM user,state "
			+ "WHERE user.state_id = state.state_id AND user_name=?;", nativeQuery = true)
	public User getUserByUsername(String username);

	@Modifying
	@Transactional
	@Query(value = "UPDATE user SET is_donor = 1 " + "WHERE user_id = ?;", nativeQuery = true)
	public int updateToDonor(int userId);
	
	@Query(value = "select count(*) from user where is_donor = 1;", nativeQuery = true)
	public int getCountOfDonors();
	
	@Query(value = "SELECT user.user_id, " + "user.user_name, " + "user.first_name, " + "user.last_name, "
			+ "user.age, " + "user.gender, " + "user.contact_number, " + "user.email, " + "user.password, "
			+ "user.weight, " + "state.state, " + "user.area, " + "user.pincode, " + "user.blood_group,"
			+ "user.is_donor " + "FROM user,state "
			+ "WHERE user.state_id = state.state_id AND is_donor=1 AND user.area = ? AND user.blood_group = ?;", nativeQuery = true)
	public Set<User> getDonors(String city, String bloodGroup);
}
