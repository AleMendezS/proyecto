package com.ProyectoWeb.controller;


import com.ProyectoWeb.service.NotificacionService;
import com.ProyectoWeb.service.PeliculaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class IndexController {

    @Autowired
 private PeliculaService peliculaService;
   @Autowired

    private NotificacionService notificacionService;

    
    
    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Ahora se usa arquitectura MVC");

        var peliculas = peliculaService.getPeliculas();
        model.addAttribute("peliculas", peliculas);
       var notificaciones = notificacionService.getNotificaciones();
       
        model.addAttribute("totalNotificaciones", notificaciones.size());
       
        return "Index";
    }
}