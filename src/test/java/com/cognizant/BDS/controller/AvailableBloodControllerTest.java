package com.cognizant.BDS.controller;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.cognizant.BDS.model.AvailableBlood;
import com.cognizant.BDS.repository.AvailableBloodRepository;
import com.cognizant.BDS.service.AppUserDetailService;
import com.cognizant.BDS.service.AvailableBloodService;
import ch.qos.logback.core.status.Status;
import static org.mockito.Mockito.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringRunner.class)
@WebMvcTest(AvailableBloodController.class)
public class AvailableBloodControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @MockBean
  private AvailableBloodService availableBloodService;

  @MockBean
  private AvailableBloodRepository availableBloodRepository;
  
  @MockBean
  private AppUserDetailService appUserDetailService;

  @Before
  public void setUp() throws Exception {}


  @Test
  public void testGetAllAvailableBlood() throws Exception {
    
    AvailableBlood ab1 = new AvailableBlood();
    AvailableBlood ab2 = new AvailableBlood();
    
    Set<AvailableBlood> lab = new HashSet<AvailableBlood>();
    lab.add(ab1);
    lab.add(ab2);
    
    String uri = "/availableblood";
    
   when(availableBloodRepository.getAvailableBlood()).thenReturn(lab);
    
    mockMvc.perform(MockMvcRequestBuilders.get(uri))
    .andExpect(MockMvcResultMatchers.status().is4xxClientError() );
    //.andExpect(MockMvcResultMatchers.jsonPath("").exists());
    
    //verify(availableBloodRepository).getAvailableBlood();
  }

  /*
   * @Test public void testGetAvailableBloodByBloodGroupForAdminString() {
   * fail("Not yet implemented"); }
   * 
   * @Test public void testGetAvailableBloodByBloodGroupForAdminStringString() {
   * fail("Not yet implemented"); }
   * 
   * @Test public void testGetAvailableBloodByStateAndArea() { fail("Not yet implemented"); }
   * 
   * @Test public void testGetAvailableBloodById() { fail("Not yet implemented"); }
   * 
   * @Test public void testDecreamentBloodStockByOne() { fail("Not yet implemented"); }
   * 
   * @Test public void testUpdateUnitsByHospital() { fail("Not yet implemented"); }
   */

}
