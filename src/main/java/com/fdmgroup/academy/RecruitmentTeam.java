package com.fdmgroup.academy;

import java.util.Random;

import com.fdmgroup.academy.enums.Stream;
import com.fdmgroup.academy.exceptions.FailedAssessmentException;

public class RecruitmentTeam {

	public void assessPerson(Person applicant) throws FailedAssessmentException {

		Random random = new Random();

		if (random.nextBoolean()) {
			
			int badGrade = random.nextInt(75);
			
			throw new FailedAssessmentException(badGrade);
		}
		else {
			applicant.setStream(Stream.getRandom());
		}
	}

}
