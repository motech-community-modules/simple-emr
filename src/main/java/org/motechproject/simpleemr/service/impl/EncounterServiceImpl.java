package org.motechproject.simpleemr.service.impl;

import org.motechproject.simpleemr.domain.Encounter;
import org.motechproject.simpleemr.domain.Patient;
import org.motechproject.simpleemr.domain.Provider;
import org.motechproject.simpleemr.repository.EncounterDataService;
import org.motechproject.simpleemr.service.EncounterService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;

/**
 * Implementation of the {@link org.motechproject.simpleemr.service.EncounterService} interface. Uses
 * {@link org.motechproject.simpleemr.repository.EncounterDataService} in order to retrieve and persist
 * persons.
 */
@Service("encounterService")
public class EncounterServiceImpl implements EncounterService {

    @Autowired
    private EncounterDataService encounterDataService;

    @Override
    public void create(Date date, Patient patient, Provider provider) {
        encounterDataService.create(new Encounter(date, patient, provider));
    }

    @Override
    public void add(Encounter encounter) {
        encounterDataService.create(encounter);
    }

    @Override
    public List<Encounter> getEncounters() {
        return encounterDataService.retrieveAll();
    }

    @Override
    public void update(Encounter encounter) {
        encounterDataService.update(encounter);
    }

    @Override
    public void delete(Encounter encounter) {
        encounterDataService.delete(encounter);
    }
}
