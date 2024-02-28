package com.beyond.infinity.demo.request;

import com.beyond.infinity.demo.model.conf.RequirementConfluenceProject;
import com.beyond.infinity.demo.model.git.RequirementGitProject;
import com.beyond.infinity.demo.model.jira.RequirementJiraProject;

import java.util.List;

public class SearchRequest
{
    private String searchText;
    private List<RequirementJiraProject> requirementJiraProjects;
    private List<RequirementConfluenceProject> requirementConfluenceProjects;
    private List<RequirementGitProject> requirementGitProjects;

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public List<RequirementJiraProject> getRequirementJiraProjects() {
        return requirementJiraProjects;
    }

    public void setRequirementJiraProjects(List<RequirementJiraProject> requirementJiraProjects) {
        this.requirementJiraProjects = requirementJiraProjects;
    }

    public List<RequirementConfluenceProject> getRequirementConfluenceProjects() {
        return requirementConfluenceProjects;
    }

    public void setRequirementConfluenceProjects(List<RequirementConfluenceProject> requirementConfluenceProjects) {
        this.requirementConfluenceProjects = requirementConfluenceProjects;
    }

    public List<RequirementGitProject> getRequirementGitProjects() {
        return requirementGitProjects;
    }

    public void setRequirementGitProjects(List<RequirementGitProject> requirementGitProjects) {
        this.requirementGitProjects = requirementGitProjects;
    }
}
