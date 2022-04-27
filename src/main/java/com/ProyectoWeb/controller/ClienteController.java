package com.ProyectoWeb.controller;

import com.ProyectoWeb.domain.Cliente;
import com.ProyectoWeb.service.ClienteService;
import com.ProyectoWeb.service.FacturaService;
import com.ProyectoWeb.service.NotificacionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class ClienteController {

    @Autowired

    private ClienteService clienteService;
    @Autowired

    private NotificacionService notificacionService;
    @Autowired

    private FacturaService facturaService;

    @GetMapping("/cliente/listado")
    public String inicio(Model model) {
        var clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        var notificaciones = notificacionService.getNotificaciones();

        model.addAttribute("totalNotificaciones", notificaciones.size());
        var facturas = facturaService.getFacturas();

        model.addAttribute("totalFacturas", facturas.size());
        return "/cliente/listado";
    }

    @GetMapping("/cliente/login")
    public String nuevoCliente(Cliente cliente) {
        return "/cliente/login";
    }

    @PostMapping("/cliente/guardar")
    public String guardarCliente(Cliente cliente) {
        clienteService.save(cliente);
        return "redirect:/cliente/listado";
    }

    @PostMapping("/cliente/save")
    public String saveCliente(Cliente cliente) {
        clienteService.save(cliente);
        return "/empleado/menuEmpleado";
    }

    @GetMapping("/cliente/modificar/{idCliente}")
    public String modificarCliente(Cliente cliente, Model model) {
        var respuesta = clienteService.getCliente(cliente);
        model.addAttribute("cliente", respuesta);
        var notificaciones = notificacionService.getNotificaciones();
        model.addAttribute("totalNotificaciones", notificaciones.size());
         var facturas = facturaService.getFacturas();

        model.addAttribute("totalFacturas", facturas.size());
        return "/cliente/modifica";
    }

    @GetMapping("/cliente/eliminar/{idCliente}")
    public String eliminarCliente(Cliente cliente) {
        clienteService.delete(cliente);
        return "redirect:/cliente/listado";
    }

    @PostMapping("/cliente/buscar/{cedula}")
    public String buscarCliente(Cliente cliente, Model model) {
        var resultado = clienteService.findByCedula(cliente.getCedula());
        model.addAttribute("cliente", cliente);
        return "/cliente/menuCliente";
    }
}
