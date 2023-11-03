package com.example.demo.services;

import com.example.demo.models.Comidas;
import com.example.demo.models.Role;
import com.example.demo.repositories.ComidasRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ComidasService {
    @Autowired
    ComidasRepository comidasRepository;

    //GET
    public ArrayList<Comidas> obtenerComidas(){
        return (ArrayList<Comidas>) comidasRepository.findAll();
    }

    //GETbyID
    public Optional<Comidas> obtenerId(Integer id){
        return comidasRepository.findById(id);
    }

    //POST
    public Comidas guardarComida(Comidas comida) {
        return comidasRepository.save(comida);
    }

    //PUT
    public Comidas actualizarComida(Integer id, Comidas nuevaComida) {
        Optional<Comidas> comidaExistente = comidasRepository.findById(id);

        if (comidaExistente.isPresent()) {
            Comidas comida = comidaExistente.get();

            comida.setNombre(nuevaComida.getNombre());
            comida.setCosto(nuevaComida.getCosto());
            comida.setVenta(nuevaComida.getVenta());
            comida.setDescripcion(nuevaComida.getDescripcion());
            comida.setEstado(nuevaComida.getEstado());
            /*
            comida.setCreated_at(nuevaComida.getCreated_at());
            comida.setUpdated_at(nuevaComida.getUpdated_at());
            */
            return comidasRepository.save(comida);
        } else {
            throw new EntityNotFoundException("Comida no encontrada con ID: " + id);
        }
    }

    //DELETE
    public void eliminarComida(Integer id) {
        Optional<Comidas> comidaExistente = comidasRepository.findById(id);

        if (comidaExistente.isPresent()) {
            comidasRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Comida no encontrada con ID: " + id);
        }
    }

}
