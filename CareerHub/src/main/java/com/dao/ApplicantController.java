package com.dao;

import java.util.Scanner;
import com.entity.Applicant;
import com.entity.JobApplication;
import com.exception.EmailException;

public class ApplicantController {
	
	
	Applicant applicant = new Applicant();
	static Scanner sc=new Scanner(System.in);
	public void createProfile() throws EmailException {
		System.out.println("Enter the Applicant Id");
		int applicantId=sc.nextInt();
		applicant.setApplicantID(applicantId);
		System.out.println("Enter the First Name");
		String firstName=sc.next();
		applicant.setFirstName(firstName);
		System.out.println("Enter the Last Name");
		String lastName=sc.next();
		applicant.setLastName(lastName);
		System.out.println("Enter the Email");
		String email=sc.next();
		applicant.setEmail(email);
		System.out.println("Enter the phone");
		String phone=sc.next();
		applicant.setPhone(phone);
		System.out.println("Enter the Resume");
		String resume=sc.next();
		applicant.setResume(resume);
		applicant.createProfile(applicant);
	}
	
	public void applyforJob() {
		JobApplication jobApplication=new JobApplication();
		System.out.println("Enter the JobID");
		int jobID=sc.nextInt();
		jobApplication.setJobID(jobID);
		System.out.println("Enter the Applicant ID");
		int applicantID=sc.nextInt();
		jobApplication.setApplicantID(applicantID);
		System.out.println("Enter the Application Date");
		String applicationDate=sc.next();
		jobApplication.setApplicationDate(applicationDate);
		System.out.println("Enter the Cover Letter");
		String coverLetter=sc.next();
		jobApplication.setCoverLetter(coverLetter);
		applicant.applyforJob(jobApplication);
	}
	
}
