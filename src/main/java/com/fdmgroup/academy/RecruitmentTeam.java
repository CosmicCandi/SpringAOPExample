package com.fdmgroup.academy;

import java.util.Random;

import com.fdmgroup.academy.enums.Stream;
import com.fdmgroup.academy.exceptions.FailedAssessmentException;

public class RecruitmentTeam {

	public void assessPerson(Person applicant) throws FailedAssessmentException {

		Random random = new Random();

		if (random.nextBoolean()) {
			
			int badGrade = random.nextInt(75);
			
			/* TODO (3) Log when applicant fails assessment */
			System.out.println("\t" + applicant + " failed assessment with a grade of " + badGrade + "%.");
			
			throw new FailedAssessmentException(badGrade);
		}
		else {
			
			applicant.setStream(Stream.getRandom());
			
			/* TODO (2) Log when applicant is accepted */
			System.out.println("\t" + applicant	+ " is accepted into the academy.");
		}
	}

}
