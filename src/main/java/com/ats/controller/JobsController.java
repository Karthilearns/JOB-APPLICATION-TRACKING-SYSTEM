package com.ats.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ats.model.Application;
import com.ats.model.Company;
import com.ats.model.CompanyLogin;
import com.ats.model.JobPostings;
import com.ats.repository.ApplicationRepository;
import com.ats.repository.CompanyRepository;
import com.ats.repository.JobpostingRepository;

@RestController 
public class JobsController {
	
	@Autowired
	JobpostingRepository jobrepo;
	
	@Autowired
	CompanyRepository companyrepo;
	
	@Autowired
	ApplicationRepository apprepo;
	  
	  @PostMapping(value="/savecompany")
	  public ResponseEntity<String> saveCompany(@RequestBody Company company){
		  
		  Optional<String> o = companyrepo.findByEmail(company.getEmail());
		  if(o.isPresent()) {
			  return  new ResponseEntity<>("EMAIL ALREADY EXISTS",HttpStatus.NOT_ACCEPTABLE);
		  }
		  else {
			 Company c = companyrepo.save(company);
			  
			  return  new ResponseEntity<>(c.toString(),HttpStatus.OK);
		  }
	  }
	  @PostMapping(value="/authenticate/company")
	  public ResponseEntity<Boolean> isauthenticatedCompany(@RequestBody CompanyLogin companylogin){
		Optional<String> name= companyrepo.findNameByEmailAndPassword(companylogin.getEmail(),companylogin.getPassword());
		System.out.println(name);
		 if(name.isPresent()) {
			 return  new ResponseEntity<>(true,HttpStatus.OK);
		 }
		 else {
			 return  new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
		 }
	  }
	  

	@PostMapping("/postjob")
	public ResponseEntity<String> savePosting(@RequestBody JobPostings jobposting){
 		    
		JobPostings jobpostings = jobrepo.save(jobposting);
		return new ResponseEntity<>(jobpostings.toString(),HttpStatus.OK);
		
	}
	@GetMapping("/getjob/{companyname}/{position_name}")
	public ResponseEntity<Optional<List<JobPostings>>> getPost(@PathVariable("companyname") String companyname, @PathVariable("position_name") String position_name){

		Optional<List<JobPostings>> job = jobrepo.findByCompanynameAndpositionname(companyname, position_name);
		return new ResponseEntity<>(job,HttpStatus.OK);
		
	}
	
	@GetMapping("/getjobs/{companyname}")
	public ResponseEntity<List<JobPostings>> getAllJobsOfCompany(@PathVariable String companyname)
	{
		List<JobPostings> jobs = jobrepo.findByCompanyname(companyname);
		return new ResponseEntity<>(jobs,HttpStatus.OK);
	}
	
	@GetMapping(value="/getalljobs")
	public ResponseEntity<List<JobPostings>> getAllJobs(){
		
		List<JobPostings> jobs = jobrepo.findAll();
		
		return new ResponseEntity<>(jobs,HttpStatus.OK);
	}

	@Modifying
	@Transactional
	@DeleteMapping(value="/deletealljobs")
	public ResponseEntity<Boolean> deleteAllJobs()
	{
		jobrepo.deleteAll();
		return new ResponseEntity<>(true,HttpStatus.OK);
	}
	@Modifying
	@Transactional
	@DeleteMapping(value="/deletejob/{companyname}/{positionname}")
	public ResponseEntity<Boolean> deleteJob(@PathVariable String companyname,@PathVariable String positionname){
		
		jobrepo.deleteByCompanynameAndPositionname(companyname, positionname);
		return new ResponseEntity<>(true,HttpStatus.OK);
	}
	
	@Modifying
	@Transactional
	@PutMapping(value="/updatejob")
	public ResponseEntity<Boolean> updateJob(@RequestBody JobPostings jobpostings){
		 jobrepo.updateByCompanynameAndPositionname(jobpostings.getCompanyname(), jobpostings.getEstimatedsalary(), jobpostings.getLocation(), jobpostings.getNumberofpositions(), jobpostings.getPositionname(), jobpostings.getJobdescription(),jobpostings.getCompanyname());
		
		return new  ResponseEntity<>(true,HttpStatus.OK);
	}
	
	
	@GetMapping(value="/getallapplications/{nameofcompany}")
	public ResponseEntity<Optional<List<Application>>> getAllApplications(@PathVariable String nameofcompany){
		
		Optional<List<Application>> applications = apprepo.findByNameofcompany(nameofcompany);
		return new ResponseEntity<>(applications,HttpStatus.OK);
		
	}
	
	@PutMapping(value="/updatestatus/{nameofapplicant}/{positionname}/{status}")
	public ResponseEntity<Boolean> applicationStatus(@PathVariable String nameofapplicant, @PathVariable String positionname, @PathVariable String status){
		
		apprepo.acceptApplication(status, nameofapplicant, positionname);
		
		return new ResponseEntity<>(true,HttpStatus.OK);	
		
	}
	
	@GetMapping(value="/filterjobs/{filter}")
	public ResponseEntity<Optional<List<JobPostings>>> getFilteredJobs(@PathVariable String filter){
		
		Optional<List<JobPostings>> jobfilters= jobrepo.findByCompanynameOrPositionname(filter, filter);
		  
		return new ResponseEntity<>(jobfilters,HttpStatus.OK);
	}
	
	@GetMapping(value="getmyapplication/{nameofapplicant}")
	public ResponseEntity<Optional<List<Application>>> getMyApplications(@PathVariable String nameofapplicant){
		Optional<List<Application>> myapplications = apprepo.findByNameofapplicant(nameofapplicant);
		
		
		return new ResponseEntity<>(myapplications,HttpStatus.OK);
	}
	
	@GetMapping(value="getstatus/{nameofapplicant}/{nameofcompany}/{positionname}")
	public ResponseEntity<Optional<List<Application>>> getStatus(@PathVariable String nameofapplicant,@PathVariable String nameofcompany,@PathVariable String positionname){
		
		Optional<List<Application>> status = apprepo.findStatusByNameofapplicantAndNameofcompanyAndPositionname(nameofapplicant,nameofcompany,positionname);
		
		return new ResponseEntity<>(status,HttpStatus.OK);
		
	}
	
	
}
