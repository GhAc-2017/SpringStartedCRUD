package com.example.fspring.dao;

import com.example.fspring.model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDao {
    int insertPerson(UUID uid, Person person);

    default int insertPerson(Person person){
        UUID uid = UUID.randomUUID();
        return insertPerson(uid, person);
    }

    List<Person> getAllPerson();

    Optional<Person> selectByUuid(UUID uuid);

    int deleteById(UUID uid);

    Person updateByUid(UUID uid, Person newPerson);
}
