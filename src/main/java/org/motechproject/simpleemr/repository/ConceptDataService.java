package org.motechproject.simpleemr.repository;

import org.motechproject.simpleemr.domain.Concept;
import org.motechproject.mds.annotations.Lookup;
import org.motechproject.mds.annotations.LookupField;
import org.motechproject.mds.service.MotechDataService;

public interface ConceptDataService extends MotechDataService<Concept> {
    @Lookup
    Concept findByName(@LookupField(name = "name") String name);
}
