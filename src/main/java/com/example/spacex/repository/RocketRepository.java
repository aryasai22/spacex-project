package com.example.spacex.repository;

import com.example.spacex.entity.Rocket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RocketRepository extends JpaRepository<Rocket, Long> {

}
