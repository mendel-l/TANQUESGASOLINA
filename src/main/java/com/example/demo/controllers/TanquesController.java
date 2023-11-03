package com.example.demo.controllers;

import com.example.demo.models.Tanques;
import com.example.demo.models.Videos;
import com.example.demo.services.TanquesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("tanques")
public class TanquesController {
    @Autowired
    TanquesService tanquesService;

    //GET
    @GetMapping("/get")
    public ArrayList<Tanques> get(){
        return tanquesService.get();
    }

    //GETbyID
    @GetMapping("/get/{id}")
    public Optional<Tanques> getId(@PathVariable("id") Integer id){
        return this.tanquesService.getId(id);
    }

    //POST
    @PostMapping("/post") //create
    public ResponseEntity<Tanques> create(@RequestBody Tanques tanque) {
        Tanques newDato = tanquesService.create(tanque);
        return new ResponseEntity<>(newDato, HttpStatus.CREATED);
    }

    // PUT
    @PutMapping("/put/{id}") //update
    public ResponseEntity<Tanques>update(@PathVariable("id") Integer id, @RequestBody Tanques tanque) {
        Optional<Tanques> Exist = tanquesService.getId(id);

        if (Exist.isPresent()) {
            Tanques Update = tanquesService.update(id, tanque);
            return new ResponseEntity<>(Update, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        Optional<Tanques> Exist = tanquesService.getId(id);

        if (Exist.isPresent()) {
            tanquesService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
