/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Tienda_IIQM.service;

import com.Tienda_IIQM.domain.Categoria;
import java.util.List;

/**
 *
 * @author Andres.M
 */
public interface CategoriaService {
    
    //Metodo que retorna la lista de categorias
    public List<Categoria> getCategorias(boolean activos);
      
}
