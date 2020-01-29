package com.cognizant.BDS.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.BDS.model.BloodRequirement;
import com.cognizant.BDS.service.BloodRequirementService;

@RestController
@RequestMapping(value="/bloodRequirement")
public class BloodRequirementController {
                @Autowired
                private BloodRequirementService bloodRequirementService;
                
                public BloodRequirementController()
                {}

                @GetMapping(value = "/getTodaysRequest")
                public ResponseEntity<Integer> getTodaysRequest(){
                	return new ResponseEntity<Integer>(bloodRequirementService.getTodaysRequest(),HttpStatus.OK);
                }

                @RequestMapping()
                public ResponseEntity<Set<BloodRequirement>> getAllBloodRequirement(){
                                return new ResponseEntity<Set<BloodRequirement>>(bloodRequirementService.getAllBloodRequirement(),HttpStatus.OK);
                }
                
                @GetMapping(value = "/sapb/{state}/{area}/{pincode}/{bloodGroup}")
                public ResponseEntity<Set<BloodRequirement>> getBloodRequirementByStateAndAreaAndBloodGroup(@PathVariable("state") String state, @PathVariable("area") String area, @PathVariable("pincode") int pincode, @PathVariable("bloodGroup") String bloodGroup){
                                return new ResponseEntity<Set<BloodRequirement>>(bloodRequirementService.getBloodRequirementByStateAndAreaAndBloodGroup(state, area, pincode, bloodGroup),HttpStatus.OK);
                }
                @GetMapping(value ="/s/{state}")
                public ResponseEntity<Set<BloodRequirement>> getBloodRequirementByState(@PathVariable("state") String state)
                {
                                return new ResponseEntity<Set<BloodRequirement>>(bloodRequirementService.getBloodRequirementByState(state),HttpStatus.OK);
                }
                @GetMapping(value ="/sa/{state}/{area}")
                public ResponseEntity<Set<BloodRequirement>> getBloodRequirementByStateAndArea(@PathVariable("state") String state,@PathVariable("area") String area)
                {
                                return new ResponseEntity<Set<BloodRequirement>>(bloodRequirementService.getBloodRequirementByStateAndArea(state,area),HttpStatus.OK);
                }
                @GetMapping(value ="/b/{bloodGroup}")
                public ResponseEntity<Set<BloodRequirement>> getBloodRequirementByBloodGroup(@PathVariable("bloodGroup") String bloodGroup)
                {
                                return new ResponseEntity<Set<BloodRequirement>>(bloodRequirementService.getBloodRequirementByBloodGroup(bloodGroup),HttpStatus.OK);
                }
                
                @PostMapping(value="/postRequirement")
                public void addBloodRequirement(@RequestBody BloodRequirement bloodrequirement) {
                                bloodRequirementService.addBloodRequirement(bloodrequirement);
                                
                }
}
