package com.ProyectoWeb.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "pelicula")
public class Pelicula implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPelicula;
    private String pelicula;
    private String genero;
    private String idioma;
    private int apto;
    

    public Pelicula() {
    }

    public Pelicula(String pelicula, String genero, String idioma, int apto) {
        this.pelicula = pelicula;
        this.genero = genero;
        this.idioma = idioma;
        this.apto = apto;
    }

}