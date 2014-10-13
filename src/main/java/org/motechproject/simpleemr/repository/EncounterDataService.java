package org.motechproject.simpleemr.repository;

import org.motechproject.simpleemr.domain.Encounter;
import org.motechproject.simpleemr.domain.Patient;
import org.motechproject.mds.annotations.Lookup;
import org.motechproject.mds.annotations.LookupField;
import org.motechproject.mds.service.MotechDataService;

import java.util.List;

public interface EncounterDataService extends MotechDataService<Encounter> {
    @Lookup
    List<Encounter> findByPatient(@LookupField(name = "patient") Patient patient);
}
