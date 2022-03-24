
package com.ProyectoWeb.controller;


import com.ProyectoWeb.domain.Cliente;
import com.ProyectoWeb.service.ClienteService;
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

    @GetMapping("/cliente/listado")
    public String inicio(Model model) {
        var clientes = clienteService.getClientes();
        model.addAttribute("clientes", clientes);
        return "/cliente/listado";
    }

    
    @GetMapping("/cliente/login")
    public String  nuevoCliente (Cliente cliente){
        return "/cliente/login";
    }
    
    @PostMapping("/cliente/guardar")
    public String guardarCliente (Cliente cliente){
        clienteService.save(cliente);
        return "/cliente/menuCliente";
    }
    @PostMapping("/cliente/save")
    public String saveCliente (Cliente cliente){
        clienteService.save(cliente);
        return "/empleado/menuEmpleado";
    }
    @GetMapping("/cliente/modificar/{idCliente}")
    public String modificarCliente (Cliente cliente, Model model){
        var respuesta = clienteService.getCliente(cliente);
        model.addAttribute("cliente",respuesta);
        return "/cliente/loginModifica";
    }
    
    @GetMapping ("/cliente/eliminar/{idCliente}")
    public String eliminarCliente (Cliente cliente){
        clienteService.delete(cliente);
        return "redirect:/cliente/listado";
    }
    
    
}

