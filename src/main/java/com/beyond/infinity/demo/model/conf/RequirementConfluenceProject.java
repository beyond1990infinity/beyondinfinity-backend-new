package com.beyond.infinity.demo.model.conf;


import com.beyond.infinity.demo.model.jira.RequirementJiraEpics;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="requirement_confluence_registry")
@EntityListeners(AuditingEntityListener.class)
public class RequirementConfluenceProject {

    private Long id;
    private String projectId;
    private String title;
    private String description;
    private String llmConfSummary;
    private String jiraProjectId;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    @Column(name="project_id")
    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    @Column(name="title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Lob
    @Column(name="description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name="llm_conf_summary")
    public String getLlmConfSummary() {
        return llmConfSummary;
    }

    public void setLlmConfSummary(String llmConfSummary) {
        this.llmConfSummary = llmConfSummary;
    }

   @Column(name="jira_project_id")
    public String getJiraProjectId() {
        return jiraProjectId;
    }

    public void setJiraProjectId(String jiraProjectId) {
        this.jiraProjectId = jiraProjectId;
    }
}
