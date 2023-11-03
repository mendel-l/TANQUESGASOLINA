package com.example.demo.services;

import com.example.demo.models.Laps;
import com.example.demo.models.Tanques;
import com.example.demo.repositories.LapsRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class LapsService {

    @Autowired
    LapsRepository lapsRepository;

    //GET
    public ArrayList<Laps> get(){
        return (ArrayList<Laps>) lapsRepository.findAll();
    }

    //GETbyID
    public Optional<Laps> getId(Integer id){
        return lapsRepository.findById(id);
    }

    //POST
    public Laps create(Laps lap) {
        return lapsRepository.save(lap);
    }

    //PUT
    public Laps update(Integer id, Laps update) {
        Optional<Laps> Exist = lapsRepository.findById(id);

        if (Exist.isPresent()) {
            Laps datos = Exist.get();
            datos.setMarca(update.getMarca());
            datos.setModelo(update.getModelo());
            datos.setTipoprocesador(update.getTipoprocesador());
            datos.setSistemaoperativo(update.getSistemaoperativo());
            datos.setDescripcion(update.getDescripcion());
            datos.setMemoriaram(update.getMemoriaram());
            datos.setCapacidadalmacenamiento(update.getCapacidadalmacenamiento());
            datos.setPrecio(update.getPrecio());
            return lapsRepository.save(datos);
        } else {
            throw new EntityNotFoundException("Laptopno encontrada con ID: " + id);
        }
    }

    //DELETE
    public void delete(Integer id) {
        Optional<Laps>Exist = lapsRepository.findById(id);

        if (Exist.isPresent()) {
            lapsRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Error 404 no encontrada con ID: " + id);
        }
    }
}
