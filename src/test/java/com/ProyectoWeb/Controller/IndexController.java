package com.ProyectoWeb.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Slf4j
public class IndexController {

    @Autowired
    @GetMapping("/")
    public String inicio(Model model) {
        log.info("Listo");
        return "Index";
    }
    
     @GetMapping("/login")
    public String login(Model model) {
       
        return "RegistrarCliente";
    }
}
