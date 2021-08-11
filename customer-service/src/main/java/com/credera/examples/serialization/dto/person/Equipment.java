package com.credera.examples.serialization.dto.person;

public class Equipment {
    private String type;
    private boolean isRequired;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isRequired() {
        return isRequired;
    }

    public void setRequired(boolean required) {
        isRequired = required;
    }
}
