package org.motechproject.simpleemr.service.it;

import java.sql.BatchUpdateException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Date;

import org.motechproject.simpleemr.domain.Encounter;
import org.motechproject.simpleemr.domain.Concept;
import org.motechproject.simpleemr.domain.Observation;
import org.motechproject.simpleemr.domain.Patient;
import org.motechproject.simpleemr.domain.Person;
import org.motechproject.simpleemr.domain.DataType;
import org.motechproject.simpleemr.domain.ConceptClass;
import org.motechproject.simpleemr.repository.EncounterDataService;
import org.motechproject.simpleemr.repository.ConceptDataService;
import org.motechproject.simpleemr.repository.ObservationDataService;
import org.motechproject.simpleemr.repository.PatientDataService;
import org.motechproject.simpleemr.repository.PersonDataService;

import org.motechproject.simpleemr.service.EncounterService;

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
public class EncounterServiceIT extends BasePaxIT {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Inject
    private EncounterService encounterService;
    @Inject
    private EncounterDataService encounterDataService;
    @Inject
    private ConceptDataService conceptDataService;
    @Inject
    private ObservationDataService observationDataService;
    @Inject
    private PatientDataService patientDataService;
    @Inject
    private PersonDataService personDataService;

    @Before
    public void setUp() {
        encounterDataService.deleteAll();
        observationDataService.deleteAll();
        conceptDataService.deleteAll();
        patientDataService.deleteAll();
        personDataService.deleteAll();
    }

    @Test
    public void testEncounterService() throws Exception {

        logger.info("testEncounterService");

        Concept firstConcept = conceptDataService.create(new Concept("BLOOD TYPE", DataType.CODED,
            ConceptClass.QUESTION, "What is your blood type?"));
        Concept secondConcept = conceptDataService.create(new Concept("HAIR COLOR", DataType.CODED,
            ConceptClass.QUESTION, "What is your hair color?"));

        Observation firstObservation = observationDataService.create(new Observation(new Date(), firstConcept, "AB"));
        Observation secondObservation = observationDataService.create(new Observation(new Date(), secondConcept, "blue"));
        Observation thirdObservation = observationDataService.create(new Observation(new Date(), secondConcept, "n/a"));

        Person firstPerson = personDataService.create(new Person("Marge", "Simpson"));
        Person secondPerson = personDataService.create(new Person("Homer", "Simpson"));

        Patient firstPatient = patientDataService.create(new Patient(firstPerson));
        Patient secondPatient = patientDataService.create(new Patient(secondPerson));

        Encounter firstEncounter = new Encounter(new Date(), firstPatient);
        firstEncounter.setObservations(new ArrayList<Observation>(Arrays.asList(firstObservation, secondObservation)));
        encounterDataService.create(firstEncounter);

        Encounter secondEncounter = new Encounter(new Date(), secondPatient);
        secondEncounter.setObservations(new ArrayList<Observation>(Arrays.asList(thirdObservation)));
        encounterDataService.create(secondEncounter);

        logger.info("Created encounter id {}", encounterDataService.getDetachedField(firstEncounter, "id"));
        logger.info("Created encounter id {}", encounterDataService.getDetachedField(secondEncounter, "id"));

        List<Encounter> encounters = encounterService.getEncounters();
        assertTrue(encounters.contains(firstEncounter));
        assertTrue(encounters.contains(secondEncounter));

        encounterService.delete(firstEncounter);
        encounters = encounterService.getEncounters();
        assertFalse(encounters.contains(firstEncounter));
    }

    @After
    public void tearDown() {
        encounterDataService.deleteAll();
        observationDataService.deleteAll();
        conceptDataService.deleteAll();
        patientDataService.deleteAll();
        personDataService.deleteAll();
    }

}
