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
@Table(name = "factura")
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idFact;
    private String nombre;
    private String genero;
    private String apto;
    private String hora;
    private String idioma;
    private int precio;

    public Factura() {
    }

    public Factura(String nombre, String genero, String apto, String hora, String idioma, int precio) {
        this.nombre = nombre;
        this.genero = genero;
        this.apto = apto;
        this.hora = hora;
        this.idioma = idioma;
        this.precio = precio;
    }

    
}
