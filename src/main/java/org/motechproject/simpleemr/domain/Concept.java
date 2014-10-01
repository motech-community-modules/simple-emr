package org.motechproject.simpleemr.domain;

import org.motechproject.mds.annotations.Entity;
import org.motechproject.mds.annotations.Field;
import org.motechproject.mds.annotations.UIDisplayable;

import org.apache.commons.lang.ObjectUtils;
import java.util.List;
import java.util.Objects;

@Entity
public class Concept {

    @Field(required = true)
    @UIDisplayable(position = 0)
    private String name;

    @Field
    @UIDisplayable(position = 1)
    private String dataType;

    @Field
    @UIDisplayable(position = 2)
    private String conceptClass;

    @Field
    @UIDisplayable(position = 3)
    private String display;

    public Concept(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getConceptClass() {
        return conceptClass;
    }

    public void setConceptClass(String conceptClass) {
        this.conceptClass = conceptClass;
    }

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    // TODO: hashCode, equals


}
