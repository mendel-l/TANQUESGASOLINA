package com.example.demo.controllers;

import com.example.demo.models.Consola;
import com.example.demo.request.RequestDTO;
import com.example.demo.response.ResponseDTO;
import com.example.demo.services.ConsolaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/consolas")
public class ConsolaController {
    @Autowired
    ConsolaService consolaService;

    //GET
    @GetMapping("/todas")
    public ArrayList<Consola> obtenerConsolas() {
        return consolaService.obtenerTodasLasConsolas();
    }

    //GET ID
    @GetMapping("/individual/{id}")
    public Optional<Consola> obtenerConsola(@PathVariable("id") Integer id) {
        return consolaService.obtenerIdConsola(id);
    }

    //POST
    @PostMapping("/consola")
    public ResponseEntity<ResponseDTO> guardarConsola(@RequestBody RequestDTO requestDTO){
        return this.consolaService.guardarConsola(requestDTO);
    }

    //PUT
    @PutMapping("/actualizar")
    public ResponseEntity<ResponseDTO> actualizarConsola(@RequestBody RequestDTO requestDTO){
        return consolaService.actualizarConsola(requestDTO);
    }

    //DELETE
    @DeleteMapping("/eliminar")
    public ResponseEntity<ResponseDTO> eliminarConsola(@RequestBody RequestDTO requestDTO){
        return consolaService.eliminarConsola(requestDTO);
    }
}
