package com.example.demo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class ResponseDTO {
    @JsonProperty("response")
    private String response;
    @JsonProperty("role")
    private RoleResponse role;
    @JsonProperty("user")
    private UserResponse user;

    // PARA PROGRA WEB
    @JsonProperty("consola")
    private ConsolaResponse consola;
    @JsonProperty("videos")
    private VideosResponse videos;

    // PRE-PARCIAL PROGRA WEB
    @JsonProperty("libros")
    private LibrosResponse libros;


    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public RoleResponse getRole() {
        return role;
    }

    public void setRole(RoleResponse role) {
        this.role = role;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }


    // PARA PROGRA WEB
    public ConsolaResponse getConsola() {
        return consola;
    }
    public void setConsola(ConsolaResponse consola) {
        this.consola = consola;
    }

    public VideosResponse getVideos() {
        return videos;
    }
    public void setVideos(VideosResponse videos) {
        this.videos = videos;
    }

    // PRE-PARCIAL PROGRA WEB
    public LibrosResponse getLibros() {
        return libros;
    }
    public void setLibros(LibrosResponse libros) {
        this.libros = libros;
    }
}
