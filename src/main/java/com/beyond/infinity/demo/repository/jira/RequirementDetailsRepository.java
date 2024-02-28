package com.beyond.infinity.demo.repository.jira;

import com.beyond.infinity.demo.model.conf.RequirementConfluenceProject;
import com.beyond.infinity.demo.model.jira.RequirementJiraProject;
import com.beyond.infinity.demo.request.RequirementJiraProjectRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface RequirementDetailsRepository extends JpaRepository<RequirementJiraProject, String> {

    RequirementJiraProject findByProjectIdIgnoreCase(@Param("projectId") String projectId);

    @Modifying
    @Transactional
    @Query("UPDATE RequirementJiraProject p SET p.projectLmSummary= :projectLmSummary WHERE p.projectId= :projectId")
    int updateProjectSummary(@Param("projectId") String projectId,@Param("projectLmSummary") String projectLmSummary);

/*

    @Query(nativeQuery = true, value ="SELECT project_id, project_lm_summary FROM requirement_jira_project")
    List<RequirementJiraProject> findAllJira();
*/



}
