package com.ats.repository;

import java.util.Optional;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.model.Company;

public interface CompanyRepository extends JpaRepository<Company,Integer>{
	
	Optional<String> findByEmail(String email);
	
	Optional<String> findNameByEmailAndPassword(String email,String password);
	

}
