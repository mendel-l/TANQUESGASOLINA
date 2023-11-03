package com.example.demo.models;
import jakarta.persistence.*;

@Entity
@Table(name = "tanques")
public class Tanques {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Integer id;

    @Column(nullable = false)
    private Double capacidad;
    private Double nivelactual;
    private String ubicacion;
    private String tipogas;
    private String cliente;
    private String tipopago;

    //GETTER Y SETTER

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(Double capacidad) {
        this.capacidad = capacidad;
    }

    public Double getNivelactual() {
        return nivelactual;
    }

    public void setNivelactual(Double nivelactual) {
        this.nivelactual = nivelactual;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTipogas() {
        return tipogas;
    }

    public void setTipogas(String tipogas) {
        this.tipogas = tipogas;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getTipopago() {
        return tipopago;
    }

    public void setTipopago(String tipopago) {
        this.tipopago = tipopago;
    }
}
