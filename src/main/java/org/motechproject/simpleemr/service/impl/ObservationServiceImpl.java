package org.motechproject.simpleemr.service.impl;

import org.motechproject.simpleemr.domain.Observation;
import org.motechproject.simpleemr.domain.Concept;
import org.motechproject.simpleemr.repository.ObservationDataService;
import org.motechproject.simpleemr.service.ObservationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Date;

/**
 * Implementation of the {@link org.motechproject.simpleemr.service.ObservationService} interface. Uses
 * {@link org.motechproject.simpleemr.repository.ObservationDataService} in order to retrieve and persist
 * persons.
 */
@Service("observationService")
public class ObservationServiceImpl implements ObservationService {

    @Autowired
    private ObservationDataService observationDataService;

    @Override
    public void create(Date date, Concept concept, String value) {
        observationDataService.create(new Observation(date, concept, value));
    }

    @Override
    public void add(Observation observation) {
        observationDataService.create(observation);
    }

    @Override
    public List<Observation> getObservations() {
        return observationDataService.retrieveAll();
    }

    @Override
    public void update(Observation observation) {
        observationDataService.update(observation);
    }

    @Override
    public void delete(Observation observation) {
        observationDataService.delete(observation);
    }
}
