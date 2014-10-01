package org.motechproject.simpleemr.domain;

import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

import org.apache.commons.lang.ObjectUtils;
import java.util.List;
import java.util.Objects;
import java.util.Date;

@Entity
public class Observation {

    // In our OpenMRS module this is generic, e.g. Observation<T>, where T is the data type of
    // the concept represented in this observation. Does MDS support this? For now I might
    // play w/string values only until I have a chance to try it out on my dev box. Also, the 
    // OpenMRS schema has depedentObservations, which I think we can live without for the purposes
    // of this demo.

    @Field
    private Date date;

    @Field
    private Concept concept;

    @Field
    private Patient patient;

    @Field
    private String value;

    public Observation(Date date, Concept concept, String value) {
        this.date = date;
        this.concept = concept;
        this.value = value;
    }

    public Observation(Date date, Concept concept, String value, Patient patient) {
        this(date, concept, value);
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Concept getConcept() {
        return concept;
    }

    public void setConcept(Concept concept) {
        this.concept = concept;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    // TODO: hashCode, equals

}
