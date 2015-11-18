/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.projetofinal.util;

import com.senai.projetofinal.dao.ClienteDAO;
import com.senai.projetofinal.dao.EnderecoDAO;
import com.senai.projetofinal.model.Cliente;
import com.senai.projetofinal.model.Endereco;
import com.senai.projetofinal.rest.ClienteResource;
import javax.ejb.EJB;


import javax.ejb.Stateless;
import javax.inject.Inject;


/**
 *
 * @author duda
 */
@Stateless
public class GerarBD {
    @Inject
    private ClienteDAO clienteDAO;

    /**
     * @param args the command line arguments
     */
   // @Inject
   // private ClienteDAO clienteDAO;
   // @Inject
    //private static EnderecoDAO enderecoDAO;

    public static void main(String[] args) {
        
        
        
    }

}
