/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Tienda_IIQM.service.impl;

import com.Tienda_IIQM.dao.UsuarioDao;
import com.Tienda_IIQM.domain.Rol;
import com.Tienda_IIQM.domain.Usuario;
import com.Tienda_IIQM.service.UsuarioDetailsService;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Andres.M
 */
@Service("userDetailsService")
public class UsuarioDetailsServiceImpl implements UsuarioDetailsService , UserDetailsService{

    @Autowired
    private UsuarioDao usuarioDao;
    
    @Autowired
    private HttpSession session;
    
    
    @Override
    @Transactional(readOnly = true)
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // Buscar en BD el usuario
        Usuario usuario = usuarioDao.findByUsername(username);
        if(usuario==null){
            throw new UsernameNotFoundException("El usuario " + username + " no existe");
        }
        
        //variables de sesion
        session.removeAttribute("usuarioImagen");
        session.setAttribute("usuarioImagen" , usuario.getRutaImagen());
        
        //extraer los roles
        var roles = new ArrayList<GrantedAuthority>();
        for(Rol rol : usuario.getRoles()){
            roles.add(new SimpleGrantedAuthority(rol.getNombre()));
        }
        
        
        return new User(usuario.getUsername(), usuario.getPassword(), roles);
    }
    
}
