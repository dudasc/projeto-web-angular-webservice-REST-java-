/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.projetofinal.rest;

import com.senai.projetofinal.dao.UsuarioDAO;
import com.senai.projetofinal.model.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author eduardo
 */
@Stateless
@Path("usuarios")
@Produces(MediaType.APPLICATION_JSON)
public class UsuarioResource {
    
    @Inject
    private UsuarioDAO dao;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(Usuario u) {
        dao.inserir(u);        
    }
    @GET
    public List<Usuario> list() {
        return dao.listar();
    }
    
}
