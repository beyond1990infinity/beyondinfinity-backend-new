package com.beyond.infinity.demo.model.git;


import com.beyond.infinity.demo.model.jira.RequirementJiraEpics;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="requirement_git_project")
@EntityListeners(AuditingEntityListener.class)
public class RequirementGitProject {

    private String projectGitId;
    private String projectGitLmSummary;

    @Id
    @Column(name="project_git_id")

    public String getProjectGitId() {
        return projectGitId;
    }

    public void setProjectGitId(String projectGitId) {
        this.projectGitId = projectGitId;
    }

    @Lob
    @Column(name="project_git_summary")
    public String getProjectGitLmSummary() {
        return projectGitLmSummary;
    }

    public void setProjectGitLmSummary(String projectGitLmSummary) {
        this.projectGitLmSummary = projectGitLmSummary;
    }
}
