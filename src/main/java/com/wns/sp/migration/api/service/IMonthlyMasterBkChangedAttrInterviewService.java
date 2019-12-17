/**
 * 
 */
package com.wns.sp.migration.api.service;

import java.util.List;

import com.wns.sp.migration.api.entity.MonthlyMasterBkChangedAttrInterview;

/**
 * service interface to provide the migration service
 * @author Dilip
 *
 */
public interface IMonthlyMasterBkChangedAttrInterviewService {
	
	// This method is used to fetch all the records from the database.
	public List<MonthlyMasterBkChangedAttrInterview> getAllMonthlyMasterBkChangedAttrInterviews() throws MonthlyMasterBkChangedServiceException;
	
	//This method is used to update records in the database.
	public void updateMMBkChangedAttrInterview() throws MonthlyMasterBkChangedServiceException;
	
	//This method is used to fetch records from the database those records id value is greater than id parameter value.
	public List<MonthlyMasterBkChangedAttrInterview> findByIdGT(Long id) throws MonthlyMasterBkChangedServiceException;
	
}
