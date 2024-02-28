package com.beyond.infinity.demo.model.jira;


import javax.persistence.*;

@Entity
@Table(name="requirement_epic_registry")
public class RequirementJiraEpics {

    private String epicId;
    private String summary;
    private String description;
    private String projectId;
    private String llm_summary;

    @Id
    @Column(name="epic_id")
    public String getEpicId() {
        return epicId;
    }

    public void setEpicId(String epicId) {
        this.epicId = epicId;
    }

    @Lob
    @Column(name="summary")
    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    @Lob
    @Column(name="description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name="project_id")
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @Column(name="llm_summary")
    public String getLlm_summary() {
        return llm_summary;
    }

    public void setLlm_summary(String llm_summary) {
        this.llm_summary = llm_summary;
    }
}
