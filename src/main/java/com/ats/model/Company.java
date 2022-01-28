package com.ats.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Company {
	
@Id
@GeneratedValue
   int id;
   String name;
   String email;
   public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

String companytype;
   String location;
   String password;
   
public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getCompanytype() {
	return companytype;
}

public void setCompanytype(String companytype) {
	this.companytype = companytype;
}

public String getLocation() {
	return location;
}

public void setLocation(String location) {
	this.location = location;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

@Override
public String toString() {
	return "Company [id=" + id + ", name=" + name + ", email=" + email + ", companytype=" + companytype + ", location="
			+ location + ", password=" + password + "]";
}

   
}
