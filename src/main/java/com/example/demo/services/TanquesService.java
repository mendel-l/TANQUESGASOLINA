package com.example.demo.services;

import com.example.demo.models.Tanques;
import com.example.demo.models.Videos;
import com.example.demo.repositories.TanquesRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TanquesService {
    @Autowired
    TanquesRepository tanquesRepository;

    //GET
    public ArrayList<Tanques> get(){
        return (ArrayList<Tanques>) tanquesRepository.findAll();
    }

    //GETbyID
    public Optional<Tanques> getId(Integer id){
        return tanquesRepository.findById(id);
    }

    //POST
    public Tanques create(Tanques tanque) {
        return tanquesRepository.save(tanque);
    }

    //PUT
    public Tanques update(Integer id, Tanques update) {
        Optional<Tanques> Exist = tanquesRepository.findById(id);

        if (Exist.isPresent()) {
            Tanques datos = Exist.get();
            datos.setCapacidad(update.getCapacidad());
            datos.setNivelactual(update.getNivelactual());
            datos.setUbicacion(update.getUbicacion());
            datos.setTipogas(update.getTipogas());
            datos.setCliente(update.getCliente());
            datos.setTipopago(update.getTipopago());
            return tanquesRepository.save(datos);
        } else {
            throw new EntityNotFoundException("Tanque no encontrada con ID: " + id);
        }
    }

    //DELETE
    public void delete(Integer id) {
        Optional<Tanques>Exist = tanquesRepository.findById(id);

        if (Exist.isPresent()) {
            tanquesRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Error 404 no encontrada con ID: " + id);
        }
    }
}
