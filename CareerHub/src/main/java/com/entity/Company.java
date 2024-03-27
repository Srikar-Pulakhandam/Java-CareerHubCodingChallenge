package com.entity;

import com.dao.CompanyDao;
import com.dao.DatabaseManager;

public class Company implements CompanyDao{
	
	private int companyID;
	private String companyName;
	private String location;
	
	
	
	@Override
	public String toString() {
		return "Company [companyID=" + companyID + ", companyName=" + companyName + ", location=" + location + "]";
	}
	public Company() {
		super();
	}
	public Company(int companyID, String companyName, String location) {
		super();
		this.companyID = companyID;
		this.companyName = companyName;
		this.location = location;
	}
	public int getCompanyID() {
		return companyID;
	}
	public void setCompanyID(int companyID) {
		this.companyID = companyID;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@Override
	public void postJob(JobListing jobListing) {
		DatabaseManager.insertJobListing(jobListing);
	}
	@Override
	public void getJobs(int companyID) {
		DatabaseManager.getJobListingsByCompany(companyID);
		
	}
	
	

}
