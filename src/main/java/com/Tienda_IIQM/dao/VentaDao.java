/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.Tienda_IIQM.dao;

import com.Tienda_IIQM.domain.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Andres.M
 */
public interface VentaDao extends JpaRepository<Venta, Long> {
    
}
