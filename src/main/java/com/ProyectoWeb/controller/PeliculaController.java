package com.ProyectoWeb.controller;

import com.ProyectoWeb.domain.Pelicula;
import com.ProyectoWeb.service.FacturaService;
import com.ProyectoWeb.service.NotificacionService;
import com.ProyectoWeb.service.PeliculaService;
import com.ProyectoWeb.service.UbicacionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class PeliculaController {
     @Autowired
    private UbicacionService ubicacionService;

    @Autowired
  
    private PeliculaService peliculaService;
   @Autowired

    private NotificacionService notificacionService;
    @Autowired

    private FacturaService facturaService;
    @GetMapping("/pelicula/listado")
    public String inicio(Model model) {
        var ubicacion = ubicacionService.getUbicacion();
        model.addAttribute("ubicacion", ubicacion);
        
        var peliculas = peliculaService.getPeliculas();
        model.addAttribute("peliculas", peliculas);
        var notificaciones = notificacionService.getNotificaciones();
       
        model.addAttribute("totalNotificaciones", notificaciones.size());
         var facturas = facturaService.getFacturas();

        model.addAttribute("totalFacturas", facturas.size());
        return "/pelicula/listado";
    }

    
    @GetMapping("/pelicula/modifica")
    public String  nuevoPelicula (Pelicula pelicula){
    
        return "/pelicula/modifica";
    }
    
    @PostMapping("/pelicula/guardar")
    public String guardarPelicula (Pelicula pelicula){
        peliculaService.save(pelicula);
       return "redirect:/pelicula/listado";
    }
    
    @GetMapping("/pelicula/modificar/{idPelicula}")
    public String modificarPelicula (Pelicula pelicula, Model model){
        var respuesta = peliculaService.getPelicula(pelicula);
        model.addAttribute("pelicula",respuesta);
         var facturas = facturaService.getFacturas();

        model.addAttribute("totalFacturas", facturas.size());
        var notificaciones = notificacionService.getNotificaciones();

        model.addAttribute("totalNotificaciones", notificaciones.size());
        return "/pelicula/modifica";
    }
    
    @GetMapping ("/pelicula/eliminar/{idPelicula}")
    public String eliminarPelicula (Pelicula pelicula){
        peliculaService.delete(pelicula);
        return "redirect:/pelicula/listado";
    }
    
    
}