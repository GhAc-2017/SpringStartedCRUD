package com.example.fspring.dao;

import com.example.fspring.model.Person;
import org.springframework.stereotype.Repository;

import javax.xml.crypto.Data;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDataAccessService implements PersonDao {
    private static List<Person> DB = new ArrayList<>();
    @Override
    public int insertPerson(UUID uid, Person person) {
        DB.add(new Person(uid, person.getName()));
        return 0;
    }

    @Override
    public List<Person> getAllPerson() {
        return DB;
    }

    @Override
    public Optional<Person> selectByUuid(UUID uuid) {
        return DB.stream().filter(person -> person.getUuid().equals(uuid)).findFirst();
    }

    @Override
    public int deleteById(UUID uid) {
        Optional<Person> optionalPerson = selectByUuid(uid);
        if(optionalPerson.isEmpty())
            return 0;
        else
            DB.remove(optionalPerson.get());
        return 1;
    }

    @Override
    public Person updateByUid(UUID uuid, Person newPerson) {
        return selectByUuid(uuid).map(person -> {
            int personToDelete=DB.indexOf(person);
            if(personToDelete>=0) {
                DB.set(personToDelete, newPerson);
                return DB.get(personToDelete);
            }
            else
                return null;
        }).orElse(null);
    }

}
