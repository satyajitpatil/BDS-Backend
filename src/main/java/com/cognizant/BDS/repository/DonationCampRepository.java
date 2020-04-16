package com.cognizant.BDS.repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.cognizant.BDS.model.DonationCamp;

@Repository
public interface DonationCampRepository extends JpaRepository<DonationCamp, Long> {

  @Query(
      value = "select camp_id,"
          + "blood_bank_id," 
          + "blood_bank_name,"
          + "camp_name," 
          + "camp_date," 
          + "venue,"
          + "start_time," 
          + "end_time,"
          + "city " 
          + "from donation_camp " 
          + "where camp_date >= curdate() and "
          + "city = ?;",
          nativeQuery = true)
  public List<DonationCamp> getUpcomingDonationCamps(String city);

  @Modifying
  @Transactional
  @Query(value = "insert into register_donor_to_camps(camp_id,donor_id) values(?,?);", nativeQuery = true)
  public void registerForDonation(int campId,int donorId);
  
  @Query(value = "select count(*) from register_donor_to_camps where camp_id = ? and donor_id = ?;", nativeQuery = true)
  public int checkIfAlreadyRegistered(int campId,int donorId);

  @Query(value = "select camp_id,"
      + "blood_bank_id," 
      + "blood_bank_name,"
      + "camp_name," 
      + "camp_date," 
      + "venue,"
      + "start_time," 
      + "end_time,"
      + "city " 
      + "from donation_camp " 
      + "where camp_id = ?;", nativeQuery = true)
  public DonationCamp getDonationCampById(int id);

  @Modifying
  @Transactional
  @Query(value = "insert into donation_camp("
      + "blood_bank_id,"
      + "blood_bank_name,"
      + "camp_name,"
      + "camp_date,"
      + "venue,"
      + "start_time,"
      + "end_time,"
      + "city)"
      + "values(?,?,?,?,?,?,?,?);", nativeQuery = true)
  public void addDonationCamp(long bloodBankId, String bloodBankName, String campName, LocalDate campDate,String venue,LocalTime startTime,LocalTime endTime,String city);
  
  @Query(value = "select d.camp_id,d.blood_bank_id,d.blood_bank_name,d.camp_name,d.camp_date,d.venue,d.start_time,d.end_time,d.city from donation_camp d, register_donor_to_camps r where d.camp_id = r.camp_id and r.donor_id=?;", nativeQuery = true)
  public List<DonationCamp> getMyRegisteredDonationCamp(int donorId);
  
  @Query(value = "select camp_id,blood_bank_id,blood_bank_name,camp_name,camp_date,venue,start_time,end_time,city from donation_camp where blood_bank_id = ?", nativeQuery = true)
  public List<DonationCamp> getDonationCampsOfBloodBank(int bloodBankId);
  
  
}
