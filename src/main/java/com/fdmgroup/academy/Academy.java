package com.fdmgroup.academy;

import java.util.List;
import java.util.Random;

import com.fdmgroup.academy.Person.Status;
import com.fdmgroup.academy.exceptions.FailedAssessmentException;

public class Academy {

	private List<Person>	trainees;
	private List<Person>	mounties;

	private RecruitmentTeam	recruitment;
	private SalesTeam		sales;
	

	public Academy(List<Person> trainees, List<Person> mounties, RecruitmentTeam recruitment, SalesTeam sales) {

		this.trainees = trainees;
		this.mounties = mounties;
		this.recruitment = recruitment;
		this.sales = sales;
	}

	public Academy() {

	}

	public void runAssessment(List<Person> people) throws InterruptedException {

		/* TODO (1) Log when Assessment Day starts */
		System.out.println("\n<<< Assessment Day: >>>");
		System.out.println(people + "\n");
		
		for (Person aspiringTrainee : people) {

			try {
				recruitment.assessPerson(aspiringTrainee);
				
				
				trainees.add(aspiringTrainee);
				
				aspiringTrainee.setStatus(Status.TRAINEE);

			} catch (FailedAssessmentException e) {
				
			}

			// Time passes
			Thread.sleep(1100);
		}
	}

	public void operate() throws InterruptedException {

		if (trainees.isEmpty())
			return;
		
		/* TODO (4) Log current trainees before academy opens */
		System.out.println("\n<<< Academy Opens: >>>");
		System.out.println(trainees + "\n");
		
		int action = -1;
		Person person = null;

		while (!trainees.isEmpty()) {

			for (int personIndex = 0; personIndex < trainees.size(); personIndex++) {

				// Pick a trainee

				person = trainees.get(personIndex);

				// The future is uncertain

				action = Math.abs(new Random().nextInt(6));

				// Trainee life

				switch (action) {

					case 0:
						person.fail();

						trainees.remove(person);
						personIndex--;
						break;
					case 1:
					case 2:
					case 3:
					case 4:

						
						person.work();
						
						break;

					case 5:
						
						sales.placeTrainee(person);
						
						mounties.add(person);
						trainees.remove(person);
						
						personIndex--;
						break;

					default:
						assert (false);
				}

				// Time passes

				Thread.sleep(1100);
			}
		}

	}

	public void sendMountiesOnSite() throws InterruptedException {

		if (mounties.isEmpty())
			return;

		/* TODO (8) Log current mounties when they go on site */
		System.out.println("\n<<< Mounties Go On Site: >>>");
		System.out.println(mounties + "\n");

		Person person;

		while (!mounties.isEmpty()) {
			for (int personIndex = 0; personIndex < mounties.size(); personIndex++) {

				// Pick a mountie

				person = mounties.get(personIndex);

				// Mountie life

				if (new Random().nextBoolean()) {
					person.work();

					
					
				}
				else {

					
					sales.finishContract(person);

					mounties.remove(person);
					personIndex--;
				}

				// Time passes

				Thread.sleep(1100);
			}
		}
	}

	
	public List<Person> getTrainees() {
	
		return trainees;
	}

	
	public void setTrainees(List<Person> trainees) {
	
		this.trainees = trainees;
	}
	
	public List<Person> getMounties() {
		
		return mounties;
	}

	
	public void setMounties(List<Person> mounties) {
	
		this.mounties = mounties;
	}

}
