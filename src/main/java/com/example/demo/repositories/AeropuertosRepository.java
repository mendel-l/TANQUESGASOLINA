package com.example.demo.repositories;

import com.example.demo.models.Aeropuertos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AeropuertosRepository extends JpaRepository<Aeropuertos, Integer> {
}
