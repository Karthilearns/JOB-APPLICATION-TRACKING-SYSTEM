package com.ats.model;

public class SeekerLogin {
    String email;
    String password;
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "SeekerLogin [email=" + email + ", password=" + password + "]";
	}
	
}
