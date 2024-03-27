package com.dao;

import com.entity.JobApplication;

public interface JobListingDao {
	
	public void apply(JobApplication jobApplication);
	public void getApplicants(int jobID);
}
