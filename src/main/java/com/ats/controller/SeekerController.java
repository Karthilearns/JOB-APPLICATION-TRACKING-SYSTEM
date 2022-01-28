package com.ats.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.model.Application;
import com.ats.model.Seeker;
import com.ats.model.SeekerLogin;
import com.ats.repository.ApplicationRepository;
import com.ats.repository.CompanyRepository;
import com.ats.repository.SeekerRepository;

@RestController
public class SeekerController {
	
	  @Autowired	
	  SeekerRepository seekerrepository;
	  
	  @Autowired
	  CompanyRepository companyrepo;

	  @Autowired
	  ApplicationRepository applicationrepo;
	  @RequestMapping(value="/home")
	  @ResponseBody
	  public String sayHi() {
		  return "hi";
	  }
	  
	  @PostMapping(value="/saveseeker")
	  public ResponseEntity<String> saveSeeker(@RequestBody Seeker seeker){
		  
		 Optional<String> name = seekerrepository.findByEmail(seeker.getEmail());
		 if(name.isPresent()) {
			 return new ResponseEntity<>("EMAIL ALREADY EXISTS",HttpStatus.NOT_ACCEPTABLE);
		 }
		 Seeker s = seekerrepository.save(seeker);
		 return new ResponseEntity<>(s.toString(),HttpStatus.OK);
	  }
	  
	  @GetMapping(value="/getseekers")
	  public ResponseEntity<List<Seeker>> getseekers(){
		  
		  List<Seeker> s = seekerrepository.findAll();
		  return  new ResponseEntity<>(s,HttpStatus.OK);
	  }
	  
	  @PostMapping(value="/authenticate/seeker")
	  public ResponseEntity<Boolean> isauthenticatedSeeker(@RequestBody SeekerLogin seekerlogin){
		Optional<String> name= seekerrepository.findNameByEmailAndPassword(seekerlogin.getEmail(),seekerlogin.getPassword());
		System.out.println(name);
		 if(name.isPresent()) {
			 return  new ResponseEntity<>(true,HttpStatus.OK);
		 }
		 else {
			 return  new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
		 }
	  }
	  
	  
	  @PostMapping(value="/apply")
	  public ResponseEntity<Application> createApplication(@RequestBody Application application){
		  
		Application application1 =  applicationrepo.save(application);
		  
		  return new ResponseEntity<>(application1,HttpStatus.OK);
		  
		  
	  }
	  
}
	
