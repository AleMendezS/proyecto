
package com.ProyectoWeb.dao;


import com.ProyectoWeb.domain.Empleado;
import org.springframework.data.repository.CrudRepository;

public interface EmpleadoDao extends CrudRepository<Empleado, Long>{
    
}
