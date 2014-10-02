package org.motechproject.simpleemr.service;

import java.util.List;

import org.motechproject.simpleemr.domain.Patient;
import org.motechproject.simpleemr.domain.Person;

/**
 * Service interface for CRUD on simple repository persons.
 */
public interface PatientService {

    void create(Person person);

    void add(Patient patient);

    List<Patient> getPatients();

    void delete(Patient patient);

    void update(Patient patient);
}
