package com.ProyectoWeb.controller;

import com.ProyectoWeb.service.FacturaService;
import com.ProyectoWeb.service.NotificacionService;
import com.ProyectoWeb.service.PeliculaService;
import com.ProyectoWeb.service.UbicacionService;
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
    private UbicacionService ubicacionService;

    @Autowired
    private NotificacionService notificacionService;
    @Autowired

    private FacturaService facturaService;

    @GetMapping("/")
    public String inicio(Model model) {
        var ubicacion = ubicacionService.getUbicacion();
        model.addAttribute("ubicacion", ubicacion);

        var peliculas = peliculaService.getPeliculas();
        model.addAttribute("peliculas", peliculas);
        var notificaciones = notificacionService.getNotificaciones();

        model.addAttribute("totalNotificaciones", notificaciones.size());
        var facturas = facturaService.getFacturas();

        model.addAttribute("totalFacturas", facturas.size());
        return "Index";
    }
}
