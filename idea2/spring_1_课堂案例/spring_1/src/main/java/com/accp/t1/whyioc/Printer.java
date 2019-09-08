package com.accp.t1.whyioc;

import com.accp.t1.pojo.Person;

public class Printer {

	private Person person;
	
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	
	public Printer(Person person) {
		super();
		this.person = person;
	}
	
	public Printer(String name,String sex) {
		
	}

	
	public Printer() {
		super();
	}

	public void print() {
		person.printMessage();
	}
}
