package org.motechproject.simpleemr.service.it;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({PersonServiceIT.class, PatientServiceIT.class, ProviderServiceIT.class, FacilityServiceIT.class,
                        ConceptServiceIT.class, EncounterServiceIT.class})
public class IntegrationTests {
}
