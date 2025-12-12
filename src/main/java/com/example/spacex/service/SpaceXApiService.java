package com.example.spacex.service;

import com.example.spacex.dto.LaunchDto;
import com.example.spacex.dto.RocketDto;
import com.example.spacex.entity.Launch;
import com.example.spacex.entity.Rocket;
import com.example.spacex.mapper.LaunchMapper;
import com.example.spacex.mapper.RocketMapper;
import com.example.spacex.repository.LaunchRepository;
import com.example.spacex.repository.RocketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class SpaceXApiService {

    private final RestTemplate restTemplate;
    private final RocketRepository rocketRepository;
    private final LaunchRepository launchRepository;

    @Autowired
    public SpaceXApiService(RestTemplate restTemplate, RocketRepository rocketRepository, LaunchRepository launchRepository) {
        this.restTemplate = restTemplate;
        this.rocketRepository = rocketRepository;
        this.launchRepository = launchRepository;
    }

    public RocketDto[] fetchRockets() {
        String url = "https://api.spacexdata.com/v4/rockets";
        return restTemplate.getForObject(url, RocketDto[].class);
    }

    public LaunchDto[] fetchLaunches() {
        String url = "https://api.spacexdata.com/v5/launches";
        return restTemplate.getForObject(url, LaunchDto[].class);
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

    public void loadLaunchesIntoDB() {

        LaunchDto[] launchDtos = fetchLaunches();

        for (LaunchDto dto : launchDtos) {

            Launch launch = LaunchMapper.toEntity(dto, rocketRepository);

            if (!launchRepository.existsBySpacexLaunchId(dto.getId())) {
                launchRepository.save(launch);
            }
        }

        System.out.println("Launches successfully saved into DB.");
    }

    @Scheduled(cron = "0 0 */12 * * *")
    public void scheduledSync() {
        System.out.println("Running scheduled SpaceX sync...");

        loadLaunchesIntoDB();
        loadRocketsIntoDB();

        System.out.println("SpaceX sync complete. ");
    }


}
