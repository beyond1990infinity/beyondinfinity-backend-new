package com.beyond.infinity.demo.response.conf;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Body {

    @JsonProperty("view")
    private View view;

    public View getView() {
        return view;
    }

    public void setView(View view) {
        this.view = view;
    }
}
