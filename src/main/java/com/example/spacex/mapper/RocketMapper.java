package com.example.spacex.mapper;

import com.example.spacex.dto.RocketDto;
import com.example.spacex.entity.Rocket;

import java.time.LocalDate;

public class RocketMapper {

    public static Rocket toEntity(RocketDto dto){
        Rocket rocket = new Rocket();

        rocket.setSpacexRocketId(dto.getId());
        rocket.setName(dto.getName());

        if (dto.getFirst_flight() != null && !dto.getFirst_flight().isEmpty()) {
            rocket.setFirstFlight(LocalDate.parse(dto.getFirst_flight()));
        }

        return rocket;
    }
}
