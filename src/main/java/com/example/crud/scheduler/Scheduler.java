package com.example.crud.scheduler;

import com.example.crud.entity.Person;
import com.example.crud.service.CRUDService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Scheduler {
    private CRUDService crudService;
    private int postfix = 0;

    @Autowired
    public void setCrudService(CRUDService crudService) {
        this.crudService = crudService;
    }

    // аля run() {}
    @Scheduled(fixedRate = 5000)
    public void run() {
        crudService.getAllPersons().forEach(System.out::println);
    }

    @Scheduled(fixedRate = 1500)
    public void sout() {
        System.out.println(System.currentTimeMillis() + " : " + crudService.getAllPersons().get(0));
    }

    @Scheduled(fixedRate = 100)
    public void add() {
        Person person = new Person();
        person.setName("Riki " + ++postfix);
        person.setAge(322);
        person.setHeight(12);
        crudService.createNewPerson(person);
    }

    @Scheduled(fixedRate = 1_000)
    public void delete() {
        try {
            System.out.println("deleted: " + crudService.deletePersonById(crudService.getMaxPersonId()));
        } catch (NullPointerException e) {
            System.out.println("Гуляем дальше! ;)");
        }
    }
}
