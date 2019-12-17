/**
 * 
 */
package com.wns.sp.migration.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
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
	  * This method is used to update the records in the database.
	  * @throws MonthlyMasterBkChangedServiceException
	  */
	 @Modifying(clearAutomatically = true)
	 @Query("UPDATE MonthlyMasterBkChangedAttrInterview m SET m.validData = 0 WHERE  m.id in :ids")
	 public int updateMMBkChangedAttrInterview(@Param("ids") List<Long> ids) throws MonthlyMasterBkChangedServiceException;
	 
}
