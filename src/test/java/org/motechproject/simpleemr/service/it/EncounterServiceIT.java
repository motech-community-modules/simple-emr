package org.motechproject.simpleemr.service.it;

import java.sql.BatchUpdateException;
import java.util.HashSet;
import java.util.Set;
import java.util.List;
import java.util.Date;

import org.motechproject.simpleemr.domain.Encounter;
import org.motechproject.simpleemr.domain.Concept;
import org.motechproject.simpleemr.domain.Observation;
import org.motechproject.simpleemr.domain.Patient;
import org.motechproject.simpleemr.domain.Provider;
import org.motechproject.simpleemr.domain.Person;
import org.motechproject.simpleemr.domain.DataType;
import org.motechproject.simpleemr.domain.ConceptClass;
import org.motechproject.simpleemr.repository.EncounterDataService;
import org.motechproject.simpleemr.repository.ConceptDataService;
import org.motechproject.simpleemr.repository.ObservationDataService;
import org.motechproject.simpleemr.repository.PatientDataService;
import org.motechproject.simpleemr.repository.ProviderDataService;
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
    private ProviderDataService providerDataService;
    @Inject
    private PersonDataService personDataService;

    @Before
    public void setUp() {
        encounterDataService.deleteAll();
        observationDataService.deleteAll();
        conceptDataService.deleteAll();
        patientDataService.deleteAll();
        providerDataService.deleteAll();
        personDataService.deleteAll();
    }

    @Test
    public void testEncounterService() throws Exception {

        logger.info("testEncounterService");

        Concept concept = conceptDataService.create(new Concept("BLOOD TYPE", DataType.CODED,
            ConceptClass.QUESTION, "What is your blood type?"));

        Observation observation = observationDataService.create(new Observation(new Date(), concept, "AB"));

        Person julius = personDataService.create(new Person("Julius", "Hibbert"));
        Provider provider = providerDataService.create(new Provider(julius));

        Person marge = personDataService.create(new Person("Marge", "Simpson"));
        Patient patient = patientDataService.create(new Patient(marge));

        Encounter encounter = new Encounter(new Date(), patient, provider);
        Set<Observation> observations = new HashSet<Observation>();
        observations.add(observation);
        encounter.setObservations(observations);
        encounterDataService.create(encounter);

        logger.info("Created encounter id {}", encounterDataService.getDetachedField(encounter, "id"));

        assertEquals(encounter.getObservations().size(), 1);

        encounterService.delete(encounter);
        List<Encounter> encounters = encounterService.getEncounters();
        assertEquals(encounters.size(), 0);
    }

    @After
    public void tearDown() {
        encounterDataService.deleteAll();
        observationDataService.deleteAll();
        conceptDataService.deleteAll();
        patientDataService.deleteAll();
        providerDataService.deleteAll();
        personDataService.deleteAll();
    }

}
