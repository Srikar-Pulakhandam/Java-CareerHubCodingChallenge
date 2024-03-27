package com.dao;

import com.entity.*;
import com.util.DBConnUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class DatabaseManager {
	
	public static void insertApplicant(Applicant applicant) {
		try {
			Connection con = DBConnUtil.getDBConn();
			PreparedStatement ps = con.prepareStatement("insert into Applicant(applicantID,firstName,lastName,email,phone,resume) values(?,?,?,?,?,?)");
		    ps.setInt(1, applicant.getApplicantID());
		    ps.setString(2, applicant.getFirstName());
		    ps.setString(3, applicant.getLastName());
		    ps.setString(4, applicant.getEmail());
		    ps.setString(5, applicant.getPhone());
		    ps.setString(6, applicant.getResume());
			ps.executeUpdate();
			ps.close();
			con.close();

			System.out.println("Profile Created Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void insertJobApplication(JobApplication jobApplication) {
		
		try {
			Connection con = DBConnUtil.getDBConn();
			PreparedStatement ps = con.prepareStatement("insert into JobApplication(jobId,applicantID,applicationDate,coverLetter) values(?,?,?,?,?,?)");
		    ps.setInt(1, jobApplication.getJobID());
		    ps.setInt(2, jobApplication.getApplicantID());
		    ps.setString(3, jobApplication.getApplicationDate());
		    ps.setString(4, jobApplication.getCoverLetter());
			ps.executeUpdate();
			ps.close();
			con.close();

			System.out.println("Job Applied Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void insertJobListing(JobListing jobListing) {
		try {
			Connection con = DBConnUtil.getDBConn();
			PreparedStatement ps = con.prepareStatement("insert into JobListing(jobID,companyID,jobtitle,jobDescription,jobLocation,salary,jobType,postedDate) values(?,?,?,?,?,?,?,?)");
		    ps.setInt(1, jobListing.getJobID());
		    ps.setInt(2, jobListing.getCompanyID());
		    ps.setString(3, jobListing.getJobTitle());
		    ps.setString(4, jobListing.getJobDescription());
		    ps.setString(5, jobListing.getJobLocation());
		    ps.setDouble(6, jobListing.getSalary());
		    ps.setString(7, jobListing.getJobType());
		    ps.setString(8, jobListing.getPostedDate());
			ps.executeUpdate();
			ps.close();
			con.close();

			System.out.println("Job Posted Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

	public static void getJobListingsByCompany(int companyID) {
		try {
			Connection con = DBConnUtil.getDBConn();
			PreparedStatement ps = con.prepareStatement("select * from JobListing where companyID=?");
			ps.setInt(1, companyID);
			ResultSet rs = null;
			rs=ps.executeQuery();
			while (rs.next()) {
				System.out.println("JobID   : " + rs.getInt("jobID"));
				System.out.println("CompanyID : " + rs.getInt("companyID"));
				System.out.println("JobTitle: " + rs.getString("jobTitle"));
				System.out.println("JobDescription : " + rs.getString("jobDescription"));
				System.out.println("JobLocation: " + rs.getString("jobLocation"));
				System.out.println("Salary : " + rs.getDouble("salary"));
				System.out.println("JobType: " + rs.getString("jobType"));
				System.out.println("PostedDate: " + rs.getString("postedDate"));
				System.out.println("_____________________________________");
				ps.close();
				rs.close();
				con.close();

			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void getJobListings() {
		try {
			Connection con = DBConnUtil.getDBConn();
			Statement st = con.createStatement();
			String query="select Company.companyName,* from JobListings join Company on JobListings.companyID=Company.companyID";
			ResultSet rs = null;
			rs=st.executeQuery(query);
			while (rs.next()) {
				System.out.println("JobID   : " + rs.getInt("jobID"));
				System.out.println("CompanyID : " + rs.getInt("companyID"));
				System.out.println("JobTitle: " + rs.getString("jobTitle"));
				System.out.println("JobDescription : " + rs.getString("jobDescription"));
				System.out.println("JobLocation: " + rs.getString("jobLocation"));
				System.out.println("Salary : " + rs.getDouble("salary"));
				System.out.println("JobType: " + rs.getString("jobType"));
				System.out.println("PostedDate: " + rs.getString("postedDate"));
				System.out.println("_____________________________________");
				st.close();
				rs.close();
				con.close();

			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void getApplicantsByJob(int jobID) {
		
		try {
			Connection con = DBConnUtil.getDBConn();
			PreparedStatement ps = con.prepareStatement("select * from Applicant join JobApplication on Applicant.applicantId=Jobapplication.applicantID where jobID=?");
			ps.setInt(1, jobID);
			ResultSet rs = null;
			rs=ps.executeQuery();
			while (rs.next()) {
				System.out.println("ApplicantID   : " + rs.getInt("applicantID"));
				System.out.println("FirstName : " + rs.getString("firstName"));
				System.out.println("LastName: " + rs.getString("lastName"));
				System.out.println("Email : " + rs.getString("email"));
				System.out.println("Phone: " + rs.getString("phone"));
				System.out.println("Resume : " + rs.getString("resume"));
				System.out.println("_____________________________________");
				ps.close();
				rs.close();
				con.close();

			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void getApplicants() {
		
		try {
			Connection con = DBConnUtil.getDBConn();
			PreparedStatement ps = con.prepareStatement("select * from Applicant");
			ResultSet rs = null;
			rs=ps.executeQuery();
			while (rs.next()) {
				System.out.println("ApplicantID   : " + rs.getInt("applicantID"));
				System.out.println("FirstName : " + rs.getString("firstName"));
				System.out.println("LastName: " + rs.getString("lastName"));
				System.out.println("Email : " + rs.getString("email"));
				System.out.println("Phone: " + rs.getString("phone"));
				System.out.println("Resume : " + rs.getString("resume"));
				System.out.println("_____________________________________");
				ps.close();
				rs.close();
				con.close();

			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void insertCompany(Company company) {
		
		try {
			Connection con = DBConnUtil.getDBConn();
			PreparedStatement ps = con.prepareStatement("insert into Company(companyID,companyName,location) values(?,?,?)");
		    ps.setInt(1, company.getCompanyID());
		    ps.setString(2, company.getCompanyName());
		    ps.setString(3, company.getLocation());
			ps.executeUpdate();
			ps.close();
			con.close();
			System.out.println("Company Inserted Successfully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void getApplicationsForJob(int jobID) {
		
		try {
			Connection con = DBConnUtil.getDBConn();
			PreparedStatement ps = con.prepareStatement("select * from JobApplication where jobID=?");
		    ps.setInt(1, jobID);
		    ResultSet rs=null;
		    rs=ps.executeQuery();
			while (rs.next()) {
				System.out.println("ApplicationID   : " + rs.getInt("applicationID"));
				System.out.println("JobID : " + rs.getString("jobID"));
				System.out.println("ApplicantID: " + rs.getString("applicantID"));
				System.out.println("ApplicationDate : " + rs.getString("applicationDate"));
				System.out.println("CoverLetter: " + rs.getString("coverLetter"));
				System.out.println("_____________________________________");
				ps.close();
				rs.close();
				con.close();

			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public static void getCompanies() {
		
		try {
			Connection con = DBConnUtil.getDBConn();
			PreparedStatement ps = con.prepareStatement("select * from Company");
		    ResultSet rs=null;
		    rs=ps.executeQuery();
			while (rs.next()) {
				System.out.println("CompanyID   : " + rs.getInt("companyID"));
				System.out.println("CompanyName : " + rs.getString("companyName"));
				System.out.println("Location: " + rs.getString("location"));
				System.out.println("_____________________________________");
				ps.close();
				rs.close();
				con.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void getJobsBySalary(int minSalary,int maxSalary) {
		
		
		try {
			Connection con = DBConnUtil.getDBConn();
			PreparedStatement ps = con.prepareStatement("select * from JobListing where salary between ? and ?");
			ps.setInt(1, minSalary);
			ps.setInt(2, maxSalary);
			ResultSet rs = null;
			rs=ps.executeQuery();
			while (rs.next()) {
				System.out.println("JobID   : " + rs.getInt("jobID"));
				System.out.println("CompanyID : " + rs.getInt("companyID"));
				System.out.println("JobTitle: " + rs.getString("jobTitle"));
				System.out.println("JobDescription : " + rs.getString("jobDescription"));
				System.out.println("JobLocation: " + rs.getString("jobLocation"));
				System.out.println("Salary : " + rs.getDouble("salary"));
				System.out.println("JobType: " + rs.getString("jobType"));
				System.out.println("PostedDate: " + rs.getString("postedDate"));
				System.out.println("_____________________________________");
				ps.close();
				rs.close();
				con.close();
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
}
