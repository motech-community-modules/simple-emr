package org.motechproject.simpleemr.repository;

import org.motechproject.simpleemr.domain.Facility;
import org.motechproject.mds.annotations.Lookup;
import org.motechproject.mds.annotations.LookupField;
import org.motechproject.mds.service.MotechDataService;

public interface FacilityDataService extends MotechDataService<Facility> {
    @Lookup
    Facility findByName(@LookupField(name = "name") String facilityName);
}
