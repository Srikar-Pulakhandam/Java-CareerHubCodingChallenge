package com.entity;

import com.dao.DatabaseManager;

public class JobApplication {
	
	private int applicationId;
	private int jobID;
	private int applicantID;
	private String applicationDate;
	private String coverLetter;
	
	
	@Override
	public String toString() {
		return "JobApplication [applicationId=" + applicationId + ", jobID=" + jobID + ", applicantID=" + applicantID
				+ ", applicationDate=" + applicationDate + ", coverLetter=" + coverLetter + "]";
	}
	public JobApplication() {
		super();
	}
	public JobApplication(int applicationId, int jobID, int applicantID, String applicationDate, String coverLetter) {
		super();
		this.applicationId = applicationId;
		this.jobID = jobID;
		this.applicantID = applicantID;
		this.applicationDate = applicationDate;
		this.coverLetter = coverLetter;
	}
	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public int getJobID() {
		return jobID;
	}
	public void setJobID(int jobID) {
		this.jobID = jobID;
	}
	public int getApplicantID() {
		return applicantID;
	}
	public void setApplicantID(int applicantID) {
		this.applicantID = applicantID;
	}
	public String getApplicationDate() {
		return applicationDate;
	}
	public void setApplicationDate(String applicationDate) {
		this.applicationDate = applicationDate;
	}
	public String getCoverLetter() {
		return coverLetter;
	}
	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}
	
	public void getApplicationsForJob(int jobID) {
		DatabaseManager.getApplicantsByJob(jobID);
	}

}
