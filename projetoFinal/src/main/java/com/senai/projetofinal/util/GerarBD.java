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


import javax.ejb.Stateless;
import javax.inject.Inject;


/**
 *
 * @author duda
 */
@Stateless
public class GerarBD {

    /**
     * @param args the command line arguments
     */
   // @Inject
   // private ClienteDAO clienteDAO;
   // @Inject
    //private static EnderecoDAO enderecoDAO;

    public static void main(String[] args) {
        /*( entity = Persistence.createEntityManagerFactory("projetofinalPU");	
        
         if(entity == null){
         entity = (EntityManagerFactory) entity.createEntityManager();
         }*/

       /* String d = "12-12-2015";
        Date date = null;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        try {
            date = sdf.parse(d);
        } catch (ParseException ex) {
            Logger.getLogger(GerarBD.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        
        Endereco e = new Endereco();
        e.setBairro("Centro");
        e.setCep("88940000");
        e.setCidade("Timbé do Sul");
        e.setComplemento("casa");
        e.setEstado("Santa Catarina");
        e.setNumero(222);
        e.setPais("Brasil");
        e.setRua("Angelo Rovaris");
        e.setUsuario(null);
        
        
        //enderecoDAO.inserir(e);

        Cliente c = new Cliente();
        c.setCelular("91639305");
        c.setCpf("06652198908");
        c.setDtCadastro(null);
        c.setDtNascimento(null);
        c.setEmail("duda@gmail.com");
        c.setEndereco(e);
        c.setNome("Eduardo Coelho");
        c.setSexo("m");
        c.setTelefone("35361154");
        c.setUsuario(null);
        
       // ClienteResource cr = new ClienteResource();
       // cr.insertE(e);
        
        
    }

}
