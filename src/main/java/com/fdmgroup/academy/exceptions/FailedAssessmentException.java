package com.fdmgroup.academy.exceptions;


public class FailedAssessmentException extends Exception {

	private static final long	serialVersionUID	= 1L;
	private int grade;
	
	public int getGrade(){ return grade; }
	
	public FailedAssessmentException(int grade) {
		this.grade = grade;
	}


}
