package com.dao;

import java.util.Scanner;
import com.entity.Company;
import com.entity.JobListing;

public class CompanyController {
	
	static Scanner sc=new Scanner(System.in);
	Company company=new Company();
	public void postJob() {
		JobListing jobListing = new JobListing();
		System.out.println("Enter the Job ID");
		int jobId=sc.nextInt();
		jobListing.setJobID(jobId);
		System.out.println("Enter the Company ID");
		int companyID=sc.nextInt();
		jobListing.setCompanyID(companyID);
		System.out.println("Enter the Job Title");
		String jobTitle=sc.next();
		jobListing.setJobTitle(jobTitle);
		System.out.println("Enter the Job Description");
		String jobDescription=sc.next();
		jobListing.setJobDescription(jobDescription);
		System.out.println("Enter the Job Location");
		String jobLocation=sc.next();
		jobListing.setJobLocation(jobLocation);
		System.out.println("Enter the Salary");
		int salary=sc.nextInt();
		jobListing.setSalary(salary);
		System.out.println("Enter the Job type");
		String jobType=sc.next();
		jobListing.setJobType(jobType);
		System.out.println("Enter Posted Date");
		String postedDate=sc.next();
		jobListing.setPostedDate(postedDate);
		company.postJob(jobListing);
	}
	
	public void getJobsByCompany() {
		System.out.println("Enter Company ID:");
		int cid=sc.nextInt();
		company.getJobs(cid);
		
	}
	
	public void newCompany() {
		Company company = new Company();
		System.out.println("Enter Company Id");
		int companyID=sc.nextInt();
		company.setCompanyID(companyID);
		System.out.println("Enter Company Name");
		String companyName=sc.next();
		company.setCompanyName(companyName);
		System.out.println("Enter Company Location");
		String location=sc.next();
		company.setLocation(location);
		DatabaseManager.insertCompany(company);
	}
	

}
