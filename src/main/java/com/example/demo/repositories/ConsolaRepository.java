package com.example.demo.repositories;

import com.example.demo.models.Consola;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ConsolaRepository extends JpaRepository<Consola, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE Consola c set c.nombre = :nombre where c.id = :id")
    void updateNombre(@Param("nombre") String nombre, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Consola c set c.lanzamiento = :lanzamiento where c.id = :id")
    void updateLanzamiento(@Param("lanzamiento") Integer lanzamiento, @Param("id") Integer id);
}
