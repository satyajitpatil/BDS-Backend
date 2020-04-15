package com.cognizant.BDS.controller;

import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.cognizant.BDS.model.DonationCamp;
import com.cognizant.BDS.service.DonationCampService;

@RestController
public class DonationCampController {

  @Autowired
  private DonationCampService donationCampService;

  public DonationCampController() {
    super();
  }

  @GetMapping(value = "/donation-camp/upcoming/{city}")
  public ResponseEntity<List<DonationCamp>> getUpcomingDonationCamps(@PathVariable("city") String city) {
    return new ResponseEntity<List<DonationCamp>>(donationCampService.getUpcomingDonationCamps(city),HttpStatus.OK);
  }

  @GetMapping(value = "/donation-camp/register/{donorId}/{campId}")
  public void registerForDOnation(@PathVariable("donorId") int donorId, @PathVariable("campId") int campId) throws Exception{
    donationCampService.registerForDOnation(donorId,campId);
  }

  @GetMapping(value = "/donation-camp/by-id/{id}")
  public ResponseEntity<DonationCamp> getDonationDetail(@PathVariable("id") int id) {
    return new ResponseEntity<DonationCamp>(donationCampService.getDonationDetail(id),HttpStatus.OK);
  }

  @PostMapping(value = "/donation-camp")
  public void addDonationCamp(@RequestBody DonationCamp donationCamp) {
    donationCampService.addDonationCamp(donationCamp);
  }
  
  @GetMapping(value = "/donation-camp/Registered/{id}")
  public ResponseEntity<List<DonationCamp>> getMyRegisteredDonationCamp(@PathVariable("id") int id) {
    return new ResponseEntity<List<DonationCamp>>(donationCampService.getMyRegisteredDonationCamp(id),HttpStatus.OK);
  }
}
