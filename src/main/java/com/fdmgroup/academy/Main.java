package com.fdmgroup.academy;

import java.util.Collections;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static ApplicationContext ctx;
	
	public static void main(String[] args) throws InterruptedException {

		
		ctx = new ClassPathXmlApplicationContext("academy-xml.xml");
		
		// Get a List of Applicants
		List<Person> applicants = (List<Person>)ctx.getBean("applicants");		
		
		Collections.shuffle(applicants);
		
		// Get an Academy
		Academy newYork = (Academy)ctx.getBean("ny_academy");
		
		newYork.runAssessment(applicants);
		
		newYork.operate();
		
		newYork.sendMountiesOnSite();
		
		((ConfigurableApplicationContext)ctx).close();
	}
}
