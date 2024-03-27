package com.dao;

import com.entity.Applicant;
import com.entity.JobApplication;


public interface ApplicantDao {
	
	public void createProfile(Applicant applicant);
	public void applyforJob(JobApplication jobApplication);

}
