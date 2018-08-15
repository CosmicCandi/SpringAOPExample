package com.fdmgroup.academy.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.fdmgroup.academy.Academy;
import com.fdmgroup.academy.Person;
import com.fdmgroup.academy.exceptions.FailedAssessmentException;

@Aspect
public class AOPLoggerAnnotations {
	
	@Before("execution(void com.fdmgroup.academy.Academy.runAssessment(java.util.List))")
	public void assessmentDay(JoinPoint joinPoint) {
		System.out.println("\n<<< Assessment Day: >>>");
		System.out.println(joinPoint.getArgs()[0] + "\n");
	}
	
	@AfterReturning("execution(void com.fdmgroup.academy.RecruitmentTeam.assessPerson(com.fdmgroup.academy.Person))")
	public void assessPerson(JoinPoint joinPoint){
		System.out.println("\t" + joinPoint.getArgs()[0] + " is accepted into the academy.");
	}
	
	@AfterThrowing(pointcut="execution(void com.fdmgroup.academy.RecruitmentTeam.assessPerson(com.fdmgroup.academy.Person))", throwing="failedAssessmentException")
	public void assessPersonFailedAssessment(JoinPoint joinPoint, FailedAssessmentException failedAssessmentException){
		System.out.println("\t" + joinPoint.getArgs()[0] + " failed assessment with a grade of " + failedAssessmentException.getGrade() + "%.");
	}
	
	@Before("execution(void com.fdmgroup.academy.Academy.operate())")
	public void logCurrentTrainees(JoinPoint joinPoint){
		System.out.println("\n<<< Academy Opens: >>>");
		System.out.println(((Academy) joinPoint.getTarget()).getTrainees() + "\n");
	}
	
	@AfterReturning("execution(void com.fdmgroup.academy.Person.fail())")
	public void logTraineeFailure(JoinPoint joinPoint){
		System.out.println("\t" + ((Person) joinPoint.getTarget()).toString() + " flunked out.");
	}
	
	@AfterReturning("execution(void com.fdmgroup.academy.Person.work())")
	public void traineeOrMountieWorksHard(JoinPoint joinPoint){
		switch( ((Person) joinPoint.getTarget()).getStatus() ) {
		
		case TRAINEE: 
			System.out.println("\t" + ((Person) joinPoint.getTarget()).toString() + " is working hard."); 
			break;
			
		case MOUNTIE: 
			System.out.println("\t" + ((Person) joinPoint.getTarget()).toString() + " is working hard on site."); 
			break;
			
		default: ;
	}
		
	@After("execution (void com.fdmgroup.academy.SalesTeam.placeTrainee(com.fdmgroup.academy.Person)")
	public void logTraineePlacement(JoinPoint joinPoint){
		
	}

	}
	
}
