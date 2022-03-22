package com.ProyectoWeb.service;

import com.ProyectoWeb.domain.Pelicula;
import java.util.List;

public interface PeliculaService {
     public List<Pelicula> getPeliculas();
    
    public void save(Pelicula pelicula);
    
    public void delete(Pelicula pelicula);
    
    public Pelicula getPelicula (Pelicula pelicula);
}
