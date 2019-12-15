/**
 * 
 */
package com.wns.sp.migration.api.service;

import java.util.List;

import com.wns.sp.migration.api.entity.MonthlyMasterBkChangedAttrInterview;

/**
 * service interface
 * @author Dilip
 *
 */
public interface IMonthlyMasterBkChangedAttrInterviewService {
	
	public List<MonthlyMasterBkChangedAttrInterview> getAllMonthlyMasterBkChangedAttrInterviews() throws MonthlyMasterBkChangedServiceException;
	
	public void updateMMBkChangedAttrInterview() throws MonthlyMasterBkChangedServiceException;
	
	public List<MonthlyMasterBkChangedAttrInterview> findByIdGT(Long id) throws MonthlyMasterBkChangedServiceException;
	
}
