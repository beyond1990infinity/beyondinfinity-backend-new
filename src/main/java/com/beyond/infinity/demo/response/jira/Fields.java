package com.beyond.infinity.demo.response.jira;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Fields {

    @JsonProperty("description")
    private String description;
    @JsonProperty("summary")
    private  String summary;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }
}
