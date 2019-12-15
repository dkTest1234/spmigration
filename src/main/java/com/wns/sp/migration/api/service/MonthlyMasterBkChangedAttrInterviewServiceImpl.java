/**
 * 
 */
package com.wns.sp.migration.api.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wns.sp.migration.api.entity.MonthlyMasterBkChangedAttrInterview;
import com.wns.sp.migration.api.repository.MonthlyMasterBkChangedAttrInterviewRepository;

/**
 * Api Service class
 * @author Dilip
 *
 */
@Service
@Transactional
public class MonthlyMasterBkChangedAttrInterviewServiceImpl 
					implements IMonthlyMasterBkChangedAttrInterviewService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MonthlyMasterBkChangedAttrInterviewServiceImpl.class);
	
	@Autowired
	private MonthlyMasterBkChangedAttrInterviewRepository monthlyMasterBkChangedAttrInterviewRepo;

	/**
	 * @return List<MonthlyMasterBkChangedAttrInterview>
	 * @throws MonthlyMasterBkChangedServiceException
	 */
	@Override
	public List<MonthlyMasterBkChangedAttrInterview> getAllMonthlyMasterBkChangedAttrInterviews()  throws MonthlyMasterBkChangedServiceException{
		List<MonthlyMasterBkChangedAttrInterview> mMBkChangedAttrInterviews = new ArrayList<>();
		monthlyMasterBkChangedAttrInterviewRepo.findAll().forEach(e -> mMBkChangedAttrInterviews.add(e));
		return mMBkChangedAttrInterviews;
	}

	
	/**
	 * @param id
	 * @return List<MonthlyMasterBkChangedAttrInterview>
	 * @throws MonthlyMasterBkChangedServiceException
	 */
	@Override
	public List<MonthlyMasterBkChangedAttrInterview> findByIdGT(Long id)  throws MonthlyMasterBkChangedServiceException{
		
		List<MonthlyMasterBkChangedAttrInterview> mMBkChangedAttrInterviews = 
				monthlyMasterBkChangedAttrInterviewRepo.findByIdGT(id)
														.stream()
														.collect(Collectors.toList());
		return mMBkChangedAttrInterviews;
	}
	
	/**
	 * @return void
	 * @throws MonthlyMasterBkChangedServiceException
	 */
	@Override
	public void updateMMBkChangedAttrInterview()  throws MonthlyMasterBkChangedServiceException{
		
		monthlyMasterBkChangedAttrInterviewRepo.updateMMBkChangedAttrInterview();
	}

	
}
