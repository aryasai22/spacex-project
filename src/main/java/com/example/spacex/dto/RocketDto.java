package com.example.spacex.dto;

import com.example.spacex.entity.Rocket;

public class RocketDto {

    private String id;
    private String name;
    private String first_flight;

    public RocketDto() {
    }

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

    public String getFirst_flight() {
        return first_flight;
    }

    public void setFirst_flight(String first_flight) {
        this.first_flight = first_flight;
    }
}
