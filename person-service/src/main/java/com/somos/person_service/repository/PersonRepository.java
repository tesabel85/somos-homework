package com.somos.person_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.somos.person_service.entity.Person;

@Repository
public interface PersonRepository  extends JpaRepository<Person, Long> {
	
	Person findPersonByEmail(String email);

}
