package com.cognizant.BDS.service;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import com.cognizant.BDS.model.AvailableBlood;
import com.cognizant.BDS.repository.AvailableBloodRepository;


import static org.mockito.Mockito.*;
import java.util.HashSet;
import java.util.Set;

@RunWith(MockitoJUnitRunner.class)
public class AvailableBloodServiceTest {
  
  @InjectMocks
  private AvailableBloodService AvailableBloodService;
  
  @Mock
  private AvailableBloodRepository AvailableBloodRepository;

  @Before
  public void setUp() throws Exception {}

  /*
   * @Test public void testAvailableBloodService() { fail("Not yet implemented"); }
   */

  @Test
  public void testGetAvailableBlood() {
    
    AvailableBlood ab1 = new AvailableBlood();
    AvailableBlood ab2 = new AvailableBlood();
    
    Set<AvailableBlood> lab = new HashSet<AvailableBlood>();
    lab.add(ab1);
    lab.add(ab2);
    
    when(AvailableBloodRepository.getAvailableBlood()).thenReturn(lab);
    
    assertNotNull(AvailableBloodService.getAvailableBlood());
    
    verify(AvailableBloodRepository).getAvailableBlood();
    
  }

  /*
   * @Test public void testGetAvailableBloodByBloodGroupForAdmin() { fail("Not yet implemented"); }
   * 
   * @Test public void testGetAvailableBloodByStateAndArea() { fail("Not yet implemented"); }
   * 
   * @Test public void testGetAvailableBloodById() { fail("Not yet implemented"); }
   * 
   * @Test public void testDecreamentBloodStockByOne() { fail("Not yet implemented"); }
   * 
   * @Test public void testUpdateUnitsByHospital() { fail("Not yet implemented"); }
   * 
   * @Test public void testGetAvailableBloodByBloodGroupForHospital() { fail("Not yet implemented");
   * }
   */

}
