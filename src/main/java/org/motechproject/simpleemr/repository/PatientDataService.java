package org.motechproject.simpleemr.repository;

import org.motechproject.simpleemr.domain.Patient;
import org.motechproject.mds.annotations.Lookup;
import org.motechproject.mds.annotations.LookupField;
import org.motechproject.mds.service.MotechDataService;

public interface PatientDataService extends MotechDataService<Patient> {
    @Lookup
    Patient findByName(@LookupField(name = "firstName") String firstName);
}
