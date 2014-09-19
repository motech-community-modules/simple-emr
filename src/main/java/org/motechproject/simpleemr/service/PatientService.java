package org.motechproject.simpleemr.service;

import java.util.List;

import org.motechproject.simpleemr.domain.Patient;

/**
 * Service interface for CRUD on simple repository patients.
 */
public interface PatientService {

    void create(String firstName, String lastName);

    void add(Patient patient);

    Patient findPatientByName(String firstName);

    List<Patient> getPatients();

    void delete(Patient patient);

    void update(Patient patient);
}
