package com.ProyectoWeb.controller;

import com.ProyectoWeb.domain.Factura;
import com.ProyectoWeb.domain.Pelicula;
import com.ProyectoWeb.service.FacturaService;
import com.ProyectoWeb.service.NotificacionService;
import com.ProyectoWeb.service.PeliculaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class FacturaController {

    @Autowired

    private FacturaService facturaService;
    @Autowired

    private PeliculaService peliculaService;
    @Autowired

    private NotificacionService notificacionService;

    @GetMapping("/factura/listado")
    public String inicio(Model model) {
        var facturas = facturaService.getFacturas();
        model.addAttribute("facturas", facturas);
        model.addAttribute("totalFacturas", facturas.size());
        var notificaciones = notificacionService.getNotificaciones();
        model.addAttribute("totalNotificaciones", notificaciones.size());

        return "/factura/listado";
    }

    @PostMapping("/factura/guardar")
    public String guardarFactura(Factura factura) {
        facturaService.save(factura);
        return "redirect:/";
    }

    @GetMapping("/factura/modificar/{idPelicula}")
    public String comprarPelicula(Pelicula pelicula, Model model) {
        var respuesta = peliculaService.getPelicula(pelicula);
        model.addAttribute("factura", respuesta);
        return "factura/modifica";
    }

    @GetMapping("/factura/eliminar/{idFact}")
    public String eliminarFactura(Factura factura) {
        facturaService.delete(factura);
        return "redirect:/factura/listado";
    }

}
