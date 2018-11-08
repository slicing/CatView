package com.example.demo.service;

import com.example.demo.Bean.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoServiceImpl implements DemoService {
	@Autowired
	PersonRepository personRepository;
	@Transactional(rollbackFor={IllegalArgumentException.class})
	@Override
	public Person savePersonWithRollBack(Person person) {
		Person p = personRepository.save(person);
		if (person.getName().equals("biubiu")){
			throw new IllegalArgumentException("猪猪已经存在，数据将回滚");
		}
		return p;
	}

	@Transactional(noRollbackFor = {IllegalArgumentException.class})
	@Override
	public Person savePersonWithoutRollBack(Person person) {
		Person p = personRepository.save(person);
		if (person.getName().equals("biubiu")){
			throw new IllegalArgumentException("猪猪岁已存在，但数据不会回滚");
		}
		return p;
	}
}
