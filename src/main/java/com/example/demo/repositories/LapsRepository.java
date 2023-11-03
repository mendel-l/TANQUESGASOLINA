package com.example.demo.repositories;

import com.example.demo.models.Laps;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LapsRepository extends JpaRepository<Laps, Integer> {
}
