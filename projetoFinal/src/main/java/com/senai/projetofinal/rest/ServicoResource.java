/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.projetofinal.rest;

import com.senai.projetofinal.dao.ServicoDAO;
import com.senai.projetofinal.model.Servico;
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
 * @author Lisandro
 */

@Stateless
@Path("servicos")
@Produces(MediaType.APPLICATION_JSON)
public class ServicoResource {
    @Inject
    private ServicoDAO servicoDAO;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    
    public Servico insert (Servico servico){
        servicoDAO.inserir(servico);
        return servico;
    }
    
    @GET
    public List<Servico> list(){
        return servicoDAO.listar();
    }
    
    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") Long id){
        servicoDAO.excluir(id);
    }
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Servico update(@PathParam("{d") Long id, Servico servico){
        if (!Objects.equals(id, servico.getId())) {
            throw new WebApplicationException
                            (Response.Status.BAD_REQUEST);
        }
        
        return servicoDAO.atualizar(servico);
    }
    
    @GET
    @Path("{id}")
    public Response find(@PathParam("id") Long id){
        final Servico servico = servicoDAO.buscar(id);
        if (servico == null) {
            throw new EntityNotFoundException();
        }
        return Response.ok(servico).build();
    }
    
}
