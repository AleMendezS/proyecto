
package com.ProyectoWeb.service;


import com.ProyectoWeb.domain.Ubicacion;
import java.util.List;

public interface UbicacionService {
     public List<Ubicacion> getUbicacion();
    
    public void save(Ubicacion ubicacion);
    
    public void delete(Ubicacion ubicacion);
    
    public Ubicacion getUbicacion (Ubicacion ubicacion);
}
