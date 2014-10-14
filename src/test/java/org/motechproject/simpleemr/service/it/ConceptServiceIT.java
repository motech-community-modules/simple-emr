package org.motechproject.simpleemr.service.it;

import java.sql.BatchUpdateException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.motechproject.simpleemr.domain.Concept;
import org.motechproject.simpleemr.domain.ConceptClass;
import org.motechproject.simpleemr.domain.DataType;
import org.motechproject.simpleemr.repository.ConceptDataService;
import org.motechproject.simpleemr.service.ConceptService;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.junit.PaxExam;
import org.ops4j.pax.exam.spi.reactors.ExamReactorStrategy;
import org.motechproject.testing.osgi.container.MotechNativeTestContainerFactory;
import org.ops4j.pax.exam.ExamFactory;
import org.motechproject.testing.osgi.BasePaxIT;
import org.ops4j.pax.exam.spi.reactors.PerSuite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.jdo.JDODataStoreException;
import javax.jdo.JDOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

@RunWith(PaxExam.class)
@ExamReactorStrategy(PerSuite.class)
@ExamFactory(MotechNativeTestContainerFactory.class)
public class ConceptServiceIT extends BasePaxIT {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Inject
    private ConceptService conceptService;
    @Inject
    private ConceptDataService conceptDataService;

    @Before
    public void setUp() {
        conceptDataService.deleteAll();
    }

    @Test
    public void testConceptService() throws Exception {

        logger.info("testConceptService");

        Concept firstConcept = conceptDataService.create(new Concept("BLOOD TYPE", DataType.CODED,
            ConceptClass.QUESTION, "What is your blood type?"));
        Concept secondConcept = conceptDataService.create(new Concept("HAIR COLOR", DataType.CODED,
            ConceptClass.QUESTION, "What is your hair color?"));

        logger.info("Created concept id {}", conceptDataService.getDetachedField(firstConcept, "id"));
        logger.info("Created concept id {}", conceptDataService.getDetachedField(secondConcept, "id"));

        Concept concept = conceptService.findConceptByName(firstConcept.getName());
        logger.info("Found concept id {} : {}", conceptDataService.getDetachedField(concept, "id"), concept.toString());
        assertEquals(firstConcept, concept);

        List<Concept> concepts = conceptService.getConcepts();
        assertTrue(concepts.contains(firstConcept));
        assertTrue(concepts.contains(secondConcept));

        conceptService.delete(firstConcept);
        concepts = conceptService.getConcepts();
        assertFalse(concepts.contains(firstConcept));
    }

    @Test(expected = JDOException.class)
    public void shouldNotCreateDuplicates() throws Exception {
        logger.info("shouldNotCreateDuplicates");
        conceptDataService.deleteAll();
        conceptDataService.create(new Concept("BLOOD TYPE", DataType.CODED, ConceptClass.QUESTION, "What is your blood type?"));
        conceptDataService.create(new Concept("BLOOD TYPE", DataType.CODED, ConceptClass.QUESTION, "What is your blood type?"));
    }

    @After
    public void tearDown() {
        conceptDataService.deleteAll();
    }

}
