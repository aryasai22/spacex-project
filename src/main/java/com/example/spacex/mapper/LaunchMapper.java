package com.example.spacex.mapper;

import com.example.spacex.dto.LaunchDto;
import com.example.spacex.entity.Launch;
import com.example.spacex.entity.Rocket;
import com.example.spacex.repository.RocketRepository;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Collectors;

public class LaunchMapper {

    public static Launch toEntity(LaunchDto dto, RocketRepository rocketRepository) {

        Launch launch = new Launch();

        launch.setSpacexLaunchId(dto.getId());
        launch.setMissionName(dto.getName());

        launch.setSuccess(dto.getSuccess());
        launch.setUpcoming(dto.getUpcoming());

        if (dto.getDate_utc() != null) {
            launch.setLaunchDateUtc(LocalDateTime.parse(dto.getDate_utc(), DateTimeFormatter.ISO_DATE_TIME));
        }

        if (Boolean.TRUE.equals(dto.getUpcoming())) {
            launch.setMissionStatus("Upcoming");
        } else if (Boolean.TRUE.equals(dto.getSuccess())) {
            launch.setMissionStatus("Success");
        } else {
            launch.setMissionStatus("Failed");
        }

        if (dto.getPayloads() != null) {
            String payloadString = dto.getPayloads()
                    .stream()
                    .collect(Collectors.joining(","));

            launch.setPayloadIds(payloadString);
        }

        Rocket rocket = rocketRepository.findBySpacexRocketId(dto.getRocket());
        launch.setRocket(rocket);

        return launch;

    }
}
