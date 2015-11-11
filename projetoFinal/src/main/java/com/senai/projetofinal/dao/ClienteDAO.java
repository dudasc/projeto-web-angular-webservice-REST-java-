/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.projetofinal.dao;

import com.senai.projetofinal.model.Cliente;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author lisandro_bitencourt
 */
@Stateless
public class ClienteDAO {
@PersistenceContext(unitName = "projetofinalPU")
    private EntityManager em;

    public void inserir(Cliente cliente) {
        em.persist(cliente);
    }    
    
    public void excluir(Long id) {
        em.remove(em.getReference(Cliente.class, id));
    }

    public Cliente buscar(Long id) {
        return em.find(Cliente.class, id);
    }

    public void atualizar(Cliente cliente) {
        em.merge(cliente);
    }

    public List<Cliente> listar() {
        TypedQuery<Cliente> q = em.createQuery("SELECT c FROM Cliente c ORDER BY nome ", Cliente.class);
        return q.getResultList();
    }
    
}
