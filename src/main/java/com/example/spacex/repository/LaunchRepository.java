package com.example.spacex.repository;

import com.example.spacex.entity.Launch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaunchRepository extends JpaRepository<Launch, Long> {

}
