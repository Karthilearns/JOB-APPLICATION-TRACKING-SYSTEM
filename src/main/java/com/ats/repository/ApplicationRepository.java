package com.ats.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.PathVariable;

import com.ats.model.Application;

public interface ApplicationRepository extends JpaRepository<Application,Integer>{

	   Optional<List<Application>> findByNameofcompany(String nameofcomoany);
	   
	   @Modifying
	   @Transactional
	   @Query(value="update application set status=?1 where nameofapplicant=?2 and positionname=?3",nativeQuery=true)
	   void acceptApplication(String status,String nameofapplicant , String positionsame);
	   
	   Optional<List<Application>> findByNameofapplicant(String nameofapplicant);
	   
	   Optional<List<Application>>  findStatusByNameofapplicantAndNameofcompanyAndPositionname(String nameofapplicant, String nameofcompany, String positionname);
	   
}
