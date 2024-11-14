package com.somos.person_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.somos.person_service.entity.Person;
import com.somos.person_service.repository.PersonRepository;

@Service
public class PersonService {

	@Autowired
	private PersonRepository personRepository;
	
	public List<Person> customers(){
		return personRepository.findAll();
	}
	
	public void signUp() {
		Person thePerson = new Person();
		thePerson.setFullName("Test Tester");
		thePerson.setEmail("test@email.com");
		personRepository.save(thePerson);
	}
	
	public Person getByEmail(String email) {
		return personRepository.findPersonByEmail(email);
	}
}
