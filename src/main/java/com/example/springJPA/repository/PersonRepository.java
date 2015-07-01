package com.example.springJPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springJPA.bean.Person;

public interface PersonRepository extends JpaRepository<Person, Integer>{

}
