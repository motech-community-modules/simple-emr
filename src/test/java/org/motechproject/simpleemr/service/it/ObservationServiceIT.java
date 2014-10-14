package org.motechproject.simpleemr.service.it;

import java.sql.BatchUpdateException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Date;

import org.motechproject.simpleemr.domain.Observation;
import org.motechproject.simpleemr.domain.Concept;
import org.motechproject.simpleemr.domain.ConceptClass;
import org.motechproject.simpleemr.domain.DataType;
import org.motechproject.simpleemr.repository.ObservationDataService;
import org.motechproject.simpleemr.repository.ConceptDataService;
import org.motechproject.simpleemr.service.ObservationService;

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
public class ObservationServiceIT extends BasePaxIT {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Inject
    private ObservationService observationService;
    @Inject
    private ObservationDataService observationDataService;
    @Inject
    private ConceptDataService conceptDataService;

    @Before
    public void setUp() {
        observationDataService.deleteAll();
        conceptDataService.deleteAll();
    }

    @Test
    public void testObservationService() throws Exception {

        logger.info("testObservationService");

        Concept firstConcept = conceptDataService.create(new Concept("BLOOD TYPE", DataType.CODED,
            ConceptClass.QUESTION, "What is your blood type?"));
        Concept secondConcept = conceptDataService.create(new Concept("HAIR COLOR", DataType.CODED,
            ConceptClass.QUESTION, "What is your hair color?"));

        Observation firstObservation = observationDataService.create(new Observation(new Date(), firstConcept, "AB"));
        Observation secondObservation = observationDataService.create(new Observation(new Date(), secondConcept, "brown"));

        logger.info("Created observation id {}", observationDataService.getDetachedField(firstObservation, "id"));
        logger.info("Created observation id {}", observationDataService.getDetachedField(secondObservation, "id"));

        List<Observation> observations = observationService.getObservations();
        assertTrue(observations.contains(firstObservation));
        assertTrue(observations.contains(secondObservation));

        observationService.delete(firstObservation);
        observations = observationService.getObservations();
        assertFalse(observations.contains(firstObservation));
    }

    @After
    public void tearDown() {
        observationDataService.deleteAll();
        conceptDataService.deleteAll();
    }

}
