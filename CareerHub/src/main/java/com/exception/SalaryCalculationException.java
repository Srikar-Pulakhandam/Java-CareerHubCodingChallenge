package com.exception;

public class SalaryCalculationException extends Exception{

	public SalaryCalculationException() {
		System.out.println("Salary Cannot be Negative");
	}
	
}
