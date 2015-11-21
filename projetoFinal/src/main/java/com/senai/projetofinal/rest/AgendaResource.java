/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.projetofinal.rest;

import com.senai.projetofinal.dao.AgendaDAO;
import com.senai.projetofinal.model.Agenda;
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
@Path("agendamentos")
@Produces(MediaType.APPLICATION_JSON)

public class AgendaResource {
    
    @Inject
    private AgendaDAO agendaDAO;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    
    public Agenda insert (Agenda agenda){
        agendaDAO.inserir(agenda);
        return agenda;
    }
    
    @GET
    public List<Agenda> list(){
        return agendaDAO.listar();
    }
    
    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("id") Long id){
        agendaDAO.excluir(id);
    }
    
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Agenda update(@PathParam("{d") Long id, Agenda agenda){
        if (!Objects.equals(id, agenda.getId())) {
            throw new WebApplicationException
                            (Response.Status.BAD_REQUEST);
        }
        
        return agendaDAO.atualizar(agenda);
    }
    
    @GET
    @Path("{id}")
    public Response find(@PathParam("id") Long id){
        final Agenda agenda = agendaDAO.buscar(id);
        if (agenda == null) {
            throw new EntityNotFoundException();
        }
        return Response.ok(agenda).build();
    }    
}
