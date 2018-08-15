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
				
	}
	
	public void fail(){
		
		// Hardly working
				
	}
	
	public String toString(){
		
		if(status.equals(Status.NONE))
			return name;
		
		return name+" ("+stream.name()+")";
	}

}
