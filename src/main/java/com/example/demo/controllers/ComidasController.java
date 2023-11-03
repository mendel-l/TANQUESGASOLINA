package com.example.demo.controllers;

import com.example.demo.models.Comidas;
import com.example.demo.models.Role;
import com.example.demo.services.ComidasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

//para el GET
import java.util.ArrayList;
//para el GET by ID
import java.util.Optional;


@RestController
@RequestMapping("/api")
public class ComidasController {
    @Autowired
    ComidasService comidasService;

    //GET
    @GetMapping("/comidas")
    public ArrayList<Comidas> obtenerComidas(){
        return comidasService.obtenerComidas();
    }
    //GETbyID
    @GetMapping("/comidas/{id}")
    public Optional<Comidas> obtenerId(@PathVariable("id") Integer id){
        return this.comidasService.obtenerId(id);
    }
    //POST
    @PostMapping("comidas/create")
    public ResponseEntity<Comidas> guardarComida(@RequestBody Comidas comida) {
        Comidas nuevaComida = comidasService.guardarComida(comida);
        return new ResponseEntity<>(nuevaComida, HttpStatus.CREATED);
    }

    // PUT
    @PutMapping("/comidas/update/{id}")
    public ResponseEntity<Comidas> actualizarComida(@PathVariable("id") Integer id, @RequestBody Comidas comida) {
        Optional<Comidas> comidaExistente = comidasService.obtenerId(id);

        if (comidaExistente.isPresent()) {
            Comidas comidaActualizada = comidasService.actualizarComida(id, comida);
            return new ResponseEntity<>(comidaActualizada, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //DELETE
    @DeleteMapping("/comidas/delete/{id}")
    public ResponseEntity<Void> eliminarComida(@PathVariable("id") Integer id) {
        Optional<Comidas> comidaExistente = comidasService.obtenerId(id);

        if (comidaExistente.isPresent()) {
            comidasService.eliminarComida(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
