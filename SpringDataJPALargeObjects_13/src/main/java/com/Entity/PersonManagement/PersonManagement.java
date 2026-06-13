package com.Entity.PersonManagement;

import java.util.List;

import org.springframework.stereotype.Service;

import com.Entity.Person;

public interface PersonManagement {

	public String registerPerson(Person per);
	public List<Person> fetchAllPersons();
	
}
