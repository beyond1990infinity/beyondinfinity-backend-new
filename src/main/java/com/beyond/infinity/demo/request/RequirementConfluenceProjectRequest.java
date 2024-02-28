package com.beyond.infinity.demo.request;

public class RequirementConfluenceProjectRequest {

    private String jiraProjectId;
    private String llmConfSummary;

    public String getJiraProjectId() {
        return jiraProjectId;
    }

    public void setJiraProjectId(String jiraProjectId) {
        this.jiraProjectId = jiraProjectId;
    }

    public String getLlmConfSummary() {
        return llmConfSummary;
    }

    public void setLlmConfSummary(String llmConfSummary) {
        this.llmConfSummary = llmConfSummary;
    }
}
