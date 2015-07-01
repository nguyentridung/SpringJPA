package com.example.springJPA.serivce.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springJPA.bean.Person;
import com.example.springJPA.repository.PersonRepository;
import com.example.springJPA.service.interfaces.IPersonService;

@Service
public class PersonImpl implements IPersonService{

	@Autowired
	PersonRepository personRepository;
	
	public void add(Person person) {
		// TODO Auto-generated method stub
		personRepository.save(person);
	}

	public Person update(Person person) {
		// TODO Auto-generated method stub
		return personRepository.save(person);
	}

	public void delete(int id) {
		// TODO Auto-generated method stub
		personRepository.delete(id);;
	}

	public List<Person> findAll() {
		// TODO Auto-generated method stub
		return personRepository.findAll();
	}

	public Person findPersonById(int id) {
		// TODO Auto-generated method stub
		return personRepository.findOne(id);
	}
	

}
