package com.ProyectoWeb.dao;

import com.ProyectoWeb.domain.Pelicula;
import org.springframework.data.repository.CrudRepository;


public interface PeliculaDao extends CrudRepository<Pelicula, Long>{
    
}
