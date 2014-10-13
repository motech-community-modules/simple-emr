package org.motechproject.simpleemr.service.impl;

import org.motechproject.simpleemr.domain.Provider;
import org.motechproject.simpleemr.domain.Person;
import org.motechproject.simpleemr.repository.ProviderDataService;
import org.motechproject.simpleemr.service.ProviderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the {@link org.motechproject.simpleemr.service.ProviderService} interface. Uses
 * {@link org.motechproject.simpleemr.repository.ProviderDataService} in order to retrieve and persist
 * persons.
 */
@Service("providerService")
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private ProviderDataService providerDataService;

    @Override
    public void create(Person person) {
        providerDataService.create(new Provider(person));
    }

    @Override
    public void add(Provider provider) {
        providerDataService.create(provider);
    }

    @Override
    public List<Provider> getProviders() {
        return providerDataService.retrieveAll();
    }

    @Override
    public void update(Provider provider) {
        providerDataService.update(provider);
    }

    @Override
    public void delete(Provider provider) {
        providerDataService.delete(provider);
    }
}
