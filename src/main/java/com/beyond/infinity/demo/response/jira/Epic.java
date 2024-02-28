package com.beyond.infinity.demo.response.jira;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Epic {
    @JsonProperty("key")
    private String epicKey;

    @JsonProperty("fields")
    private Fields epicFields;

    public String getEpicKey() {
        return epicKey;
    }

    public void setEpicKey(String epicKey) {
        this.epicKey = epicKey;
    }

    public Fields getEpicFields() {
        return epicFields;
    }

    public void setEpicFields(Fields epicFields) {
        this.epicFields = epicFields;
    }
}
