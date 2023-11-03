package com.example.demo.services;

import com.example.demo.models.Libros;
import com.example.demo.models.Videos;
import com.example.demo.repositories.LibrosRepository;
import com.example.demo.request.RequestDTO;
import com.example.demo.response.LibrosResponse;
import com.example.demo.response.ResponseDTO;
import com.example.demo.response.VideosResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class LibrosService {

    @Autowired
    LibrosRepository librosRepository;

    //GET
    public ArrayList<Libros> get(){
        return (ArrayList<Libros>) librosRepository.findAll();
    }

    //GETbyID
    public Optional<Libros> getId(Integer id){
        return librosRepository.findById(id);
    }

    //POST
    public ResponseEntity<ResponseDTO> create(RequestDTO requestDTO) {
        //Guardamos el objeto consola
        Libros libros = librosRepository.save(requestDTO.getRequest().getLibros());

        //Llenar una respuesta
        LibrosResponse datos = new LibrosResponse();
        datos.setAuthor(libros.getAuthor());
        datos.setTitle(libros.getTitle());
        datos.setType   (libros.getType());

        //Dar la respuesta
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponse("Libro agregada correctamente");
        responseDTO.setLibros(datos);

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //PUT
    public ResponseEntity<ResponseDTO> update(RequestDTO requestDTO) {
        librosRepository.updateAuthor(requestDTO.getRequest().getLibros().getAuthor(),
                requestDTO.getRequest().getLibros().getId());

        librosRepository.updateTitle(requestDTO.getRequest().getLibros().getTitle(),
                requestDTO.getRequest().getLibros().getId());

        librosRepository.updateType(requestDTO.getRequest().getLibros().getType(),
                requestDTO.getRequest().getLibros().getId());

        //Llenar una respuesta
        LibrosResponse datos = new LibrosResponse();
        datos.setAuthor(requestDTO.getRequest().getLibros().getAuthor());
        datos.setTitle(requestDTO.getRequest().getLibros().getTitle());
        datos.setType(requestDTO.getRequest().getLibros().getType());


        //Dar la respuesta
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponse("Libro actualizado correctamente");
        responseDTO.setLibros(datos);

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //DELETE
    public ResponseEntity<ResponseDTO> delete(RequestDTO requestDTO) {
        Integer id_book = requestDTO.getRequest().getLibros().getId();
        LibrosResponse datos = new LibrosResponse();
        datos.setId(id_book);
        ResponseDTO responseDTO = new ResponseDTO();
        if (librosRepository.existsById(id_book)) {
            librosRepository.deleteById(id_book);

            //Dar la respuesta
            responseDTO.setResponse("Libro eliminado correctamente");
            responseDTO.setLibros(datos);
        } else {

            //Dar la respuesta
            responseDTO.setResponse("El Libro con el id: " + id_book + " no se encuentra :c");
            responseDTO.setLibros(datos);
        }

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
