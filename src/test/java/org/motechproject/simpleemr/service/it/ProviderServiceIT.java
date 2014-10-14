package org.motechproject.simpleemr.service.it;

import java.sql.BatchUpdateException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.motechproject.simpleemr.domain.Provider;
import org.motechproject.simpleemr.domain.Person;
import org.motechproject.simpleemr.repository.ProviderDataService;
import org.motechproject.simpleemr.repository.PersonDataService;
import org.motechproject.simpleemr.service.ProviderService;

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


@RunWith(PaxExam.class)
@ExamReactorStrategy(PerSuite.class)
@ExamFactory(MotechNativeTestContainerFactory.class)
public class ProviderServiceIT extends BasePaxIT {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Inject
    private ProviderService providerService;
    @Inject
    private ProviderDataService providerDataService;
    @Inject
    private PersonDataService personDataService;

    @Before
    public void setUp() {
        providerDataService.deleteAll();
        personDataService.deleteAll();
    }

    @Test
    public void testProviderService() throws Exception {

        logger.info("testProviderService");

        providerDataService.deleteAll();
        personDataService.deleteAll();

        Person firstPerson = personDataService.create(new Person("Marge", "Simpson"));
        Provider firstProvider = providerDataService.create(new Provider(firstPerson));

        Person secondPerson = personDataService.create(new Person("Homer", "Simpson"));
        Provider secondProvider = providerDataService.create(new Provider(secondPerson));

        logger.info("Created provider id {}", providerDataService.getDetachedField(firstProvider, "id"));
        logger.info("Created provider id {}", providerDataService.getDetachedField(secondProvider, "id"));

        List<Provider> providers = providerService.getProviders();
        assertTrue(providers.contains(firstProvider));
        assertTrue(providers.contains(secondProvider));

        firstProvider.setType("Nurse");
        secondProvider.setType("Doctor");
        providerService.update(firstProvider);
        providerService.update(secondProvider);

        providers = providerService.findProvidersByType("Nurse");
        assertTrue(providers.contains(firstProvider));
        assertFalse(providers.contains(secondProvider));

        providerService.delete(firstProvider);
        providers = providerService.getProviders();
        assertFalse(providers.contains(firstProvider));

        providerDataService.deleteAll();
        personDataService.deleteAll();
    }

    @After
    public void tearDown() {
        providerDataService.deleteAll();
        personDataService.deleteAll();
    }
}
