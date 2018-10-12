package com.example.demo.dao;

import com.example.demo.bean.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonDao extends CrudRepository<Person,Integer> {

}
