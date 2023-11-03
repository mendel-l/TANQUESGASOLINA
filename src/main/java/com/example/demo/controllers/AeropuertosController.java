package com.example.demo.controllers;

import com.example.demo.models.Aeropuertos;
import com.example.demo.models.Juegos;
import com.example.demo.services.AeropuertosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AeropuertosController {
    @Autowired
    AeropuertosService aeropuertosService;

    //GET
    @GetMapping("/airports")
    public ArrayList<Aeropuertos> getaeropuertos() {
        return aeropuertosService.getAeropuertos();
    }

    //GETbyID
    @GetMapping("/airports/{id}")
    public Optional<Aeropuertos> getId(@PathVariable("id") Integer id){
        return this.aeropuertosService.getId(id);
    }

    //POST
    @PostMapping("airports/create")
    public ResponseEntity<Aeropuertos> saveAeropuertos(@RequestBody Aeropuertos aeropuerto) {
        Aeropuertos newAeropuerto = aeropuertosService.saveAeropuerto(aeropuerto);
        return new ResponseEntity<>(newAeropuerto, HttpStatus.CREATED);
    }

    // PUT
    @PutMapping("/airports/update/{id}")
    public ResponseEntity<Aeropuertos>updateAeropuerto(@PathVariable("id") Integer id, @RequestBody Aeropuertos aeropuerto) {
        Optional<Aeropuertos> aeropuertoExist = aeropuertosService.getId(id);

        if (aeropuertoExist.isPresent()) {
            Aeropuertos aeropuertoUpdate = aeropuertosService.updateAeropuerto(id, aeropuerto);
            return new ResponseEntity<>(aeropuertoUpdate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //DELETE
    @DeleteMapping("/airports/delete/{id}")
    public ResponseEntity<Void> deleteAeropuerto(@PathVariable("id") Integer id) {
        Optional<Aeropuertos> aeropuertoExist = aeropuertosService.getId(id);

        if (aeropuertoExist.isPresent()) {
            aeropuertosService.deleteAeropuerto(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
