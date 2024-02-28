package com.beyond.infinity.demo.model.jira;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name="duplicate_requirements")
@EntityListeners(AuditingEntityListener.class)
public class DuplicateRequirements {

    private Long id;
    private String projectId;
    private  String duplicateProjectId;
@Id
@GeneratedValue(strategy =GenerationType.AUTO)
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

    @Column(name="duplicate_project_id")
    public String getDuplicateProjectId() {
        return duplicateProjectId;
    }

    public void setDuplicateProjectId(String duplicateProjectId) {
        this.duplicateProjectId = duplicateProjectId;
    }
}
