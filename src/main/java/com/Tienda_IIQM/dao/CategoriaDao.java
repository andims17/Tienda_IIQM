/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Tienda_IIQM.dao;

import com.Tienda_IIQM.domain.Categoria;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Andres.M
 */
public interface CategoriaDao extends JpaRepository<Categoria, Long> {
    // Mas adelante, vamos a tener metodos ampliados
    List<Categoria> findByDescripcion(String descripcion);
    
    
}
