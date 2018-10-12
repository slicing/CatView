package com.example.demo.bean;

import javax.persistence.*;

@Entity//实体
@Table(name="person")//数据库
public class Person {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)//增长类型
	private int id;
	@Column
	private String name;
	@Column
	private int age;

	public Person(int id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Person() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}
