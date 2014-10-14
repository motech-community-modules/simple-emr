package org.motechproject.simpleemr.service;

import java.util.List;
import java.util.Date;

import org.motechproject.simpleemr.domain.Observation;
import org.motechproject.simpleemr.domain.Concept;

/**
 * Service interface for CRUD on simple repository observations.
 */
public interface ObservationService {

    void create(Date date, Concept concept, String value);

    void add(Observation observation);

    List<Observation> getObservations();

    void delete(Observation observation);

    void update(Observation observation);
}
