package com.example.demo.services;

import com.example.demo.models.Consola;
import com.example.demo.repositories.ConsolaRepository;
import com.example.demo.request.RequestDTO;
import com.example.demo.response.ConsolaResponse;
import com.example.demo.response.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class ConsolaService {
    @Autowired
    ConsolaRepository consolaRepository;

    //GET
    public ArrayList<Consola> obtenerTodasLasConsolas() {
        return (ArrayList<Consola>) consolaRepository.findAll();
    }

    //GET ID
    public Optional<Consola> obtenerIdConsola(Integer id) {
        if (consolaRepository.findById(id) != null) {
            return consolaRepository.findById(id);
        }
        return null;
    }

    //Guardar consola -- POST
    public ResponseEntity<ResponseDTO> guardarConsola(RequestDTO requestDTO) {
        //Guardamos el objeto consola
        Consola consola = consolaRepository.save(requestDTO.getRequest().getConsola());

        //Llenar una respuesta
        ConsolaResponse consolaResponse = new ConsolaResponse();
        consolaResponse.setNombre(consola.getNombre());
        consolaResponse.setLanzamiento(consola.getLanzamiento());

        //Dar la respuesta
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponse("Consola agregada correctamente");
        responseDTO.setConsola(consolaResponse);

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //Actualizar consola -- PUT
    public ResponseEntity<ResponseDTO> actualizarConsola(RequestDTO requestDTO) {
        consolaRepository.updateNombre(requestDTO.getRequest().getConsola().getNombre(),
                requestDTO.getRequest().getConsola().getId());

        consolaRepository.updateLanzamiento(requestDTO.getRequest().getConsola().getLanzamiento(),
                requestDTO.getRequest().getConsola().getId());

        //Llenar una respuesta
        ConsolaResponse consolaResponse = new ConsolaResponse();
        consolaResponse.setNombre(requestDTO.getRequest().getConsola().getNombre());
        consolaResponse.setLanzamiento(requestDTO.getRequest().getConsola().getLanzamiento());

        //Dar la respuesta
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponse("Consola actualizada correctamente");
        responseDTO.setConsola(consolaResponse);

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //Eliminar consola -- DELETE
    public ResponseEntity<ResponseDTO> eliminarConsola(RequestDTO requestDTO) {
        Integer id_consola = requestDTO.getRequest().getConsola().getId();
        ConsolaResponse consolaResponse = new ConsolaResponse();
        consolaResponse.setId(id_consola);
        ResponseDTO responseDTO = new ResponseDTO();
        if (consolaRepository.existsById(id_consola)) {
            consolaRepository.deleteById(id_consola);

            //Dar la respuesta
            responseDTO.setResponse("Consola eliminada correctamente");
            responseDTO.setConsola(consolaResponse);
        } else {

            //Dar la respuesta
            responseDTO.setResponse("La consola con el id: " + id_consola + " no existe");
            responseDTO.setConsola(consolaResponse);
        }

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
