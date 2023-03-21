package com.webhook.repository;

import com.webhook.model.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PersonRepository {

    private static final List<Person> persons = new ArrayList<>();

    static {
        persons.add(new Person("Suraj Bothale", "123", "Wani"));
        persons.add(new Person("Akshay Rajurkar", "456", "Chandigarh"));
        persons.add(new Person("Harshal Parkhi", "789", "Chicago"));
    }

    public static List<Person> getPersons() {
        return persons;
    }

    public static Person getPerson(String name) {
        Optional<Person> person = persons.stream()
                .filter(p -> p.getName().equalsIgnoreCase(name))
                .findFirst();

        if (person.isPresent()) {
            return person.get();
        } else {
            throw new IllegalArgumentException("Person not found");
        }
    }

    public static void setPerson(Person newPerson) {
        Optional<Person> person = persons.stream()
                .filter(p -> p.getName().equalsIgnoreCase(newPerson.getName()))
                .findFirst();

        if (person.isPresent()) {
            Person existingPerson = person.get();
            existingPerson.setId(newPerson.getId());
            existingPerson.setLocation(newPerson.getLocation());
        } else {
            persons.add(newPerson);
        }
    }
}