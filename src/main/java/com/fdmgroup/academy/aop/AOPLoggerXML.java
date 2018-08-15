package com.fdmgroup.academy.aop;

import org.aspectj.lang.JoinPoint;

import com.fdmgroup.academy.Academy;
import com.fdmgroup.academy.Person;
import com.fdmgroup.academy.exceptions.FailedAssessmentException;

public class AOPLoggerXML {
	
	public void assessmentDay(JoinPoint joinPoint){
		System.out.println("\n<<< Assessment Day: >>>");
		System.out.println(joinPoint.getArgs()[0] + "\n");
	}
	
	public void assessPerson(JoinPoint joinPoint){
		System.out.println("\t" + joinPoint.getArgs()[0] + " is accepted into the academy.");
	}
	
	public void assessPersonFailedAssessment(JoinPoint joinPoint, FailedAssessmentException failedAssessmentException){
		System.out.println("\t" + joinPoint.getArgs()[0] + " failed assessment with a grade of " + failedAssessmentException.getGrade() + "%.");
	}
	
	public void logCurrentTrainees(JoinPoint joinPoint){
		System.out.println("\n<<< Academy Opens: >>>");
		System.out.println(((Academy) joinPoint.getTarget()).getTrainees() + "\n");
	}
	
	public void logTraineeFailure(JoinPoint joinPoint){
		System.out.println("\t" + ((Person) joinPoint.getTarget()).toString() + " flunked out.");
	}
	
	public void traineeOrMountieWorksHard(JoinPoint joinPoint){
		// Working hard
		
				switch( ((Person) joinPoint.getTarget()).getStatus() ) {
					
					case TRAINEE: 
						System.out.println("\t" + ((Person) joinPoint.getTarget()).toString() + " is working hard."); 
						break;
						
					case MOUNTIE: 
						System.out.println("\t" + ((Person) joinPoint.getTarget()).toString() + " is working hard on site."); 
						break;
						
					default: ;
				}
			
	}
	
	
}
