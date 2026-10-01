package com.Entity.PersonManagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Person;
import com.Entity.Repo.PersonRepo;

@Service
public class PersonIMPL implements PersonManagement {
	@Autowired
	public PersonRepo repo;
	@Override
	public String registerPerson(Person per) {
		repo.save(per);
		return "successfully saved";
	}

	@Override
	public List<Person> fetchAllPersons() {
		List<Person> list = repo.findAll();
		return list;
	}

}
