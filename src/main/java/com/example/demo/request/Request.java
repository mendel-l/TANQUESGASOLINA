package com.example.demo.request;

import com.example.demo.models.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Request {
    @JsonProperty("user") //Para que el objeto se vea mas bonito en JSON
    private User user;
    @JsonProperty("role")
    private Role role;
    @JsonProperty("consola")
    private Consola consola;
    @JsonProperty("videos")
    private Videos videos;
    @JsonProperty("libros")
    private Libros libros;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    //PARA PROGRA WEB
    public Consola getConsola() {
        return consola;
    }

    public void setConsola(Consola consola) {
        this.consola = consola;
    }

    public Videos getVideos() {
        return videos;
    }
    public void setVideos(Videos videos) {
        this.videos = videos;
    }

    public Libros getLibros() {
        return libros;
    }

    public void setLibros(Libros libros) {
        this.libros = libros;
    }
}
