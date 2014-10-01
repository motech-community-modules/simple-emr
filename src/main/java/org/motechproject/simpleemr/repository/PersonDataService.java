package org.motechproject.simpleemr.repository;

import org.motechproject.simpleemr.domain.Person;
import org.motechproject.mds.annotations.Lookup;
import org.motechproject.mds.annotations.LookupField;
import org.motechproject.mds.service.MotechDataService;

public interface PersonDataService extends MotechDataService<Person> {
    @Lookup
    Person findByName(@LookupField(name = "firstName") String firstName);
}
