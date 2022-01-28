package com.ats.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.ats.model.JobPostings;

public interface JobpostingRepository extends JpaRepository<JobPostings,Integer>{
          
	@Query(value="select * from job_postings where companyname=?1 and positionname=?2",nativeQuery= true)
	Optional<List<JobPostings>> findByCompanynameAndpositionname(String Companyame,String PositionName);
	
	List<JobPostings> findByCompanyname(String companyname);
	
	
	void deleteByCompanynameAndPositionname(String companyname,String positionname);
	
	@Modifying
	@Transactional
	@Query(value="update job_postings set companyname=?1,estimatedsalary=?2,location=?3,numberofpositions=?4,positionname=?5,jobdescription=?6 where companyname=?7 ",nativeQuery=true)
	void updateByCompanynameAndPositionname(String companyname,String estimatedsalary,String location,String numberofpositions,String positionname,String  jobdescription,String companynamewhere);
	
	
	
	@Query(value="select * from job_postings where companyname=?1 or positionname=?2",nativeQuery=true)
	Optional<List<JobPostings>> findByCompanynameOrPositionname(String filter,String filter2);
}

