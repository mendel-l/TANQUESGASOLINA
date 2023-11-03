package com.example.demo.repositories;

import com.example.demo.models.Videos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface VideosRepository extends JpaRepository<Videos, Integer>{
    @Transactional
    @Modifying
    @Query("UPDATE Videos c set c.titulo = :titulo where c.id = :id")
    void updateTitulo(@Param("titulo") String titulo, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Videos c set c.visitas = :visitas where c.id = :id")
    void updateVisitas(@Param("visitas") Double visitas, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Videos c set c.descripcion = :descripcion where c.id = :id")
    void updateDescripcion(@Param("descripcion") String descripcion, @Param("id") Integer id);
}
