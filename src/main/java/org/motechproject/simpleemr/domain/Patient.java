package org.motechproject.simpleemr.domain;

import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;
import org.motechproject.mds.annotations.UIDisplayable;

import org.apache.commons.lang.ObjectUtils;
import java.util.List;
import java.util.Objects;

@Entity
public class Patient {

    @Field(required = true)
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

    // TODO: hashCode, equals

}
