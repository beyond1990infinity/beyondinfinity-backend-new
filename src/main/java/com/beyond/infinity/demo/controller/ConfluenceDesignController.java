package com.beyond.infinity.demo.controller;

import com.beyond.infinity.demo.config.ConfigProperties;
import com.beyond.infinity.demo.model.conf.RequirementConfluenceProject;
import com.beyond.infinity.demo.model.jira.DuplicateRequirements;
import com.beyond.infinity.demo.model.jira.RequirementJiraProject;
import com.beyond.infinity.demo.repository.cong.DesignDetailsRepository;
import com.beyond.infinity.demo.request.RequirementDuplicate;
import com.beyond.infinity.demo.response.conf.ConfluencePageResponse;
import com.beyond.infinity.demo.response.jira.JiraEpicResponse;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1")
public class ConfluenceDesignController {

    @Autowired
    ConfigProperties properties;

    @Autowired
    private DesignDetailsRepository designDetailsRepository;


    private RequirementConfluenceProject requirementConfluenceProject = new RequirementConfluenceProject();

    @RequestMapping(path="/confluence/title/{title}",method =RequestMethod.GET)
    public ConfluencePageResponse getConfluence(@RequestHeader("Authorization") final String cred, @PathVariable("space") String space, @PathVariable("title") String title ) throws IOException {
        HttpsURLConnection.setDefaultHostnameVerifier(new HostnameVerifier() {

            public boolean verify(String hostname, SSLSession session) {
                return true;
            }
        });
        RestTemplate restTemplate=new RestTemplate();

        HttpHeaders headers=new HttpHeaders();
        headers.add("Authorization",cred);
        headers.setAccept(MediaType.parseMediaTypes("application/json"));

        String serverUrl=null;

        String host=this.properties.confluence().getHost();
        String endpoint=this.properties.confluence().getGetdata_endpoint();

        HttpEntity<String> requestEntity=new HttpEntity<>(headers);

        serverUrl=host+endpoint+title+"&expand=body.view,version";

        ResponseEntity<ConfluencePageResponse> response=restTemplate.exchange(serverUrl, HttpMethod.GET,requestEntity,new ParameterizedTypeReference<ConfluencePageResponse>(){});
        ConfluencePageResponse confluencePageResponse=response.getBody();

        Document doc = Jsoup.parse(confluencePageResponse.getPageDetails().get(0).getBody().getView().getValue());

        String content = doc.getElementsByTag("p").text();

        confluencePageResponse.getPageDetails().get(0).getBody().getView().setValue(content);



        System.out.println(content);
        requirementConfluenceProject.setProjectId("TEAM");
        requirementConfluenceProject.setTitle( confluencePageResponse.getPageDetails().get(0).getTitle());
        requirementConfluenceProject.setDescription(content);



        HttpHeaders confHeaders=new HttpHeaders();
       // confHeaders.add("Authorization",cred);
        confHeaders.setContentType(MediaType.APPLICATION_JSON);


        HttpEntity<String> confRequestEntity=new HttpEntity<>(confluencePageResponse.toString(), confHeaders );

        serverUrl="https://81f1-2409-40c2-1007-7ddd-8d98-c519-cd69-452a.ngrok-free.app/get-brd-summary";

        String result = restTemplate.postForObject(serverUrl,confRequestEntity, String.class);

        System.out.println(result);





        designDetailsRepository.save(requirementConfluenceProject);

        return confluencePageResponse;//response.getBody();
    }


    @RequestMapping(path="/confluence/project/{projectId}",method=RequestMethod.PUT)
    public ResponseEntity<Integer> updateJiraProjectWithLMSummary(@RequestHeader("Authorization") final String cred, @PathVariable("projectId") String projectId, @RequestBody RequirementConfluenceProject reqDetails){
        RequirementConfluenceProject projectDetails=designDetailsRepository.findByProjectIdIgnoreCase(projectId);

        if(projectDetails.getProjectId()!=null) {
            requirementConfluenceProject.setLlmConfSummary(reqDetails.getLlmConfSummary());
            return new ResponseEntity<>(designDetailsRepository.updateProjectSummary(projectId, reqDetails.getLlmConfSummary()), HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
