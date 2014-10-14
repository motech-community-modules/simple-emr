package org.motechproject.simpleemr.domain;

import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;
import org.motechproject.mds.annotations.UIDisplayable;

import javax.jdo.annotations.Unique;
import org.apache.commons.lang.ObjectUtils;
import java.util.List;
import java.util.Objects;

@Entity
public class Concept {

    @Field(required = true)
    @Unique
    @UIDisplayable(position = 0)
    private String name;

    @Field(required = true)
    @UIDisplayable(position = 1)
    private DataType dataType;

    @Field(required = true)
    @UIDisplayable(position = 2)
    private ConceptClass conceptClass;

    @Field(required = true)
    @UIDisplayable(position = 3)
    private String display;

    public Concept(String name, DataType dataType, ConceptClass conceptClass, String display) {
        this.name = name;
        this.dataType = dataType;
        this.conceptClass = conceptClass;
        this.display = display;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataType getDataType() {
        return dataType;
    }

    public void setDataType(DataType dataType) {
        this.dataType = dataType;
    }

    public ConceptClass getConceptClass() {
        return conceptClass;
    }

    public void setConceptClass(ConceptClass conceptClass) {
        this.conceptClass = conceptClass;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof Concept)) {
            return false;
        }

        Concept other = (Concept) o;

        return Objects.equals(name, other.name) && Objects.equals(dataType, other.dataType)
                && Objects.equals(conceptClass, other.conceptClass) && Objects.equals(display, other.display);
    }


    @Override
    public int hashCode() {
        int hash = 1;
        hash = hash * 31 + ObjectUtils.hashCode(name);
        hash = hash * 31 + ObjectUtils.hashCode(dataType);
        hash = hash * 31 + ObjectUtils.hashCode(conceptClass);
        hash = hash * 31 + ObjectUtils.hashCode(display);
        return hash;
    }

    @Override
    public String toString() {
        return "Concept{" +
                "name='" + name + '\'' +
                ", dataType='" + dataType.toString() + '\'' +
                ", conceptClass='" + conceptClass.toString() + '\'' +
                ", display='" + display +
                '}';
    }

}
