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
    private String nombre;
    private String genero;
    private String idioma;
    private String apto;
     private String imagen;
    private String hora;
    private int precio;

    public Pelicula() {
    }

    public Pelicula(String nombre, String genero, String idioma, String apto, String imagen, String hora, int precio) {
        this.nombre = nombre;
        this.genero = genero;
        this.idioma = idioma;
        this.apto = apto;
        this.imagen = imagen;
        this.hora = hora;
        this.precio = precio;
    }

    
    
}