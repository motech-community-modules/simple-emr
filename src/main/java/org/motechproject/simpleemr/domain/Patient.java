package org.motechproject.simpleemr.domain;

import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;
import org.motechproject.mds.annotations.Cascade;

import org.apache.commons.lang.ObjectUtils;
import java.util.List;
import java.util.Objects;

@Entity
public class Patient {

    @Field(required = true)
    @Cascade(delete = true)
    private Person person;

    @Field
    private Facility facility;

    public Patient(Person person) {
        this.person = person;
    }

    public Patient(Person person, Facility facility) {
        this(person);
        this.facility = facility;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Patient)) {
            return false;
        }

        Patient other = (Patient) o;

        return Objects.equals(person, other.person) && Objects.equals(facility, other.facility);
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 31 + ObjectUtils.hashCode(person);
        hash = hash * 31 + ObjectUtils.hashCode(facility);
        return hash;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "person='" + person.toString() + '\'' +
                ", facility='" + facility.toString() +
                '}';
    }

}
