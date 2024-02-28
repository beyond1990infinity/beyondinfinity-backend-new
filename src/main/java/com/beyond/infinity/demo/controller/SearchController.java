package com.beyond.infinity.demo.controller;

import com.beyond.infinity.demo.config.ConfigProperties;
import com.beyond.infinity.demo.model.conf.RequirementConfluenceProject;
import com.beyond.infinity.demo.model.git.RequirementGitProject;
import com.beyond.infinity.demo.model.jira.DuplicateRequirements;
import com.beyond.infinity.demo.model.jira.RequirementJiraEpics;
import com.beyond.infinity.demo.model.jira.RequirementJiraProject;
import com.beyond.infinity.demo.repository.cong.DesignDetailsRepository;
import com.beyond.infinity.demo.repository.git.GitDetailsRepository;
import com.beyond.infinity.demo.repository.jira.RequirementDetailsRepository;
import com.beyond.infinity.demo.repository.jira.RequirementDuplicateRepository;
import com.beyond.infinity.demo.request.RequirementConfluenceProjectRequest;
import com.beyond.infinity.demo.request.RequirementDuplicate;
import com.beyond.infinity.demo.request.RequirementJiraProjectRequest;
import com.beyond.infinity.demo.request.SearchRequest;
import com.beyond.infinity.demo.response.jira.Epic;
import com.beyond.infinity.demo.response.jira.JiraEpicResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class SearchController {

    @Autowired
    ConfigProperties properties;

    @Autowired
    private DesignDetailsRepository designDetailsRepository;

    @Autowired
    private RequirementDetailsRepository requirementDetailsRepository;

    @Autowired
    private GitDetailsRepository gitDetailsRepository;


    private RequirementConfluenceProject requirementConfluenceProject = new RequirementConfluenceProject();


    @RequestMapping(path = "/search", method = RequestMethod.POST)
    public String searchProject(@RequestBody String searchText) throws IOException {

        List<RequirementJiraProject> requirementJiraProjects = requirementDetailsRepository.findAll();
        List<RequirementConfluenceProject> requirementConfluenceProjects = designDetailsRepository.findAll();

        List<RequirementGitProject> requirementGitProjects = gitDetailsRepository.findAll();

        SearchRequest searchRequest = new SearchRequest();

        searchRequest.setSearchText(searchText);
        searchRequest.setRequirementJiraProjects(requirementJiraProjects);
        searchRequest.setRequirementConfluenceProjects(requirementConfluenceProjects);
        searchRequest.setRequirementGitProjects(requirementGitProjects);




        HttpHeaders confHeaders=new HttpHeaders();
        // confHeaders.add("Authorization",cred);
        confHeaders.setContentType(MediaType.APPLICATION_JSON);


        RestTemplate restTemplate=new RestTemplate();

        HttpEntity<SearchRequest> searchRequestEntity=new HttpEntity<>(searchRequest, confHeaders );

        String serverUrl="https://cdb2-2409-40c2-1007-7ddd-24ad-d64-7b85-d8eb.ngrok-free.app/get-input-match";

        String result = restTemplate.postForObject(serverUrl,searchRequestEntity, String.class);

        System.out.println(result);

        return result;

    }

}
