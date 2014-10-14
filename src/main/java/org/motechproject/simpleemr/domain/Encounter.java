package org.motechproject.simpleemr.domain;

import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

import org.apache.commons.lang.ObjectUtils;
import java.util.Objects;
import java.util.Date;
import java.util.Set;

@Entity
public class Encounter {

    @Field
    private Provider provider;

    @Field
    private Facility facility;

    @Field(required = true)
    private Date date;

    @Field
    private Set<Observation> observations;

    @Field(required = true)
    private Patient patient;

    @Field
    private String encounterType;

    public Encounter(Date date, Patient patient) {
        this.date = date;
        this.patient = patient;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Set<Observation> getObservations() {
        return observations;
    }

    public void setObservations(Set<Observation> observations) {
        this.observations = observations;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getEncounterType() {
        return encounterType;
    }

    public void setEncounterType(String encounterType) {
        this.encounterType = encounterType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Encounter)) {
            return false;
        }

        Encounter other = (Encounter) o;

        return equalObsData(other) && Objects.equals(date, other.date) && Objects.equals(facility, other.facility)
                && Objects.equals(patient, other.patient) && Objects.equals(encounterType, other.encounterType);
    }

    public boolean equalObsData(Encounter other) {
        if (observations.size() != other.observations.size()) {
            return false;
        }
        return other.observations.containsAll(observations);
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 31 + ObjectUtils.hashCode(provider);
        hash = hash * 31 + ObjectUtils.hashCode(facility);
        hash = hash * 31 + ObjectUtils.hashCode(date);
        hash = hash * 31 + ObjectUtils.hashCode(observations);
        hash = hash * 31 + ObjectUtils.hashCode(patient);
        hash = hash * 31 + ObjectUtils.hashCode(encounterType);
        return hash;
    }

    @Override
    public String toString() {
        return "Encounter{" +
                "provider='" + provider.toString() + '\'' +
                ", facility='" + facility.toString() + '\'' +
                ", date='" + date.toString() + '\'' +
                ", encounterType='" + encounterType + '\'' +
                ", patient='" + patient.toString() + '\'' +
                ", observations='" + observations.toString() +
                '}';
    }

}