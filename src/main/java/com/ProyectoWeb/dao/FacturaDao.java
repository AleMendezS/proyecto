package com.ProyectoWeb.dao;

import com.ProyectoWeb.domain.Factura;
import org.springframework.data.repository.CrudRepository;

public interface FacturaDao extends CrudRepository<Factura, Long>{
    
}
