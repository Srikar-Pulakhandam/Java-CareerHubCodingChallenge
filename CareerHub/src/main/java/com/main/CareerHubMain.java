package com.main;

import java.util.Scanner;

import com.dao.*;
import com.exception.EmailException;

public class CareerHubMain {
	
	public static void main(String[] args) throws EmailException {
		
		String ch="";
		CompanyController cc = new CompanyController();
		JobListingController jlc = new JobListingController();
		ApplicantController ac=new ApplicantController();
		JobApplicationController jac = new JobApplicationController();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("1.Post a Job");//
			System.out.println("2.New Company");//
			System.out.println("3.Create Applicant Profile");//
			System.out.println("4.Apply for a Job");//
			System.out.println("5.View Job Listings by company");//
			System.out.println("6.View Companies");//
			System.out.println("7.View applicants by Job");//
			System.out.println("8.View Applications for a Job");
			int choice = sc.nextInt();
			switch (choice) {
			case 1: {
				cc.postJob();
				break;
			}
			case 2: {
				cc.newCompany();
				break;
			}
			case 3: {
				ac.createProfile();
				break;
			}
			case 4: {
				jlc.apply();
				break;
			}
			case 5: {
                 cc.getJobsByCompany();
                 break;
			}
			case 6: {
                  DatabaseManager.getCompanies();
                  break;
			}
			case 7: {
                  jlc.getApplicants();
                  break;
			}
			case 8: {
                 jac.getApplicaitons();
                  break;
			}
			default: {
				System.out.println("Invalid Choice");
			}
			}
			System.out.println("Do you want to continue? Y / N");
			ch = sc.next();
		} while (ch.equals("Y") || ch.equals("y"));
		sc.close();
	}

}
