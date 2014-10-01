package org.motechproject.simpleemr.domain;

import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;
import org.motechproject.mds.annotations.UIDisplayable;

import org.apache.commons.lang.ObjectUtils;
import javax.jdo.annotations.Unique;
//import java.io.Serializable;
import org.joda.time.DateTime;
import java.util.List;
import java.util.Objects;

@Entity
public class Person {

    @Field(required = true)
    @UIDisplayable(position = 0)
    private String firstName;

    @Field
    @UIDisplayable(position = 1)
    private String middleName;

    @Field
    @UIDisplayable(position = 2)
    private String lastName;

    @Field
    @UIDisplayable(position = 3)
    private DateTime dateOfBirth;

    @Field
    @UIDisplayable(position = 4)
    private Gender gender;

    @Field
    @UIDisplayable(position = 5)
    private String address;

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public DateTime getDateOfBirth() {
        return new DateTime(dateOfBirth);
    }

    public void setDateOfBirth(DateTime dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Person)) {
            return false;
        }

        Person other = (Person) o;

        return equalNameData(other) && Objects.equals(dateOfBirth, other.dateOfBirth)
                && Objects.equals(address, other.address) && Objects.equals(gender, other.gender);
    }

    public boolean equalNameData(Person other) {
        return Objects.equals(firstName, other.firstName) && Objects.equals(middleName, other.middleName)
                && Objects.equals(lastName, other.lastName);
    }

    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 31 + ObjectUtils.hashCode(firstName);
        hash = hash * 31 + ObjectUtils.hashCode(middleName);
        hash = hash * 31 + ObjectUtils.hashCode(lastName);
        hash = hash * 31 + ObjectUtils.hashCode(address);
        hash = hash * 31 + ObjectUtils.hashCode(dateOfBirth);
        hash = hash * 31 + ObjectUtils.hashCode(gender);
        return hash;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName'" + lastName +
                '}';
    }
}