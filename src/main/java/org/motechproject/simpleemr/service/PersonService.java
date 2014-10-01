package org.motechproject.simpleemr.service;

import java.util.List;

import org.motechproject.simpleemr.domain.Person;

/**
 * Service interface for CRUD on simple repository persons.
 */
public interface PersonService {

    void create(String firstName, String lastName);

    void add(Person person);

    Person findPersonByName(String firstName);

    List<Person> getPersons();

    void delete(Person person);

    void update(Person person);
}
