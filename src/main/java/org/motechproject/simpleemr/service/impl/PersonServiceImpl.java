package org.motechproject.simpleemr.service.impl;

import org.motechproject.simpleemr.domain.Person;
import org.motechproject.simpleemr.repository.PersonDataService;
import org.motechproject.simpleemr.service.PersonService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the {@link org.motechproject.simpleemr.service.PersonService} interface. Uses
 * {@link org.motechproject.simpleemr.repository.PersonDataService} in order to retrieve and persist
 * persons.
 */
@Service("personService")
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonDataService personDataService;

    @Override
    public void create(String firstName, String lastName) {
        personDataService.create(new Person(firstName, lastName));
    }

    @Override
    public void add(Person person) {
        personDataService.create(person);
    }

    @Override
    public List<Person> findPersonsByName(String firstName) {
        List<Person> persons = personDataService.findByName(firstName);
        if (null == persons) {
            return null;
        }
        return persons;
    }

    @Override
    public List<Person> getPersons() {
        return personDataService.retrieveAll();
    }

    @Override
    public void update(Person person) {
        personDataService.update(person);
    }

    @Override
    public void delete(Person person) {
        personDataService.delete(person);
    }
}
