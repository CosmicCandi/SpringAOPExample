package com.fdmgroup.academy;

import com.fdmgroup.academy.enums.Stream;


public class Person {

	private String name;
	private Stream stream;
	private Status status;
	
	public enum Status {
		TRAINEE, MOUNTIE, NONE;
	}	
	
	public Person(String name) {
		this.setName(name);
		this.setStatus(Status.NONE);
	}
	
	public Person(){
		
	}
	
	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public Stream getStream() {

		return stream;
	}

	public void setStream(Stream stream) {

		this.stream = stream;
	}

	public Status getStatus() {

		return status;
	}

	public void setStatus(Status status) {

		this.status = status;
	}
	
	public void work(){
		
		// Working hard
		
		switch(this.status){
			
			case TRAINEE: 
				/* TODO (6) Log when trainee works hard */
				System.out.println("\t" + this + " is working hard."); 
				break;
				
			case MOUNTIE: 
				/* TODO (9) Log when mountie works hard */
				System.out.println("\t" + this + " is working hard on site."); 
				break;
				
			default: ;
		}
		
	}
	
	public void fail(){
		
		// Hardly working
		
		/* TODO (5) Log when trainee flunks */
		System.out.println("\t" + this + " flunked out.");
		
	}
	
	public String toString(){
		
		if(status.equals(Status.NONE))
			return name;
		
		return name+" ("+stream.name()+")";
	}

}
