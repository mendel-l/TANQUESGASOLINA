package com.example.demo.repositories;

import com.example.demo.models.Libros;
import com.example.demo.models.Videos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface LibrosRepository extends JpaRepository<Libros, Integer> {

    @Transactional
    @Modifying
    @Query("UPDATE Libros c set c.author = :author where c.id = :id")
    void updateAuthor(@Param("author") String author, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Libros c set c.title = :title where c.id = :id")
    void updateTitle(@Param("title") String title, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Libros c set c.type = :type where c.id = :id")
    void updateType(@Param("type") String type, @Param("id") Integer id);
}
