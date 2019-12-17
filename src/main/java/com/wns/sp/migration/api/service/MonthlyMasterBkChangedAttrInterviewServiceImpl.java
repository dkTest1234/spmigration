/**
 * 
 */
package com.wns.sp.migration.api.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wns.sp.migration.api.entity.MonthlyMasterBkChangedAttrInterview;
import com.wns.sp.migration.api.repository.MonthlyMasterBkChangedAttrInterviewRepository;

/**
 * Api Service class to process the business logic of migrated stored procedure.
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
	 * This service method is used to fetch all the records from the database.
	 * @return List<MonthlyMasterBkChangedAttrInterview>
	 * @throws MonthlyMasterBkChangedServiceException
	 */
	@Override
	public List<MonthlyMasterBkChangedAttrInterview> getAllMonthlyMasterBkChangedAttrInterviews()  throws MonthlyMasterBkChangedServiceException{
		
		List<MonthlyMasterBkChangedAttrInterview> mMBkChangedAttrInterviews = fetchAllMonthlyMasterBkChangedAttrs();
		
		return mMBkChangedAttrInterviews;
	}


	/**
	 * This is a private method to fetch all records from the database.
	 * @return List<MonthlyMasterBkChangedAttrInterview>
	 */
	private List<MonthlyMasterBkChangedAttrInterview> fetchAllMonthlyMasterBkChangedAttrs() {
		
		List<MonthlyMasterBkChangedAttrInterview> mMBkChangedAttrInterviews = new ArrayList<>();		
		monthlyMasterBkChangedAttrInterviewRepo.findAll().forEach(e -> mMBkChangedAttrInterviews.add(e));
		
		return mMBkChangedAttrInterviews;
	}

	
	/**
	 * This service method is used to fetch all the records those records id value is greater than passing parameter id value.
	 * @param id
	 * @return List<MonthlyMasterBkChangedAttrInterview>
	 * @throws MonthlyMasterBkChangedServiceException
	 */
	@Override
	public List<MonthlyMasterBkChangedAttrInterview> findByIdGT(Long id)  throws MonthlyMasterBkChangedServiceException {
		
		List<MonthlyMasterBkChangedAttrInterview> mMBkChangedAttrInterviews = 
				monthlyMasterBkChangedAttrInterviewRepo.findByIdGT(id)
														.stream()
														.collect(Collectors.toList());
		return mMBkChangedAttrInterviews;
	}
	
	/**
	 * Service method for update process. It contains all business logic of migrated Stored Procedure.
	 * @return void
	 * @throws MonthlyMasterBkChangedServiceException
	 */
	@Override
	public void updateMMBkChangedAttrInterview()  throws MonthlyMasterBkChangedServiceException {
		
		List<MonthlyMasterBkChangedAttrInterview> mMBkChangedAttrInterviews = fetchAllMonthlyMasterBkChangedAttrs();		
		LOGGER.debug(" Before filtering total number of records fetched from Database :: " + mMBkChangedAttrInterviews.size());
		
		// List of Drive data
		List<String> driveList = Arrays.asList("RWD","FWD","4WD","AWD","4X4","8X4","6X2","6X6","8X8","2WD","");
		
		//List of Fule data
		List<String> fuelList = Arrays.asList("P","D","E");
		
		//List of Turbo data
		List<String> turboList = Arrays.asList("S","Y","T","N","Q");
		
		//For Nvic field criteria check
		Predicate<MonthlyMasterBkChangedAttrInterview> checkNvic = elements -> elements.getNvic() == null || 
																				elements.getNvic() =="" || 
																				elements.getNvic().trim().length() > 6;
		//For Year field criteria check		
		Predicate<MonthlyMasterBkChangedAttrInterview> checkYear = elements -> elements.getYear() == null || 
																				elements.getYear() =="" || 
																				new Integer(elements.getYear()).intValue() < 1960 || 
																				new Integer(elements.getYear()).intValue() > LocalDate.now().getYear()+1 ||
																				elements.getYear().trim().length() > 4;
		//For Family field criteria check
		Predicate<MonthlyMasterBkChangedAttrInterview> checkFamily = elements -> elements.getFamily() == null || 
																				elements.getFamily() =="" || 
																				elements.getFamily().trim().length() > 24;
		//For Drive field criteria check
		Predicate<MonthlyMasterBkChangedAttrInterview> checkDrive = elements -> elements.getDrive().trim().length() > 3 || 
																				!driveList.contains(elements.getDrive());
		//For Fuel field criteria check
		Predicate<MonthlyMasterBkChangedAttrInterview> checkFuel = elements -> elements.getFuel() == null || 
																				elements.getFuel() == "" ||
																				elements.getFuel().trim().length() > 1 || 
																				!fuelList.contains(elements.getFuel());
		//For Turbo field criteria check																	
		Predicate<MonthlyMasterBkChangedAttrInterview> checkTurbo = elements -> elements.getTurbo() == null || 
																				elements.getTurbo() == "" ||
																				elements.getTurbo().trim().length() > 1 || 
																				!turboList.contains(elements.getTurbo());
		//For Country field criteria check																	
		Predicate<MonthlyMasterBkChangedAttrInterview> checkCountry = elements -> elements.getCountry().trim().length() > 3;
		
		//For BodyStyle field criteria check
		Predicate<MonthlyMasterBkChangedAttrInterview> checkBodyStyle = elements -> elements.getBodyStyle().trim().length() > 22;
		
		//For OldNewFlag field criteria check
		Predicate<MonthlyMasterBkChangedAttrInterview> checkOldNewFlag = elements -> elements.getOldNewFlag().equalsIgnoreCase("New");
		
		//Filtering the records those are satisfying by all criteria		
		List<MonthlyMasterBkChangedAttrInterview> mMBkChangedAttrList = mMBkChangedAttrInterviews.parallelStream()
								 .filter(checkNvic.or(checkYear).or(checkFamily).or(checkDrive).or(checkFuel).or(checkTurbo).or(checkCountry).or(checkBodyStyle).and(checkOldNewFlag))					            
								 .collect(Collectors.toList());
		
		
		LOGGER.debug(" Total number of records filterd by the business criterias and will update in database :: " + mMBkChangedAttrList.size());
		
		//Preparing the list of records need to be updated
		List<Long> idList = mMBkChangedAttrList.stream().map(e -> e.getId()).collect(Collectors.toList());
		
		
		//Invoking repository method to update  records in the database.
		monthlyMasterBkChangedAttrInterviewRepo.updateMMBkChangedAttrInterview(idList);
		
	}
	
}
