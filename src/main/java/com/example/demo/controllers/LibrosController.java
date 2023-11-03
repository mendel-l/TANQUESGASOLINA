package com.example.demo.controllers;

import com.example.demo.models.Libros;
import com.example.demo.models.Videos;
import com.example.demo.request.RequestDTO;
import com.example.demo.response.ResponseDTO;
import com.example.demo.services.LibrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("libros")
public class LibrosController {

    @Autowired
    LibrosService librosService;

    @GetMapping("/get")
    public ArrayList<Libros> get(){
        return librosService.get();
    }

    //GETbyID
    @GetMapping("/get/{id}")
    public Optional<Libros> getId(@PathVariable("id") Integer id){
        return this.librosService.getId(id);
    }

    //POST
    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> create(@RequestBody RequestDTO requestDTO){
        return this.librosService.create(requestDTO);
    }

    //PUT
    @PutMapping("/put/{id}")
    public ResponseEntity<ResponseDTO> update(@RequestBody RequestDTO requestDTO){
        return librosService.update(requestDTO);
    }

    //DELETE

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete(@RequestBody RequestDTO requestDTO){
        return librosService.delete(requestDTO);
    }

}
