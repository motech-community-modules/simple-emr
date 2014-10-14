package org.motechproject.simpleemr.service.impl;

import org.motechproject.simpleemr.domain.Concept;
import org.motechproject.simpleemr.domain.ConceptClass;
import org.motechproject.simpleemr.domain.DataType;
import org.motechproject.simpleemr.repository.ConceptDataService;
import org.motechproject.simpleemr.service.ConceptService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the {@link org.motechproject.simpleemr.service.ConceptService} interface. Uses
 * {@link org.motechproject.simpleemr.repository.ConceptDataService} in order to retrieve and persist
 * persons.
 */
@Service("conceptService")
public class ConceptServiceImpl implements ConceptService {

    @Autowired
    private ConceptDataService conceptDataService;

    @Override
    public void create(String name, DataType dataType, ConceptClass conceptClass, String display) {
        conceptDataService.create(new Concept(name, dataType, conceptClass, display));
    }

    @Override
    public void add(Concept concept) {
        conceptDataService.create(concept);
    }

    @Override
    public Concept findConceptByName(String name) {
        return conceptDataService.findByName(name);
    }

    @Override
    public List<Concept> getConcepts() {
        return conceptDataService.retrieveAll();
    }

    @Override
    public void update(Concept concept) {
        conceptDataService.update(concept);
    }

    @Override
    public void delete(Concept concept) {
        conceptDataService.delete(concept);
    }
}
