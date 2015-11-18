/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.projetofinal.rest;

import com.senai.projetofinal.dao.ClienteDAO;
import com.senai.projetofinal.dao.EnderecoDAO;
import com.senai.projetofinal.dao.UsuarioDAO;
import com.senai.projetofinal.model.CadastroCliente;
import com.senai.projetofinal.model.Cliente;
import com.senai.projetofinal.model.Endereco;
import com.senai.projetofinal.model.Usuario;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityNotFoundException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author eduardo
 */
@Stateless
@Path("clientes")
@Produces(MediaType.APPLICATION_JSON)
public class ClienteResource {
    
    @Inject
    private ClienteDAO clienteDAO;
    
     @Inject
    private EnderecoDAO enderecoDAO;
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void insert(CadastroCliente cadastro){   
        enderecoDAO.inserir(cadastro.getEndereco());
        clienteDAO.inserir(cadastro.getCliente());
    }
    
    @GET
    public List<Cliente> list() {
        return clienteDAO.listar();
    }
    
    
    @GET
    @Path("{id}")
    public Response buscar(@PathParam("id") Long id) {
        final Cliente cliente = clienteDAO.buscar(id);
        if (cliente == null) {
            throw new EntityNotFoundException();
        }
        return Response.ok(cliente).build();
    }
    
    /*@POST
    @Path(value= "/autenticar")
    @Consumes(value = "application/json")
    public Usuario autenticar(Usuario usuario) throws LoginInvalidoException {
        usuario = dao.login(usuario.getLogin(), usuario.getSenha());
        boolean usuarioValido = usuario != null;

        if (usuarioValido) {
            
          return usuario;  
          
        } 
        return null;
          
    }*/
    
}
