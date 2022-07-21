package com.example.crud.controller;

import com.example.crud.entity.Person;
import com.example.crud.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CRUDController { //REST API
    private CRUDService crudService;

    @Autowired
    public void setCrudService(CRUDService crudService) {
        this.crudService = crudService;
    }

    // аля run() {}
    @GetMapping(value = "/read/all")
    public List<Person> getAllPersons() {
        return crudService.getAllPersons();
    }

    @PostMapping(value = "/add")
    public void createNewPerson(@RequestBody Person person) {
        crudService.createNewPerson(person);
    }

    @DeleteMapping(value = "/delete")
    public void deletePersonById(@RequestBody Long id) {
        crudService.deletePersonById(id);
    }

    @PostMapping(value = "/update")
    public void updatePersonById(@RequestBody Person person) {
        crudService.updatePersonById(person);
    }

    @GetMapping(value = "/read")
    public Person readPersonById(@RequestParam Long id) {
        return crudService.readPersonById(id);
    }
}
