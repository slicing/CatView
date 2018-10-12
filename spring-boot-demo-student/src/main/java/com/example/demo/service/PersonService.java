package com.example.demo.service;

import com.example.demo.bean.Person;
import com.example.demo.dao.PersonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
	@Autowired
	private PersonDao personDao;

	public List<Person> getPersons(){
		return (List<Person>)personDao.findAll();
	}

	public Person getPerson(int id){
		return personDao.findById(id).get();
	}

	public Person addPerson(String name,int age){
		Person p = new Person(name,age);
		return personDao.save(p);
	}

	public void deletePerson(int id){
		personDao.deleteById(id);
	}

	public void deletePersonAll(){
		personDao.deleteAll();
	}

	public Person updatePerson(int id,String name,int age){
		return personDao.save(new Person(id,name,age));
	}

}
