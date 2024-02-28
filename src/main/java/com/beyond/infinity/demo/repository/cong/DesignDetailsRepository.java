package com.beyond.infinity.demo.repository.cong;

import com.beyond.infinity.demo.model.conf.RequirementConfluenceProject;
import com.beyond.infinity.demo.model.jira.RequirementJiraProject;
import com.beyond.infinity.demo.request.RequirementConfluenceProjectRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DesignDetailsRepository extends JpaRepository<RequirementConfluenceProject, String> {

    RequirementConfluenceProject findByProjectIdIgnoreCase(@Param("projectId") String projectId);

    @Modifying
    @Transactional
    @Query("UPDATE RequirementConfluenceProject p SET p.llmConfSummary= :llmConfSummary WHERE p.projectId= :projectId")
    int updateProjectSummary(@Param("projectId") String projectId,@Param("llmConfSummary") String llmConfSummary);


/*

    @Query(nativeQuery = true, value ="SELECT jira_project_id, llm_conf_summary FROM requirement_confluence_project")
    List<RequirementConfluenceProject> findAllConf();

*/



}
