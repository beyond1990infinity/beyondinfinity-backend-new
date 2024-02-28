package com.beyond.infinity.demo.response.conf;

import com.beyond.infinity.demo.response.jira.Epic;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ConfluencePageResponse {

    @JsonProperty("results")
    private List<Results> pageDetails;

    public List<Results> getPageDetails() {
        return pageDetails;
    }

    public void setPageDetails(List<Results> pageDetails) {
        this.pageDetails = pageDetails;
    }
}
