
package com.ProyectoWeb.dao;


import com.ProyectoWeb.domain.Cliente;
import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface ClienteDao  extends CrudRepository<Cliente, Long>{
       public List<Cliente> findByCedula(int cedula);
}
