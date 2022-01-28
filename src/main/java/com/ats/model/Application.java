package com.ats.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Application {

	@Id
	@GeneratedValue
	int id;
	String nameofapplicant;
	String nameofcompany;
	String positionname;
	String  location;
	String qualification;
	String experience;
	String  shortdescription;
	String status;
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	} 
	public String getNameofapplicant() {
		return nameofapplicant;
	}
	public void setNameofapplicant(String nameofapplicant) {
		this.nameofapplicant = nameofapplicant;
	}
	public String getNameofcompany() {
		return nameofcompany;
	}
	public void setNameofcompany(String nameofcompany) {
		this.nameofcompany = nameofcompany;
	}
	public String getPositionname() {
		return positionname;
	}
	public void setPositionname(String positionname) {
		this.positionname = positionname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification = qualification;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getShortdescription() {
		return shortdescription;
	}
	public void setShortdescription(String shortdescription) {
		this.shortdescription = shortdescription;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Application [id=" + id + ", nameofapplicant=" + nameofapplicant + ", nameofcompany=" + nameofcompany
				+ ", positionname=" + positionname + ", location=" + location + ", qualification=" + qualification
				+ ", experience=" + experience + ", shortdescription=" + shortdescription + ", status=" + status + "]";
	}
	
	
}
