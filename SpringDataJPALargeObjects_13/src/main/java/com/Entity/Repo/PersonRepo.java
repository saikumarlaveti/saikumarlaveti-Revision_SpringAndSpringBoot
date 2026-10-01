package com.Entity.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.Person;

public interface PersonRepo extends JpaRepository<Person,Integer> {

}
