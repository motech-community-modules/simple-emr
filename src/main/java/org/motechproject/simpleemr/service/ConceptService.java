package org.motechproject.simpleemr.service;

import org.motechproject.simpleemr.domain.Concept;

import java.util.List;
import java.util.Date;

/**
 * Service interface for CRUD on simple repository concepts.
 */
public interface ConceptService {

    void create(String name);

    void add(Concept concept);

    List<Concept> getConcepts();

    void delete(Concept concept);

    void update(Concept concept);
}
