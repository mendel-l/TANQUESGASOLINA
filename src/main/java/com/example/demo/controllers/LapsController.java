package com.example.demo.controllers;

import com.example.demo.models.Laps;
import com.example.demo.models.Tanques;
import com.example.demo.services.LapsService;
import com.example.demo.services.TanquesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("laps")
public class LapsController {

    @Autowired
    LapsService lapsService;

    //GET
    @GetMapping("/get")
    public ArrayList<Laps> get(){
        return lapsService.get();
    }

    //GETbyID
    @GetMapping("/get/{id}")
    public Optional<Laps> getId(@PathVariable("id") Integer id){
        return this.lapsService.getId(id);
    }

    //POST
    @PostMapping("/post") //create
    public ResponseEntity<Laps> create(@RequestBody Laps lap) {
        Laps newDato = lapsService.create(lap);
        return new ResponseEntity<>(newDato, HttpStatus.CREATED);
    }

    // PUT
    @PutMapping("/put/{id}") //update
    public ResponseEntity<Laps>update(@PathVariable("id") Integer id, @RequestBody Laps lap) {
        Optional<Laps> Exist = lapsService.getId(id);

        if (Exist.isPresent()) {
            Laps Update = lapsService.update(id, lap);
            return new ResponseEntity<>(Update, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //DELETE
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        Optional<Laps> Exist = lapsService.getId(id);

        if (Exist.isPresent()) {
            lapsService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
