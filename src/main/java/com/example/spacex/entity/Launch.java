package com.example.spacex.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "launch")
public class Launch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String spacexLaunchId;

    @ManyToOne
    @JoinColumn(name = "rocket_id")
    private Rocket rocket;

    private String missionName;

    private LocalDateTime launchDateUtc;

    private Boolean isSuccess;

    private Boolean isUpcoming;

    private String missionStatus;

    private String payloadIds;

    public Launch() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSpacexLaunchId() {
        return spacexLaunchId;
    }

    public void setSpacexLaunchId(String spacexLaunchId) {
        this.spacexLaunchId = spacexLaunchId;
    }

    public Rocket getRocket() {
        return rocket;
    }

    public void setRocket(Rocket rocket) {
        this.rocket = rocket;
    }

    public String getMissionName() {
        return missionName;
    }

    public void setMissionName(String missionName) {
        this.missionName = missionName;
    }

    public LocalDateTime getLaunchDateUtc() {
        return launchDateUtc;
    }

    public void setLaunchDateUtc(LocalDateTime launchDateUtc) {
        this.launchDateUtc = launchDateUtc;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public Boolean getUpcoming() {
        return isUpcoming;
    }

    public void setUpcoming(Boolean upcoming) {
        isUpcoming = upcoming;
    }

    public String getMissionStatus() {
        return missionStatus;
    }

    public void setMissionStatus(String missionStatus) {
        this.missionStatus = missionStatus;
    }

    public String getPayloadIds() {
        return payloadIds;
    }

    public void setPayloadIds(String payloadIds) {
        this.payloadIds = payloadIds;
    }
}
