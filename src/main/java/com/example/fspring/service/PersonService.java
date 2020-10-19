package com.example.fspring.service;

import com.example.fspring.dao.PersonDao;
import com.example.fspring.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }

    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }

    public Optional<Person> getPersonById(UUID uuid){
        return personDao.selectByUuid(uuid);
    }

    public List<Person> getAllPeople(){
        return personDao.getAllPerson();
    }

    public void deletePersonById(UUID uuid){
        personDao.deleteById(uuid);
    }
    public Person updatePersonById(UUID uuid, Person person){
        return personDao.updateByUid(uuid, person);
    }
}
