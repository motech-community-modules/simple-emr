package org.motechproject.simpleemr.service;

import java.util.List;

import org.motechproject.simpleemr.domain.Observation;
import org.motechproject.simpleemr.domain.Concept;

/**
 * Service interface for CRUD on simple repository persons.
 */
public interface ObservationService {

    void create();

    void add(Observation observation);

    List<Observation> getObservations();

    void delete(Observation observation);

    void update(Observation observation);
}
