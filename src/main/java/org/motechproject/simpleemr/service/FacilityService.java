package org.motechproject.simpleemr.service;

import java.util.List;

import org.motechproject.simpleemr.domain.Facility;

/**
 * Service interface for CRUD on simple repository facilities.
 */
public interface FacilityService {

    void create(String name, String address);

    void add(Facility facility);

    Facility findByName(String name);

    List<Facility> getFacility();

    void delete(Facility facility);

    void update(Facility facility);
}
