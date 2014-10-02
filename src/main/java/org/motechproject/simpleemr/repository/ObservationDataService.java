package org.motechproject.simpleemr.repository;

import org.motechproject.simpleemr.domain.Observation;
import org.motechproject.simpleemr.domain.Patient;
import org.motechproject.mds.annotations.Lookup;
import org.motechproject.mds.annotations.LookupField;
import org.motechproject.mds.service.MotechDataService;

import java.util.List;

public interface ObservationDataService extends MotechDataService<Observation> {
    //@Lookup
    //List<Observation> findByPatient(@LookupField(name = "patient") Patient patient);
}
