
package com.ProyectoWeb.controller;

import com.ProyectoWeb.domain.Ubicacion;
import com.ProyectoWeb.service.UbicacionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class UbicacionController {

    @Autowired
  
    private UbicacionService ubicacionService;

    @GetMapping("/ubicacion/listado")
    public String inicio(Model model) {
        var ubicacion = ubicacionService.getUbicacion();
        model.addAttribute("ubicacion", ubicacion);
        return "/ubicacion/listado";
    }
    @PostMapping("/ubicacion/guardar")
    public String guardarUbicacion (Ubicacion ubicacion){
        ubicacionService.save(ubicacion);
        return "/empleado/menuEmpleado";
    }
    
     @GetMapping("/ubicacion/modifica")
    public String  nuevaUbicacion(Ubicacion ubicacion){
        return "/ubicacion/modifica";
    }
    @GetMapping("/ubicacion/modificar/{idUbi}")
    public String modificarUbicacion (Ubicacion ubicacion, Model model){
        var respuesta = ubicacionService.getUbicacion(ubicacion);
        model.addAttribute("ubicacion",respuesta);
        return "/ubicacion/modifica";
    }
    
    @GetMapping ("/ubicacion/eliminar/{idUbi}")
    public String eliminarUbicacion (Ubicacion ubicacion){
        ubicacionService.delete(ubicacion);
        return "redirect:/ubicacion/listado";
    }
    
    
}
