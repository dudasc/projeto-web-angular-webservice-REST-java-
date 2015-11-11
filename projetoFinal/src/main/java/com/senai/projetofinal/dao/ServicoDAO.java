/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.projetofinal.dao;

import com.senai.projetofinal.model.Endereco;
import com.senai.projetofinal.model.Servico;
import com.senai.projetofinal.model.Usuario;
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
public class ServicoDAO {
@PersistenceContext(unitName = "projetofinalPU")
    private EntityManager em;

    public void inserir(Servico servico) {
        em.persist(servico);
    }    
    
    public void excluir(Long id) {
        em.remove(em.getReference(Servico.class, id));
    }

    public Servico buscar(Long id) {
        return em.find(Servico.class, id);
    }

    public void atualizar(Servico servico) {
        em.merge(servico);
    }

    public List<Servico> listar() {
        TypedQuery<Servico> q = em.createQuery("SELECT s FROM Servico s ORDER BY nome ", Servico.class);
        return q.getResultList();
    }
    
}
