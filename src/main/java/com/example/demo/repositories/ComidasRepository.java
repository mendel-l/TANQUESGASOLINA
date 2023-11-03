package com.example.demo.repositories;

import com.example.demo.models.Comidas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComidasRepository extends JpaRepository<Comidas, Integer> {
}


