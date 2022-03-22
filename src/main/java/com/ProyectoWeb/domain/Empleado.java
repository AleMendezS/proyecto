
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
@Table(name = "empleado")
public class Empleado implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmpleado;
    private String nombre;
    private String apellidos;
    private int cedula;
    private int pasword;

    public Empleado() {
    }

    public Empleado(String nombre, String apellidos, int cedula, int pasword) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cedula = cedula;
        this.pasword = pasword;
    }

   
    
    
    
}
