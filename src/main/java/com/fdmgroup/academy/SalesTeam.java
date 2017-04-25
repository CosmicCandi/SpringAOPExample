package com.fdmgroup.academy;

import com.fdmgroup.academy.Person.Status;
import com.fdmgroup.academy.enums.Company;


public class SalesTeam {
	
	public void placeTrainee(Person trainee)
	{	
		trainee.setStatus(Status.MOUNTIE);
		
		/* TODO (7) Log when trainee gets placed */
		System.out.println("\t" + trainee + " is placed at "
				+ Company.getRandom().name() + "!");
	}
	
	public void finishContract(Person mountie)
	{
		mountie.setStatus(Status.NONE);

		/* TODO (10) Log when contract ends */
		System.out.println("\t" + mountie + " has finished their contract.");
	}
}
