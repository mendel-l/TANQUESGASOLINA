package com.example.demo.models;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;

@Entity
@Table(name = "videos")
public class Videos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String titulo;
    private Double visitas;

    @Nullable
    private String descripcion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    // Getters y settersV
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getVisitas() {
        return visitas;
    }

    public void setVisitas(Double visitas) {
        this.visitas = visitas;
    }

    @Nullable
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(@Nullable String descripcion) {
        this.descripcion = descripcion;
    }
}
