package com.example.demo.controller;

import com.example.demo.Bean.Person;
import com.example.demo.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
	@Autowired
	DemoService demoService;
	@RequestMapping("/rollback")
	public Person rollback(Person person){
		return demoService.savePersonWithRollBack(person);
	}
	@RequestMapping("/norollback")
	public Person noRollback(Person person){
		return demoService.savePersonWithoutRollBack(person);
	}
}
