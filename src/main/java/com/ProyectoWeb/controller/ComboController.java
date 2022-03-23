/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.ProyectoWeb.controller;

import com.ProyectoWeb.domain.Combo;
import com.ProyectoWeb.service.ComboService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@Slf4j
public class ComboController {
    
    @Autowired
    private ComboService comboService;
    @GetMapping("/combo/listado")
    public String page(Model model) {
        
        var combos = comboService.getCombos();
        model.addAttribute("combos", combos);
        
        return "/combo/listado";
    }
    
    @GetMapping("/combo/modifica")
    public String  nuevoCombo (Combo combo){
        return "/combo/modifica";
    }
    
    @GetMapping("/combo/modificar/{idCombo}")
    public String modificarCombo (Combo combo, Model model){
        var respuesta = comboService.getCombo(combo);
        model.addAttribute("combo",respuesta);
        return "/combo/modifica";
    
}
    @PostMapping("/combo/guardar")
    public String guardarCombo (Combo combo){
        comboService.save(combo);
        return "redirect:/combo/listado";
}
    
    @GetMapping ("/combo/eliminar/{idCombo}")
    public String eliminarCombo (Combo combo){
        comboService.delete(combo);
        return "redirect:/combo/listado";
    }
}