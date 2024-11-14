package com.somos.person_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.somos.person_service.entity.Person;
import com.somos.person_service.service.PersonService;

@RestController
@RequestMapping("/api/person")
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@GetMapping("/")
	public List<Person> customers(){
		return personService.customers();
	}
	
	@PostMapping("/service")
	public String signUp(){
		personService.signUp();
		return "Sign Up is Succesfuly completed";
	}
	
	@GetMapping("/service/{email}")
	public Person getPersonByEmail(@PathVariable String email){
		return personService.getByEmail(email);
	}

}
