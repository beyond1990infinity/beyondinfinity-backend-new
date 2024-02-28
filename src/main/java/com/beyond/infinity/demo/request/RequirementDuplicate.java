package com.beyond.infinity.demo.request;

import java.util.List;

public class RequirementDuplicate
{
    private String projectId;
    private List<String> duplicateProjectId;

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public List<String> getDuplicateProjectId() {
        return duplicateProjectId;
    }

    public void setDuplicateProjectId(List<String> duplicateProjectId) {
        this.duplicateProjectId = duplicateProjectId;
    }
}
