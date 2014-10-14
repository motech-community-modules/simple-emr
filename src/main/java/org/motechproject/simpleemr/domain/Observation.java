package org.motechproject.simpleemr.domain;

import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;

import org.apache.commons.lang.ObjectUtils;
import java.util.List;
import java.util.Objects;
import java.util.Date;

@Entity
public class Observation {

    @Field
    private Date date;

    @Field
    private Concept concept;

    @Field
    private String value;

    @Field
    private Patient patient;

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


    @Override
    public String toString() {
        return "Observation{" +
                "date='" + date + '\'' +
                ", concept='" + concept.toString() + '\'' +
                ", value='" + value + '\'' +
                ", patient='" + patient.toString() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Observation)) return false;

        Observation other = (Observation) o;

        if (patient != null ? !patient.equals(other.patient) : other.patient != null) return false;
        return date.equals(other.date) && concept.equals(other.concept) && patient.equals(other.patient);
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 31 + ObjectUtils.hashCode(date);
        hash = hash * 31 + ObjectUtils.hashCode(concept);
        hash = hash * 31 + ObjectUtils.hashCode(value);
        hash = hash * 31 + ObjectUtils.hashCode(patient);
        return hash;
    }

}
