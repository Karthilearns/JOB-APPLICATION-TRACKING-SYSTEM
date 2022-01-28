package com.ats.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class JobPostings {
  
	@Id
	@GeneratedValue
	int id;
	String positionname;
	String companyname;
	String numberofpositions;
	String jobdescription;
	String estimatedsalary;
	String location;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJobdescription() {
		return jobdescription;
	}
	public void setJobdescription(String jobdescription) {
		this.jobdescription = jobdescription;
	}

	public String getCompanyname() {
		return companyname;
	}
	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}
	public String getNumberofpositions() {
		return numberofpositions;
	}
	public void setNumberofpositions(String numberofpositions) {
		this.numberofpositions = numberofpositions;
	}

	public String getPositionname() {
		return positionname;
	}
	public void setPositionname(String positionname) {
		this.positionname = positionname;
	}
	public String getEstimatedsalary() {
		return estimatedsalary;
	}
	public void setEstimatedsalary(String estimatedsalary) {
		this.estimatedsalary = estimatedsalary;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public String toString() {
		return "JobPostings [id=" + id + ", positionname=" + positionname + ", companyname=" + companyname
				+ ", numberofpositions=" + numberofpositions + ", jobdescription=" + jobdescription
				+ ", estimatedsalary=" + estimatedsalary + ", location=" + location + "]";
	}
	
	
	

	
}
