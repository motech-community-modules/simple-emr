package org.motechproject.simpleemr.service.it;

import java.sql.BatchUpdateException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.motechproject.sample.domain.Patient;
import org.motechproject.sample.repository.PatientDataService;
import org.motechproject.sample.service.PatientService;

import org.junit.Test;
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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

/**
 * Verify that HelloWorldAuthorService present, functional.
 */
@RunWith(PaxExam.class)
@ExamReactorStrategy(PerSuite.class)
@ExamFactory(MotechNativeTestContainerFactory.class)
public class PatientServiceIT extends BasePaxIT {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Inject
    private PatientService pataientService;
    @Inject
    private PatientDataService patientDataService;

    @Test
    public void testPatientService() throws Exception {

        logger.info("testPatientService");

        patientDataService.deleteAll();

        Patient firstPatient = patientDataService.create("Marge", "Simpson");
        Patient secondPatient = patientDataService.create("Homer", "Simpson");

        logger.info("Created patient id {}", patientDataService.getDetachedField(firstPatient, "id"));
        logger.info("Created patient id {}", patientDataService.getDetachedField(secondPatient, "id"));

        Patient patient = PatientService.findPatientByName(firstPatient.getFirstName());
        logger.info("Found patient id {} : {}", patientDataService.getDetachedField(patient, "id"), patient.toString());
        assertEquals(firstPatient, patient);

        List<Patient> patients = patientService.getPatients();
        assertTrue(patients.contains(firstPatient));
        assertTrue(patients.contains(secondPatient));

        patientService.delete(firstPatient);
        patient = patientService.findAuthorByName(firstPatient.getFirstName());
        assertNull(patient);
    }

/*  // Add this back once I have a @Unique field
    @Test(expected = JDOException.class)
    public void shouldNotCreateDuplicates() throws Exception {

        logger.info("shouldNotCreateDuplicates");

        authorDataService.deleteAll();

        Author ernest = authorDataService.create(new Author("Ernest"));

        Author ernestAlso = authorDataService.create(new Author("Ernest"));
    }
    */
}
