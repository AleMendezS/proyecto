
package com.ProyectoWeb.controller;


import com.ProyectoWeb.domain.Empleado;
import com.ProyectoWeb.service.EmpleadoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class EmpleadoController {

    @Autowired
  
    private EmpleadoService empleadoService;

    @GetMapping("/empleado/listado")
    public String inicio(Model model) {
        var empleados = empleadoService.getEmpleados();
        model.addAttribute("empleados", empleados);
        return "/empleado/listado";
    }

    
    @GetMapping("/empleado/login")
    public String  nuevoEmpleado (Empleado empleado){
        return "/empleado/login";
    }
    
    @PostMapping("/empleado/guardar")
    public String guardarEmpleado (Empleado empleado){
        empleadoService.save(empleado);
        return "redirect:/empleado/listado";
    }
    
    @GetMapping("/empleado/modificar/{idEmpleado}")
    public String modificarEmpleado (Empleado empleado, Model model){
        var respuesta = empleadoService.getEmpleado(empleado);
        model.addAttribute("empleado",respuesta);
        return "/empleado/modifica";
    }
    
    @GetMapping ("/empleado/eliminar/{idEmpleado}")
    public String eliminarEmpleado (Empleado empleado){
        empleadoService.delete(empleado);
        return "redirect:/empleado/listado";
    }
    
    
}
