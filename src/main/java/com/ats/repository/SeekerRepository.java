package com.ats.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ats.model.Seeker;


public interface SeekerRepository extends JpaRepository<Seeker,Integer>{
     
	Optional<String> findNameByEmailAndPassword(String email,String password);
	Optional<String> findByEmail(String email);
}
