package edu.home.car.dealer.service;

import edu.home.car.dealer.model.Person;

import java.util.Collection;

public interface PersonService {

    Collection<Person> findAllPersons();

    Person findPersonByProfileName(String profileName);

    void createPerson(Person person);
}
