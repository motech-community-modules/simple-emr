package org.motechproject.simpleemr.service.impl;

import org.motechproject.simpleemr.domain.Facility;
import org.motechproject.simpleemr.repository.FacilityDataService;
import org.motechproject.simpleemr.service.FacilityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of the {@link org.motechproject.simpleemr.service.FacilityService} interface. Uses
 * {@link org.motechproject.simpleemr.repository.FacilityDataService} in order to retrieve and persist
 * persons.
 */
@Service("facilityService")
public class FacilityServiceImpl implements FacilityService {

    @Autowired
    private FacilityDataService facilityDataService;

    @Override
    public void create(String name, String address) {
        facilityDataService.create(new Facility(name, address));
    }

    @Override
    public void add(Facility facility) {
        facilityDataService.create(facility);
    }

    @Override
    public Facility findFacilityByName(String name) {
        return facilityDataService.findByName(name);
    }

    @Override
    public List<Facility> getFacilities() {
        return facilityDataService.retrieveAll();
    }

    @Override
    public void update(Facility facility) {
        facilityDataService.update(facility);
    }

    @Override
    public void delete(Facility facility) {
        facilityDataService.delete(facility);
    }
}
