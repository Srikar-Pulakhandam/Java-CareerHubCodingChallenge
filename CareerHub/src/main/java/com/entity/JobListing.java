package com.entity;

import com.dao.DatabaseManager;
import com.dao.JobListingDao;

public class JobListing implements JobListingDao{
	
	private int jobID;
	private int companyID;
	private String jobTitle;
	private String jobDescription;
	private String jobLocation;
	private double salary;
	private String jobType;
	private String postedDate;
	
	
	@Override
	public String toString() {
		return "JobListing [jobID=" + jobID + ", companyID=" + companyID + ", jobtitle=" + jobTitle
				+ ", jobDescription=" + jobDescription + ", jobLocation=" + jobLocation + ", salary=" + salary
				+ ", jobType=" + jobType + ", postedDate=" + postedDate + "]";
	}
	public int getJobID() {
		return jobID;
	}
	public void setJobID(int jobID) {
		this.jobID = jobID;
	}
	public int getCompanyID() {
		return companyID;
	}
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobtitle) {
		this.jobTitle = jobtitle;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getJobLocation() {
		return jobLocation;
	}
	public void setJobLocation(String jobLocation) {
		this.jobLocation = jobLocation;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getPostedDate() {
		return postedDate;
	}
	public void setPostedDate(String postedDate) {
		this.postedDate = postedDate;
	}
	public JobListing(int jobID, int companyID, String jobtitle, String jobDescription, String jobLocation,
			double salary, String jobType, String postedDate) {
		super();
		this.jobID = jobID;
		this.companyID = companyID;
		this.jobTitle = jobtitle;
		this.jobDescription = jobDescription;
		this.jobLocation = jobLocation;
		this.salary = salary;
		this.jobType = jobType;
		this.postedDate = postedDate;
	}
	public JobListing() {
		super();
	}
	
	@Override
	public void apply(JobApplication jobApplication) {
		DatabaseManager.insertJobApplication(jobApplication);		
	}
	@Override
	public void getApplicants(int jobID) {
		DatabaseManager dbManager = new DatabaseManager();
		dbManager.getApplicantsByJob(jobID);
	}
	
}
