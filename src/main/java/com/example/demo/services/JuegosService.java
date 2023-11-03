package com.example.demo.services;

import com.example.demo.models.Comidas;
import com.example.demo.models.Juegos;
import com.example.demo.repositories.JuegosRepository;
import io.micrometer.common.lang.Nullable;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class JuegosService {
    @Autowired
    JuegosRepository juegosRepository;

    //GET
    public ArrayList<Juegos> getJuegos(){
        return (ArrayList<Juegos>) juegosRepository.findAll();
    }

    //GETbyID
    public Optional<Juegos> getId(Integer id){
        return juegosRepository.findById(id);
    }

    //POST
    public Juegos saveJuego(Juegos juego) {
        return juegosRepository.save(juego);
    }

    //PUT
    public Juegos updateJuego(Integer id, Juegos updateJuego) {
        Optional<Juegos> juegoExist = juegosRepository.findById(id);

        if (juegoExist.isPresent()) {
            Juegos juego = juegoExist.get();

            juego.setTitulo(updateJuego.getTitulo());
            juego.setPlataforma(updateJuego.getPlataforma());
            juego.setGenero(updateJuego.getGenero());
            juego.setPrecio(updateJuego.getPrecio());
            juego.setDescripcion(updateJuego.getDescripcion());

            /*
            comida.setCreated_at(nuevaComida.getCreated_at());
            comida.setUpdated_at(nuevaComida.getUpdated_at());
            */
            return juegosRepository.save(juego);
        } else {
            throw new EntityNotFoundException("Juego no encontrada con ID: " + id);
        }
    }

    //DELETE
    public void deleteJuego(Integer id) {
        Optional<Juegos>juegoExist = juegosRepository.findById(id);

        if (juegoExist.isPresent()) {
            juegosRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Comida no encontrada con ID: " + id);
        }
    }
}
