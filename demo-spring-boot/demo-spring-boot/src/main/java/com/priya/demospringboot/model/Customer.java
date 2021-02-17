package com.priya.demospringboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;





@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String FirstName;
	private String LastName;
	
	public Customer(String FirstName, String LastName){
		this.setFirstName(FirstName);
		this.setLastName(LastName);
	}

	public Customer(){
		
	}
	public String getFirstName() {
		return FirstName;
	}

	public void setFirstName(String firstName) {
		FirstName = firstName;
	}

	public String getLastName() {
		return LastName;
	}

	public void setLastName(String lastName) {
		LastName = lastName;
	}
}
