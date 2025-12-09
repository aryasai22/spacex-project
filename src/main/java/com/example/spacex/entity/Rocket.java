package com.example.spacex.entity;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "rocket")
public class Rocket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String spacexRocketId;

    private String name;

    private LocalDate firstFlight;

    public Rocket() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpacexRocketId() {
        return spacexRocketId;
    }

    public void setSpacexRocketId(String spacexRocketId) {
        this.spacexRocketId = spacexRocketId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getFirstFlight() {
        return firstFlight;
    }

    public void setFirstFlight(LocalDate firstFlight) {
        this.firstFlight = firstFlight;
    }
}

