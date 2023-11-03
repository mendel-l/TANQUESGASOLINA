package com.example.demo.models;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "airports")
public class Aeropuertos {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String nombreuser;
    private String nombreaero;
    private Integer cantidadvisitas;
    @Nullable
    private Timestamp createdAt;
    private Timestamp updatedAt;

    //GET Y SET
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreuser() {
        return nombreuser;
    }

    public void setNombreuser(String nombreuser) {
        this.nombreuser = nombreuser;
    }

    public String getNombreaero() {
        return nombreaero;
    }

    public void setNombreaero(String nombreaero) {
        this.nombreaero = nombreaero;
    }

    public Integer getCantidadvisitas() {
        return cantidadvisitas;
    }

    public void setCantidadvisitas(Integer cantidadvisitas) {
        this.cantidadvisitas = cantidadvisitas;
    }

    @Nullable
    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(@Nullable Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
