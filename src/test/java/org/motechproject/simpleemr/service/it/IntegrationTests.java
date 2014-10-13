package org.motechproject.simpleemr.service.it;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Suite.class)
@Suite.SuiteClasses({PersonServiceIT.class, PatientServiceIT.class})
public class IntegrationTests {
}
