package org.motechproject.simpleemr.service;

import org.motechproject.simpleemr.domain.Concept;
import org.motechproject.simpleemr.domain.ConceptClass;
import org.motechproject.simpleemr.domain.DataType;

import java.util.List;
import java.util.Date;

/**
 * Service interface for CRUD on simple repository concepts.
 */
public interface ConceptService {

    void create(String name, DataType dataType, ConceptClass conceptClass, String display);

    void add(Concept concept);

    Concept findConceptByName(String name);

    List<Concept> getConcepts();

    void delete(Concept concept);

    void update(Concept concept);
}
