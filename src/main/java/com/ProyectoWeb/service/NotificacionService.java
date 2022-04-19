
package com.ProyectoWeb.service;


import com.ProyectoWeb.domain.Notificacion;
import java.util.List;

public interface NotificacionService {
    public List<Notificacion> getNotificaciones();
    
    public void save(Notificacion notificacion);
    
    public void delete(Notificacion notificacion);
    
    public Notificacion getNotificacion (Notificacion notificacion);
    
    
}