package com.example.demo.controller;

import com.example.demo.bean.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
	@Autowired
	private PersonService personService;

	@RequestMapping
	public List<Person> getAll(){
		return personService.getPersons();
	}

	@GetMapping("/get/{id}")
	public Person getById(@PathVariable int id){
		return personService.getPerson(id);
	}

	@PostMapping("/add/{name}/{age}")
	public Person addPerson(@PathVariable String name,@PathVariable int age){
		return personService.addPerson(name,age);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deletePerson(@PathVariable int id){
		personService.deletePerson(id);
	}

	@PutMapping("/update/{id}/{name}/{age}")
	public Person updatePerson(@PathVariable int id,@PathVariable String name,@PathVariable int age){
		return personService.updatePerson(id,name,age);
	}
}
