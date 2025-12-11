package com.example.spacex.controller;

import com.example.spacex.entity.Rocket;
import com.example.spacex.repository.RocketRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/rockets")
public class RocketController {

    private final RocketRepository rocketRepository;

    public RocketController(RocketRepository rocketRepository) {
        this.rocketRepository = rocketRepository;
    }

    @GetMapping
    public List<Rocket> getAllRockets() {
        return rocketRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rocket> getRocketById(@PathVariable Long id) {
        return rocketRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
