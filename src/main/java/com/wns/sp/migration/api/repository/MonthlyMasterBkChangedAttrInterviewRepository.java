/**
 * 
 */
package com.wns.sp.migration.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.wns.sp.migration.api.entity.MonthlyMasterBkChangedAttrInterview;
import com.wns.sp.migration.api.service.MonthlyMasterBkChangedServiceException;

/**
 * Repository interface
 * @author Dilip
 *
 */
@Repository
public interface MonthlyMasterBkChangedAttrInterviewRepository  
				extends CrudRepository<MonthlyMasterBkChangedAttrInterview, Long> {
	/**
	 * It will fetched all records, those ids are greater than passing id parameter value.
	 * 
	 * @param id
	 * @return List<MonthlyMasterBkChangedAttrInterview>
	 * @throws MonthlyMasterBkChangedServiceException
	 */
	 @Query("select m from MonthlyMasterBkChangedAttrInterview m where m.id > ?1")
	 public List<MonthlyMasterBkChangedAttrInterview> findByIdGT(Long id) throws MonthlyMasterBkChangedServiceException;
	 
	 /**
	  * Stored Procedure SQL query
	  * @throws MonthlyMasterBkChangedServiceException
	  */
	 @Modifying(clearAutomatically = true)
	 @Query("UPDATE MonthlyMasterBkChangedAttrInterview SET validData = 0 WHERE ((nvic IS NULL OR nvic = '' or length(nvic)>6) or " + 
		 		"		(year IS NULL OR year = '' or year < 1960 or year> year(current_date())+1 or length(year)>4) or " + 
		 		"		(family IS NULL OR family='' or length(family)>24) or " + 
		 		"		(length(drive)>3 or drive not in ('RWD','FWD','4WD','AWD','4X4','8X4','6X2','6X6','8X8','2WD','')) or " + 
		 		"		(fuel IS NULL OR fuel = '' or length(fuel)>1 or fuel not in ('P','D','E'))   or  " + 
		 		"		(turbo IS NULL OR turbo = '' or length(turbo)>1 or turbo not in ('S','Y','T','N','Q')) or " + 
		 		"		(length(country)>3) or (length(bodystyle)>22))	and OLD_NEW_FLAG ='NEW'	")	 
	 public void updateMMBkChangedAttrInterview() throws MonthlyMasterBkChangedServiceException;
	 
}
