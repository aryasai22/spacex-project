package com.example.spacex.service;

import com.example.spacex.dto.RocketDto;
import com.example.spacex.entity.Rocket;
import com.example.spacex.mapper.RocketMapper;
import com.example.spacex.repository.RocketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SpaceXApiService {

    private final RestTemplate restTemplate;
    private final RocketRepository rocketRepository;

    @Autowired
    public SpaceXApiService(RestTemplate restTemplate, RocketRepository rocketRepository) {
        this.restTemplate = restTemplate;
        this.rocketRepository = rocketRepository;
    }

    public RocketDto[] fetchRockets() {
        String url = "https://api.spacexdata.com/v4/rockets";
        return restTemplate.getForObject(url, RocketDto[].class);
    }

    public void loadRocketsIntoDB() {

        RocketDto[] rocketDtos = fetchRockets();

        for (RocketDto dto : rocketDtos) {
            Rocket rocket = RocketMapper.toEntity(dto);

            if (!rocketRepository.existsBySpacexRocketId(dto.getId())) {
                rocketRepository.save(rocket);
            }
        }


    }

}
