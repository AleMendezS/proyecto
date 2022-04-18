
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
@Table(name = "ubicacion")
public class Ubicacion implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUbi;
    private String ubicacion;
   

    public Ubicacion() {
    }

    public Ubicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }
    
    
}