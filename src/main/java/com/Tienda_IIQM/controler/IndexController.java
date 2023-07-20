/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/springframework/Controller.java to edit this template
 */
package com.Tienda_IIQM.controler;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Andres.M
 */
@Controller
public class IndexController {
    
    @RequestMapping("/")
    public String page(Model model , HttpSession session) {
        String imagen = (String)session.getAttribute("usuarioImagen");
        model.addAttribute("avatar",imagen);
        return "index";
    }
    
}
