package com.dao;

import java.util.Scanner;
import com.entity.JobApplication;
import com.entity.JobListing;

public class JobListingController {
	
	static Scanner sc=new Scanner(System.in);
	JobApplication jobApplication=new JobApplication();
	JobListing jobListing = new JobListing();
	
	public void apply() {
		System.out.println("Enter the Application ID");
		int applicationID=sc.nextInt();
		jobApplication.setApplicationId(applicationID);
		System.out.println("Enter the Job ID");
		int jobID=sc.nextInt();
		jobApplication.setJobID(jobID);
		System.out.println("Enter the Applicant ID");
		int applicantID=sc.nextInt();
		jobApplication.setApplicantID(applicantID);
		System.out.println("Enter Applicaiton Date");
		String applicationDate=sc.next();
		jobApplication.setApplicationDate(applicationDate);
		System.out.println("Enter Cover Letter");
		String coverLetter=sc.next();
		jobApplication.setCoverLetter(coverLetter);
		jobListing.apply(jobApplication);
		
	}
	public void getApplicants() {
		System.out.println("Enter Job ID : ");
		int jobID=sc.nextInt();
		jobListing.getApplicants(jobID);
	}
}
