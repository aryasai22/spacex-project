package com.example.spacex.controller;


import com.example.spacex.entity.Launch;
import com.example.spacex.repository.LaunchRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/launches")
public class LaunchController {

    private final LaunchRepository launchRepository;

    public LaunchController(LaunchRepository launchRepository) {
        this.launchRepository = launchRepository;
    }

    @GetMapping
    public List<Launch> getLaunches() {
        return launchRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Launch> getLaunchById(@PathVariable Long id) {
        return launchRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
