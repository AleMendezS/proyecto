
package com.ProyectoWeb.dao;


import com.ProyectoWeb.domain.Cliente;
import org.springframework.data.repository.CrudRepository;


public interface ClienteDao  extends CrudRepository<Cliente, Long>{
   
}
