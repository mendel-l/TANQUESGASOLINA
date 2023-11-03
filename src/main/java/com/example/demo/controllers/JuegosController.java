package com.example.demo.controllers;

import com.example.demo.models.Comidas;
import com.example.demo.models.Juegos;
import com.example.demo.services.JuegosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class JuegosController {
    @Autowired
    JuegosService juegosService;

    //GET
    @GetMapping("/juegos")
    public ArrayList<Juegos> getJuegos(){
        return juegosService.getJuegos();
    }
    //GETbyID
    @GetMapping("/juegos/{id}")
    public Optional<Juegos> getId(@PathVariable("id") Integer id){
        return this.juegosService.getId(id);
    }
    //POST
    @PostMapping("juegos/create")
    public ResponseEntity<Juegos> saveJuegos(@RequestBody Juegos juego) {
        Juegos newJuego = juegosService.saveJuego(juego);
        return new ResponseEntity<>(newJuego, HttpStatus.CREATED);
    }

    // PUT
    @PutMapping("/juegos/update/{id}")
    public ResponseEntity<Juegos>updateJuego(@PathVariable("id") Integer id, @RequestBody Juegos juego) {
        Optional<Juegos> juegoExist = juegosService.getId(id);

        if (juegoExist.isPresent()) {
            Juegos juegoUpdate = juegosService.updateJuego(id, juego);
            return new ResponseEntity<>(juegoUpdate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //DELETE
    @DeleteMapping("/juegos/delete/{id}")
    public ResponseEntity<Void> deleteJuego(@PathVariable("id") Integer id) {
        Optional<Juegos> juegoExist = juegosService.getId(id);

        if (juegoExist.isPresent()) {
            juegosService.deleteJuego(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
