package com.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.apache.commons.lang.builder.ToStringBuilder;

@Entity
public class Customer {

	@Id
	@GeneratedValue
	private long id;
	private String name;
	private int age;
	
	private Customer(){}

	public Customer(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String  toString () {
	 return ToStringBuilder.reflectionToString(this);
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
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
