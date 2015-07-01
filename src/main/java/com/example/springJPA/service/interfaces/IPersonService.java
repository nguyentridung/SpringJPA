package com.example.springJPA.service.interfaces;

import java.util.List;

import com.example.springJPA.bean.Person;

public interface IPersonService {

	public void add(Person person);
	public Person update(Person person);
	
	public void delete(int id);
	public List<Person> findAll();
	public Person findPersonById(int id);
}
