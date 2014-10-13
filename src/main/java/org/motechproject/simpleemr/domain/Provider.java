package org.motechproject.simpleemr.domain;

import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;
import org.motechproject.mds.annotations.Cascade;

import org.apache.commons.lang.ObjectUtils;
import java.util.List;
import java.util.Objects;

@Entity
public class Provider {

    @Field(required = true)
    @Cascade(delete = true)
    private Person person;

    @Field
    private String type;

    public Provider(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Provider)) {
            return false;
        }

        Provider other = (Provider) o;

        return Objects.equals(person, other.person) && Objects.equals(type, other.type);
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 31 + ObjectUtils.hashCode(person);
        hash = hash * 31 + ObjectUtils.hashCode(type);
        return hash;
    }

    @Override
    public String toString() {
        return "Provider{" +
                "person='" + person.toString() + '\'' +
                ", type='" + type +
                '}';
    }
}
