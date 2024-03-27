package com.dao;

import com.entity.JobListing;
import com.entity.Company;

public interface CompanyDao {
	
	public void postJob(JobListing jobListing);
	public void getJobs(int companyID);

}
