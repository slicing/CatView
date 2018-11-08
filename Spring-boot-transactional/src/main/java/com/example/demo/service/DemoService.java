package com.example.demo.service;

import com.example.demo.Bean.Person;


public interface DemoService {
	Person savePersonWithRollBack(Person person);
	Person savePersonWithoutRollBack(Person person);
}
