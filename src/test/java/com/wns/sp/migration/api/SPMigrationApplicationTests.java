/**
 * 
 */
package com.wns.sp.migration.api;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.wns.sp.migration.api.entity.MonthlyMasterBkChangedAttrInterview;
import com.wns.sp.migration.api.repository.MonthlyMasterBkChangedAttrInterviewRepository;
import com.wns.sp.migration.api.service.IMonthlyMasterBkChangedAttrInterviewService;
import com.wns.sp.migration.api.service.MonthlyMasterBkChangedServiceException;

/**
 * This class has contains the Mockito and JUnit Test Cases.
 * @author Dilip
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SPMigrationApplicationTests {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SPMigrationApplicationTests.class);
	
	@Autowired
	private IMonthlyMasterBkChangedAttrInterviewService service;
	
	@MockBean
	private MonthlyMasterBkChangedAttrInterviewRepository repository;
	
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;

	ObjectMapper objMapper = new ObjectMapper();

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}

	public SPMigrationApplicationTests() {
		super();
	}
	
	/**
	 * Mockito Test Cases
	 * @throws MonthlyMasterBkChangedServiceException
	 */
	@Test
	public void testGetAllMonthlyMasterBkChangedAttrInterviews() throws MonthlyMasterBkChangedServiceException {
		when(repository.findAll()).thenReturn(Stream
				.of(new MonthlyMasterBkChangedAttrInterview(13l, "9PDT18", "OLD", "649cd", "2019", "CRUISER", "JAPAN", "N", "P", "RWD","0"), 
					new MonthlyMasterBkChangedAttrInterview(14l, "9PDT18", "OLD", "649cd", "2019", "CRUISER", "JAPAN", "N", "P", "RWD","0"))
				.collect(Collectors.toList()));
		assertEquals(2, service.getAllMonthlyMasterBkChangedAttrInterviews().size());
	}
	
	/**
	 * Mockito Test Cases
	 * @throws Exception
	 */
	@Test
	public void testGetAllMonthlyMasterBkChangedAttrs() throws Exception {
		
		when(repository.findAll()).thenReturn(Collections.emptyList());		
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get("/api/mmbkchangedattrs").accept(MediaType.APPLICATION_JSON)).andReturn();
		
		LOGGER.debug(" In testGetAllMonthlyMasterBkChangedAttrs() result.getResponse() ::  "+result.getResponse());
		verify(repository).findAll();
	}
	
	/**
	 *  Junit Test Cases
	 * @throws Exception
	 */
	@Test
	public void testUpdateMMBkChangedAttrs() throws Exception {
		
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.put("/api/updatemmbkchangeattrs").accept(MediaType.APPLICATION_JSON)).andReturn();
		
		LOGGER.debug(" In updateMMBkChangedAttrsTest () result.getResponse() ::  "+result.getResponse());
	}
	
	/**
	 *  Nagetive Test Cases. passing id as String format. So it will return 500 internal error
	 * @throws Exception
	 */	
	@Test
	public void testGetAllMonthlyMasterBkChangedByIdGT() throws Exception {
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.get("/api/mmbkchangedid/five").accept(MediaType.APPLICATION_JSON)).andReturn();
				
		String resultContent = result.getResponse().getContentAsString();
		
		LOGGER.debug(" In testGetAllMonthlyMasterBkChangedAttrs() result.getResponse().getStatus() ::  "+result.getResponse().getStatus());
		LOGGER.debug(" In testGetAllMonthlyMasterBkChangedAttrs() return value is ::  "+resultContent);
		Assert.assertTrue(result.getResponse().getStatus() == 200);
	}

}
