package com.beyond.infinity.demo.response.conf;

import com.fasterxml.jackson.annotation.JsonProperty;

public class View {

    @JsonProperty("value")
    private String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
