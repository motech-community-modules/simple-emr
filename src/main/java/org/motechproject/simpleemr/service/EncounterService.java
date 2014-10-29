package org.motechproject.simpleemr.service;

import org.motechproject.simpleemr.domain.Encounter;
import org.motechproject.simpleemr.domain.Patient;
import org.motechproject.simpleemr.domain.Provider;

import java.util.List;
import java.util.Date;

/**
 * Service interface for CRUD on simple repository encounters.
 */
public interface EncounterService {

    void create(Date date, Patient patient, Provider provider);

    void add(Encounter encounter);

    List<Encounter> getEncounters();

    void delete(Encounter encounter);

    void update(Encounter encounter);
}
