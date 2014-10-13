package org.motechproject.simpleemr.service.it;

import java.sql.BatchUpdateException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.motechproject.simpleemr.domain.Patient;
import org.motechproject.simpleemr.domain.Person;
import org.motechproject.simpleemr.repository.PatientDataService;
import org.motechproject.simpleemr.repository.PersonDataService;
import org.motechproject.simpleemr.service.PatientService;

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

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@RunWith(PaxExam.class)
@ExamReactorStrategy(PerSuite.class)
@ExamFactory(MotechNativeTestContainerFactory.class)
public class PatientServiceIT extends BasePaxIT {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Inject
    private PatientService patientService;
    @Inject
    private PatientDataService patientDataService;
    @Inject
    private PersonDataService personDataService;

    @Test
    public void testPatientService() throws Exception {

        logger.info("testPatientService");

        patientDataService.deleteAll();
        personDataService.deleteAll();

        Person firstPerson = personDataService.create(new Person("Marge", "Simpson"));
        Patient firstPatient = patientDataService.create(new Patient(firstPerson));

        Person secondPerson = personDataService.create(new Person("Homer", "Simpson"));
        Patient secondPatient = patientDataService.create(new Patient(secondPerson));

        logger.info("Created patient id {}", patientDataService.getDetachedField(firstPatient, "id"));
        logger.info("Created patient id {}", patientDataService.getDetachedField(secondPatient, "id"));

        List<Patient> patients = patientService.getPatients();
        assertTrue(patients.contains(firstPatient));
        assertTrue(patients.contains(secondPatient));

        patientService.delete(firstPatient);
        patients = patientService.getPatients();
        assertFalse(patients.contains(firstPatient));

        patientDataService.deleteAll();
        personDataService.deleteAll();
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
