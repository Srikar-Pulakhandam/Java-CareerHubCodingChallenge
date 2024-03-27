package com.entity;

import java.util.regex.Pattern;
import java.util.regex.Matcher; 
import com.dao.ApplicantDao;
import com.dao.DatabaseManager;
import com.exception.EmailException;

public class Applicant implements ApplicantDao{
	
	private int applicantID;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	private String resume;
	
	@Override
	public void createProfile(Applicant applicant) {
		DatabaseManager.insertApplicant(applicant);
	}
	
	@Override
	public void applyforJob(JobApplication jobApplication) {
		DatabaseManager.insertJobApplication(jobApplication);
	}
	
	@Override
	public String toString() {
		return "Applicant [applicantID=" + applicantID + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", phone=" + phone + ", resume=" + resume + "]";
	}
	
	
	public boolean validateEmail(String email) {
		
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
                "[a-zA-Z0-9_+&*-]+)*@" + 
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
                "A-Z]{2,7}$"; 
                  
		Pattern pat = Pattern.compile(emailRegex); 
		if (email == null) {
			return false; 
		}
		return pat.matcher(email).matches(); 
	}
	public int getApplicantID() {
		return applicantID;
	}
	public void setApplicantID(int applicantID) {
		this.applicantID = applicantID;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) throws EmailException {
		if(validateEmail(email)) {
			this.email = email;
		}
		else {
			throw new EmailException("Invalid Email");
		}
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getResume() {
		return resume;
	}
	public void setResume(String resume) {
		this.resume = resume;
	}
	public Applicant() {
		super();
	}
	public Applicant(int applicantID, String firstName, String lastName, String email, String phone, String resume) {
		super();
		this.applicantID = applicantID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.resume = resume;
	}



	
	
	

}
