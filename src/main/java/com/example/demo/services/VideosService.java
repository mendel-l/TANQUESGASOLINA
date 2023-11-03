package com.example.demo.services;
import com.example.demo.models.Videos;
import com.example.demo.repositories.VideosRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class VideosService {

    @Autowired
    VideosRepository videosRepository;

    //GET
    public ArrayList<Videos> get(){
        return (ArrayList<Videos>) videosRepository.findAll();
    }

    //GETbyID
    public Optional<Videos> getId(Integer id){
        return videosRepository.findById(id);
    }

    //POST

    public Videos create(Videos video) {
        return videosRepository.save(video);
    }

/*
    public ResponseEntity<ResponseDTO> create(RequestDTO requestDTO) {
        //Guardamos el objeto consola
        Videos videos = videosRepository.save(requestDTO.getRequest().getVideos());

        //Llenar una respuesta
        VideosResponse datos = new VideosResponse();
        datos.setTitulo(videos.getTitulo());
        datos.setVisitas(videos.getVisitas());
        datos.setDescripcion(videos.getDescripcion());

        //Dar la respuesta
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponse("Video agregada correctamente");
        responseDTO.setVideos(datos);

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

     */

    //PUT

    public Videos update(Integer id, Videos update) {
        Optional<Videos> Exist = videosRepository.findById(id);

        if (Exist.isPresent()) {
            Videos datos = Exist.get();

            datos.setTitulo(update.getTitulo());
            datos.setVisitas(update.getVisitas());
            datos.setDescripcion(update.getDescripcion());
            return videosRepository.save(datos);
        } else {
            throw new EntityNotFoundException("Juego no encontrada con ID: " + id);
        }
    }

/*
    public ResponseEntity<ResponseDTO> update(RequestDTO requestDTO) {
        videosRepository.updateTitulo(requestDTO.getRequest().getVideos().getTitulo(),
                requestDTO.getRequest().getVideos().getId());

        videosRepository.updateVisitas(requestDTO.getRequest().getVideos().getVisitas(),
                requestDTO.getRequest().getVideos().getId());

        videosRepository.updateDescripcion(requestDTO.getRequest().getVideos().getDescripcion(),
                requestDTO.getRequest().getVideos().getId());

        //Llenar una respuesta
        VideosResponse datos = new VideosResponse();
        datos.setTitulo(requestDTO.getRequest().getVideos().getTitulo());
        datos.setVisitas(requestDTO.getRequest().getVideos().getVisitas());
        datos.setDescripcion(requestDTO.getRequest().getVideos().getDescripcion());


        //Dar la respuesta
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponse("Video actualizado correctamente");
        responseDTO.setVideos(datos);

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
    */

    //DELETE

    public void delete(Integer id) {
        Optional<Videos>Exist = videosRepository.findById(id);

        if (Exist.isPresent()) {
            videosRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Error 404 no encontrada con ID: " + id);
        }
    }


    /*
    public ResponseEntity<ResponseDTO> delete(RequestDTO requestDTO) {
        Integer id_vid = requestDTO.getRequest().getVideos().getId();
        VideosResponse datos = new VideosResponse();
        datos.setId(id_vid);
        ResponseDTO responseDTO = new ResponseDTO();
        if (videosRepository.existsById(id_vid)) {
            videosRepository.deleteById(id_vid);

            //Dar la respuesta
            responseDTO.setResponse("Video eliminado correctamente");
            responseDTO.setVideos(datos);
        } else {

            //Dar la respuesta
            responseDTO.setResponse("El video con el id: " + id_vid + " ya fue tumbado");
            responseDTO.setVideos(datos);
        }

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

     */
}
