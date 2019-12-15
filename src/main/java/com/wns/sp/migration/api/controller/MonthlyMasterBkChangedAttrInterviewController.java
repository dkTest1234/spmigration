/**
 * 
 */
package com.wns.sp.migration.api.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wns.sp.migration.api.entity.MonthlyMasterBkChangedAttrInterview;
import com.wns.sp.migration.api.exceptionhandling.ResourceNotFoundException;
import com.wns.sp.migration.api.service.IMonthlyMasterBkChangedAttrInterviewService;
import com.wns.sp.migration.api.service.MonthlyMasterBkChangedServiceException;

/**
 * This is the controller class defined with all required apis.
 * @author Dilip
 *
 */
@RestController
@RequestMapping("/api")
public class MonthlyMasterBkChangedAttrInterviewController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MonthlyMasterBkChangedAttrInterviewController.class);
	
	private IMonthlyMasterBkChangedAttrInterviewService mMBkChangedAttrInterviewService;	
	
	/**
	 * Constructor 
	 * @param IMonthlyMasterBkChangedAttrInterviewService
	 */
	public MonthlyMasterBkChangedAttrInterviewController(
			IMonthlyMasterBkChangedAttrInterviewService mMBkChangedAttrInterviewService) {
		super();
		this.mMBkChangedAttrInterviewService = mMBkChangedAttrInterviewService;
	}
	
	
	/**
	 * 
	 * This api is used to fetch all the records from the db.
	 * @return ResponseEntity<List<MonthlyMasterBkChangedAttrInterview>>
	 * @throws MonthlyMasterBkChangedServiceException
	 * @throws ResourceNotFoundException
	 */
	@GetMapping(path="/mmbkchangedattrs", produces = "application/json")
	public ResponseEntity<List<MonthlyMasterBkChangedAttrInterview>> getAllMonthlyMasterBkChangedAttrs() 
			throws MonthlyMasterBkChangedServiceException, ResourceNotFoundException {
		
		LOGGER.debug(" getAllMonthlyMasterBkChangedAttrs() invoked. ");
		
		List<MonthlyMasterBkChangedAttrInterview> mMBkChangedAttrInterviews = fetchAllMMBkChangedAttrs();
		LOGGER.debug("Total records fetched " + mMBkChangedAttrInterviews.size());
		return new ResponseEntity<List<MonthlyMasterBkChangedAttrInterview>>(mMBkChangedAttrInterviews, HttpStatus.OK);
	}

	/**
	 * private method to fetch all the records.
	 * 
	 * @return List<MonthlyMasterBkChangedAttrInterview>
	 * @throws MonthlyMasterBkChangedServiceException
	 * @throws ResourceNotFoundException
	 */
	private List<MonthlyMasterBkChangedAttrInterview> fetchAllMMBkChangedAttrs()
			throws MonthlyMasterBkChangedServiceException, ResourceNotFoundException {
		List<MonthlyMasterBkChangedAttrInterview> mMBkChangedAttrInterviews = 
				mMBkChangedAttrInterviewService.getAllMonthlyMasterBkChangedAttrInterviews();
		
		if (mMBkChangedAttrInterviews == null || mMBkChangedAttrInterviews.size() == 0) {
			throw new ResourceNotFoundException("Data not found");
		}
		return mMBkChangedAttrInterviews;
	}
	
	
	/**
	 * This api is used to fetch all the records those id is greater than passing id.
	 * @return ResponseEntity<List<MonthlyMasterBkChangedAttrInterview>>
	 * @throws MonthlyMasterBkChangedServiceException
	 * @throws ResourceNotFoundException
	 */
	@GetMapping("/mmbkchangedid/{id}")
	public ResponseEntity<List<MonthlyMasterBkChangedAttrInterview>> getAllMonthlyMasterBkChangedByIdGT(@PathVariable long id) 
			throws MonthlyMasterBkChangedServiceException, ResourceNotFoundException {
		
		LOGGER.debug(" getAllMonthlyMasterBkChangedID() invoked. ");
		
		List<MonthlyMasterBkChangedAttrInterview> mMBkChangedAttrInterviews = 
				mMBkChangedAttrInterviewService.findByIdGT(id);
		LOGGER.debug("Total records fetched " + mMBkChangedAttrInterviews.size());
		
		if (mMBkChangedAttrInterviews == null || mMBkChangedAttrInterviews.size() == 0) {
			throw new ResourceNotFoundException("Data not found");
		}
		return new ResponseEntity<List<MonthlyMasterBkChangedAttrInterview>>(mMBkChangedAttrInterviews, HttpStatus.OK);
	}
	
	
	/**
	 * This api is used to process the logic of Stored Procedure. 
	 * It is updating all records those are reflecting with sql where condition.
	 * @return String
	 * @throws MonthlyMasterBkChangedServiceException
	 * @throws ResourceNotFoundException
	 */
	@PutMapping("/updatemmbkchangeattrs")
	public String updateMMBkChangedAttrs() throws MonthlyMasterBkChangedServiceException, ResourceNotFoundException {

		LOGGER.debug(" updateMMBkChangedAttrs() invoked. ");

		fetchAllMMBkChangedAttrs();
		
		mMBkChangedAttrInterviewService.updateMMBkChangedAttrInterview();

		return "Update Process completed.";
	}
	
}
