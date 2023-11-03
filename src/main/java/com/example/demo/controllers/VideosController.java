package com.example.demo.controllers;
import com.example.demo.models.Videos;
import com.example.demo.services.VideosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("videos")
public class VideosController {

    @Autowired
    VideosService videosService;

    //GET
    @GetMapping("/get")
    public ArrayList<Videos> get(){
        return videosService.get();
    }

    //GETbyID
    @GetMapping("/get/{id}")
    public Optional<Videos> getId(@PathVariable("id") Integer id){
        return this.videosService.getId(id);
    }

    //POST

    @PostMapping("/post") //create
    public ResponseEntity<Videos> create(@RequestBody Videos video) {
        Videos newVideo = videosService.create(video);
        return new ResponseEntity<>(newVideo, HttpStatus.CREATED);
    }

    /*
    @PostMapping("/post")
    public ResponseEntity<ResponseDTO> create(@RequestBody RequestDTO requestDTO){
        return this.videosService.create(requestDTO);
    }

     */

    // PUT

    @PutMapping("/put/{id}") //update
    public ResponseEntity<Videos>update(@PathVariable("id") Integer id, @RequestBody Videos video) {
        Optional<Videos> Exist = videosService.getId(id);

        if (Exist.isPresent()) {
            Videos videoUpdate = videosService.update(id, video);
            return new ResponseEntity<>(videoUpdate, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
     /*
    @PutMapping("/put/{id}")
    public ResponseEntity<ResponseDTO> update(@RequestBody RequestDTO requestDTO){
        return videosService.update(requestDTO);
    }

      */

    //DELETE

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
        Optional<Videos> Exist = videosService.getId(id);

        if (Exist.isPresent()) {
            videosService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

/*
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseDTO> delete(@RequestBody RequestDTO requestDTO){
        return videosService.delete(requestDTO);
    }

 */
}
