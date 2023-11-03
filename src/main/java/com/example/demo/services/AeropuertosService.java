package com.example.demo.services;
import com.example.demo.models.Aeropuertos;
import com.example.demo.models.Juegos;
import com.example.demo.repositories.AeropuertosRepository;
import io.micrometer.common.lang.Nullable;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class AeropuertosService {
    @Autowired
    AeropuertosRepository aeropuertosRepository;

    //GET
    public ArrayList<Aeropuertos> getAeropuertos() {
        return (ArrayList<Aeropuertos>) aeropuertosRepository.findAll();
    }

    //GETbyID
    public Optional<Aeropuertos> getId(Integer id){
        return aeropuertosRepository.findById(id);
    }

    //POST
    public Aeropuertos saveAeropuerto(Aeropuertos aeropuerto) {
        return aeropuertosRepository.save(aeropuerto);
    }

    //PUT
    public Aeropuertos updateAeropuerto(Integer id, Aeropuertos updateAeropuerto) {
        Optional<Aeropuertos> aeropuertoExist = aeropuertosRepository.findById(id);

        if (aeropuertoExist.isPresent()) {
            Aeropuertos aeropuerto = aeropuertoExist.get();

            aeropuerto.setNombreuser(updateAeropuerto.getNombreuser());
            aeropuerto.setNombreaero(updateAeropuerto.getNombreaero());
            aeropuerto.setCantidadvisitas(updateAeropuerto.getCantidadvisitas());

            return aeropuertosRepository.save(aeropuerto);
        } else {
            throw new EntityNotFoundException("no encontrada con ID: " + id);
        }
    }

    //DELETE
    public void deleteAeropuerto(Integer id) {
        Optional<Aeropuertos>aeropuertoExist = aeropuertosRepository.findById(id);

        if (aeropuertoExist.isPresent()) {
            aeropuertosRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("no encontrada con ID: " + id);
        }
    }

}
