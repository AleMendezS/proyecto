package com.ProyectoWeb.controller;

import com.ProyectoWeb.domain.Notificacion;
import com.ProyectoWeb.service.FacturaService;
import com.ProyectoWeb.service.NotificacionService;
import com.ProyectoWeb.service.UbicacionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class NotificacionController {

    @Autowired

    private NotificacionService notificacionService;
    @Autowired

    private FacturaService facturaService;

    @Autowired
    private UbicacionService ubicacionService;
    @GetMapping("/notificacion/listado")
    public String inicio(Model model) {
        var notificaciones = notificacionService.getNotificaciones();
        model.addAttribute("notificaciones", notificaciones);
        model.addAttribute("totalNotificaciones", notificaciones.size());
        var facturas = facturaService.getFacturas();

        model.addAttribute("totalFacturas", facturas.size());
        var ubicacion = ubicacionService.getUbicacion();
        model.addAttribute("ubicacion", ubicacion);
        return "/notificacion/listado";
    }

    @PostMapping("/notificacion/guardar")
    public String guardarNotificacion(Notificacion notificacion) {
        notificacionService.save(notificacion);
        return "redirect:/";
    }

    @GetMapping("/notificacion/eliminar/{idNoti}")
    public String eliminarNotificacion(Notificacion notificacion) {
        notificacionService.delete(notificacion);
        return "redirect:/notificacion/listado";
    }

}
