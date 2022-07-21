package com.example.crud.service;

import com.example.crud.entity.Person;
import com.example.crud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CRUDService { //Вся бизнес логика
    private PersonRepository personRepository;

    @Autowired
    public void setPersonRepository(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    private List<Person> personList;
    public List<Person> getAllPersons() {
        personList = personRepository.findAll();
        return personList;
    }

    public void createNewPerson(Person person) {
        personRepository.save(person);
    }

    public Person deletePersonById(Long id) {
        Person person = personRepository.findById(id).get();
        personRepository.delete(person);
        return person;
    }

    public Long getMaxPersonId() {
        return personRepository.getMaxId();
    }

    public void updatePersonById(Person person) {
        Person targetPerson = personRepository.findById(person.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        System.out.println(personRepository.save(person));
    }

    public Person readPersonById(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
        System.out.println("was read" + personRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST)));
        return person;
    }
}
