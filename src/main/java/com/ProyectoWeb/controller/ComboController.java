/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.ProyectoWeb.controller;

import com.ProyectoWeb.service.ComboService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


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
    
}
