package com.example.springJPA.controller;



import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.springJPA.bean.Person;
import com.example.springJPA.service.interfaces.IPersonService;


@Controller
public class PersonController {

	private static final Logger LOGGER=Logger.getLogger(PersonController.class);
	
	@Autowired
	private IPersonService ipersonService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
    public String listPersons(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("listPersons", this.ipersonService.findAll());
        List<Person> persons = ipersonService.findAll();
		LOGGER.info("Have " + persons.size() + " person(s)");
		for (Person s : persons) {
			LOGGER.info(s.getId() + "   " + s.getName() + "   " + s.getCountry());
		}
        return "person";
    }
     
    //For add and update person both
    @RequestMapping(value= "/person/add", method = RequestMethod.POST)
    public String addPerson(@ModelAttribute("person") Person p){
         
        if(p.getId() == 0){
            //new person, add it
            this.ipersonService.add(p);
        }else{
            //existing person, call update
            this.ipersonService.update(p);
        }
         
        return "redirect:/";
         
    }
     
    @RequestMapping("/remove/{id}")
    public String removePerson(@PathVariable("id") int id){
         
        this.ipersonService.delete(id);
        return "redirect:/";
    }
  
    @RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("person", this.ipersonService.findPersonById(id));
        model.addAttribute("listPersons", this.ipersonService.findAll());
        return "person";
    }
	
}
