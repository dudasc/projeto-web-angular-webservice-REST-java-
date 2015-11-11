/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.projetofinal.dao;

import com.senai.projetofinal.model.Cliente;
import com.senai.projetofinal.model.Usuario;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author lisandro_bitencourt
 */
@Stateless
public class ClienteDAO {

    @PersistenceContext(unitName = "projetofinalPU")
    private EntityManager em;

    public void insere(Cliente cliente) {
        em.persist(cliente);
    }
}
