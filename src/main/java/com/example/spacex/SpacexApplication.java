package com.example.spacex;

import com.example.spacex.service.SpaceXApiService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class SpacexApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpacexApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(SpaceXApiService spaceXApiService) {
        return args -> {


            spaceXApiService.loadRocketsIntoDB();


            spaceXApiService.loadLaunchesIntoDB();

            System.out.println("Data load complete.");
        };
    }


}
