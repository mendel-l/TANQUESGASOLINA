package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table(name = "consolas")
public class Consola {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;
    @Column(unique = false)
    private String nombre;
    private Integer lanzamiento;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getLanzamiento() {
        return lanzamiento;
    }

    public void setLanzamiento(Integer lanzamiento) {
        this.lanzamiento = lanzamiento;
    }
}
