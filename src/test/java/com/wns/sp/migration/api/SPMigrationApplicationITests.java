package com.wns.sp.migration.api;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class has contains the integration test cases.
 * @author Dilip
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
				classes = SPMigrationApplication.class
			)
@AutoConfigureMockMvc
@TestPropertySource( locations = "classpath:application.properties")
public class SPMigrationApplicationITests {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SPMigrationApplicationITests.class);
	@Autowired
	MockMvc mockMvc;
	
	ObjectMapper objMapper = new ObjectMapper();
	
	@Test 
	public void iTestGetAllMonthlyMasterBkChangedAttrInterviews() throws Exception{
		MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.get("/api/mmbkchangedattrs")
				.accept(MediaType.APPLICATION_JSON))
				.andReturn();
		LOGGER.debug(" mvcResult.getResponse().getStatus() :: "+mvcResult.getResponse().getStatus());
		LOGGER.debug(" mvcResult.getResponse().getContentAsString() ::  "+mvcResult.getResponse().getContentAsString());
		Assert.assertTrue(mvcResult.getResponse().getStatus() == 200);
	}
	
	
	@Test
	public void iTestUpdateMMBkChangedAttrs() throws Exception {		
		MvcResult result = mockMvc
				.perform(MockMvcRequestBuilders.put("/api/updatemmbkchangeattrs")
						.accept(MediaType.APPLICATION_JSON))
				.andReturn();
		
		LOGGER.debug(" In iTestUpdateMMBkChangedAttrs() result.getResponse().getStatus() ::  "+result.getResponse().getStatus());
		Assert.assertTrue(result.getResponse().getStatus() == 200);
	}
	
}
