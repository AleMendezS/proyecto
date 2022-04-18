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
@Table(name = "combo")
public class Combo implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCombo;
    private String titulo;
    private String descripcion;
    private String precio;

    public Combo() {
    }

    public Combo(String titulo,String descripcion, String precio) {

        this.titulo =titulo;
        this.descripcion = descripcion;
        this.precio = precio;

    }

}
