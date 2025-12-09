package com.example.spacex.dto;

import java.util.List;

public class LaunchDto {

    private String id;
    private String name;
    private String date_utc;
    private Boolean success;
    private Boolean upcoming;

    private String rocket;
    private List<String> payloads;

    public LaunchDto() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate_utc() {
        return date_utc;
    }

    public void setDate_utc(String date_utc) {
        this.date_utc = date_utc;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Boolean getUpcoming() {
        return upcoming;
    }

    public void setUpcoming(Boolean upcoming) {
        this.upcoming = upcoming;
    }

    public String getRocket() {
        return rocket;
    }

    public void setRocket(String rocket) {
        this.rocket = rocket;
    }

    public List<String> getPayloads() {
        return payloads;
    }

    public void setPayloads(List<String> payloads) {
        this.payloads = payloads;
    }
}
