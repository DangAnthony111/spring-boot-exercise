package com.danthony.exercise.controllers;

import com.danthony.exercise.entities.Person;
import com.danthony.exercise.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    // Show all person records
    @GetMapping("/person")
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    // Get person by person_id
    @GetMapping("/person/{personId}")
    public Person getPersonById(@PathVariable int personId) {
        return personRepository.findPersonByPersonId(personId);
    }

    // Add a person
    @PostMapping("/person/add")
    public Person createNewPerson(@RequestBody Person newPerson) {
        return personRepository.save(newPerson);
    }

    // Delete a person by personId
    @DeleteMapping("/person/delete/{personId}")
    public void deletePersonById(@PathVariable int personId) {
        Person person = personRepository.findPersonByPersonId(personId);
        personRepository.delete(person);
    }

}


