/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda_IIQM.service.impl;

import com.Tienda_IIQM.dao.CategoriaDao;
import com.Tienda_IIQM.domain.Categoria;
import com.Tienda_IIQM.service.CategoriaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Andres.M
 */

@Service
public class CategoriaServiceImpl implements CategoriaService{

    @Autowired
    private CategoriaDao categoriaDao;
    
    
    @Override
    @Transactional(readOnly=true)
    public List<Categoria> getCategorias(boolean activos) {
         List<Categoria> lista = categoriaDao.findAll();
         if(activos){
             //Para remover las categorias donde activo = false
             lista.removeIf(x -> !x.isActivo());
         }
         return lista;
    }
    
}
