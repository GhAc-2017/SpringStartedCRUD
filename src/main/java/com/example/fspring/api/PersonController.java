package com.example.fspring.api;

import com.example.fspring.model.Person;
import com.example.fspring.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }
    @GetMapping(path = "/{uuid}")
    public Person getPersonById(@PathVariable("uuid") UUID uuid){
        return personService.getPersonById(uuid).orElse(null);
    }

    @GetMapping("/all")
    public List<Person> listAllPerson(){
        return personService.getAllPeople();
    }

    @DeleteMapping(path = "/{uuid}")
    public void deleteById(@PathVariable("uuid") UUID uuid){
        personService.deletePersonById(uuid);
    }

    @PutMapping(path = "/{uuid}")
    public Person updatePersonById(@PathVariable("uuid") UUID uuid, @RequestBody Person person){
        return personService.updatePersonById(uuid, person);
    }
}
