package org.motechproject.simpleemr.repository;

import org.motechproject.simpleemr.domain.Provider;
import org.motechproject.mds.annotations.Lookup;
import org.motechproject.mds.annotations.LookupField;
import org.motechproject.mds.service.MotechDataService;

import java.util.List;

public interface ProviderDataService extends MotechDataService<Provider> {
    @Lookup
    List<Provider> findByType(@LookupField(name = "type") String type);
}
