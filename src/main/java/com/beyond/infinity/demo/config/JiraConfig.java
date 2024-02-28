package com.beyond.infinity.demo.config;

public class JiraConfig {

    private String host;
    private String port;
    private String getdata_endpoint;
    private String search_query;

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getGetdata_endpoint() {
        return getdata_endpoint;
    }

    public void setGetdata_endpoint(String getdata_endpoint) {
        this.getdata_endpoint = getdata_endpoint;
    }

    public String getSearch_query() {
        return search_query;
    }

    public void setSearch_query(String search_query) {
        this.search_query = search_query;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }
}
