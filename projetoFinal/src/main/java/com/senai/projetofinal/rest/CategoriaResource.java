/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.projetofinal.rest;

import com.senai.projetofinal.dao.CategoriaDAO;
import com.senai.projetofinal.model.Categoria;
import java.util.List;
import java.util.Objects;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author LF
 */
@Stateless
@Path("categorias")
@Produces(MediaType.APPLICATION_JSON)

public class CategoriaResource {

        @Inject
    private CategoriaDAO categoriaDAO;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    
    public Categoria insert (Categoria categoria){
        categoriaDAO.inserir(categoria);
        return categoria;
    }
    
    @GET
    public List<Categoria> list(){
        return categoriaDAO.listar();
    }
    
    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") Long id){
        categoriaDAO.excluir(id);
    }
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Categoria update(@PathParam("{d") Long id, Categoria categoria){
        if (!Objects.equals(id, categoria.getId())) {
            throw new WebApplicationException
                            (Response.Status.BAD_REQUEST);
        }
        
        return categoriaDAO.atualizar(categoria);
    }
    
    @GET
    @Path("{id}")
    public Response find(@PathParam("id") Long id){
        final Categoria categoria = categoriaDAO.buscar(id);
        if (categoria == null) {
            throw new EntityNotFoundException();
        }
        return Response.ok(categoria).build();
    }    

}
