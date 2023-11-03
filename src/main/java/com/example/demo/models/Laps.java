package com.example.demo.models;

import jakarta.persistence.*;

@Entity
@Table (name = "laps")
public class Laps {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false)

    private String marca;
    private String modelo;
    private String tipoprocesador;
    private String sistemaoperativo;
    private String descripcion;
    private Double memoriaram;
    private Double capacidadalmacenamiento;
    private Double precio;


    //GETTER Y SETTER


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipoprocesador() {
        return tipoprocesador;
    }

    public void setTipoprocesador(String tipoprocesador) {
        this.tipoprocesador = tipoprocesador;
    }

    public String getSistemaoperativo() {
        return sistemaoperativo;
    }

    public void setSistemaoperativo(String sistemaoperativo) {
        this.sistemaoperativo = sistemaoperativo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getMemoriaram() {
        return memoriaram;
    }

    public void setMemoriaram(Double memoriaram) {
        this.memoriaram = memoriaram;
    }

    public Double getCapacidadalmacenamiento() {
        return capacidadalmacenamiento;
    }

    public void setCapacidadalmacenamiento(Double capacidadalmacenamiento) {
        this.capacidadalmacenamiento = capacidadalmacenamiento;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }
}
