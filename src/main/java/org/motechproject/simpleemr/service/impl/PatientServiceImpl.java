package org.motechproject.simpleemr.service.impl;

import org.motechproject.simpleemr.domain.Patient;
import org.motechproject.simpleemr.domain.Person;
import org.motechproject.simpleemr.repository.PatientDataService;
import org.motechproject.simpleemr.service.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the {@link org.motechproject.simpleemr.service.PatientService} interface. Uses
 * {@link org.motechproject.simpleemr.repository.PatientDataService} in order to retrieve and persist
 * persons.
 */
@Service("patientService")
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientDataService patientDataService;

    @Override
    public void create(Person person) {
        patientDataService.create(new Patient(person));
    }

    @Override
    public void add(Patient patient) {
        patientDataService.create(patient);
    }

    @Override
    public List<Patient> getPatients() {
        return patientDataService.retrieveAll();
    }

    @Override
    public void update(Patient patient) {
        patientDataService.update(patient);
    }

    @Override
    public void delete(Patient patient) {
        patientDataService.delete(patient);
    }
}
