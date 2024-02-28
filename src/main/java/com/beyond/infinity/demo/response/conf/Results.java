package com.beyond.infinity.demo.response.conf;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Results {

    @JsonProperty("title")
    private String title;
    private Body body;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }
}
