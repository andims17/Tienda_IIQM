/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.Tienda_IIQM.controler;

import com.Tienda_IIQM.service.ProductoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Andres.M
 */
@Controller
public class IndexController {
    
    @Autowired
    ProductoService productoService;
    
    @RequestMapping("/")
    public String page(Model model , HttpSession session) {        
        var productos = productoService.getProductos(true);
        model.addAttribute("productos",productos); 
        return "index";
    }
    
}
