/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.projetofinal.dao;

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
public class UsuarioDAO {

    @PersistenceContext(unitName = "projetofinalPU")
    private EntityManager em;

    public void inserir(Usuario usuario) {
        em.persist(usuario);
    }

    public void excluir(Long id) {
        em.remove(em.getReference(Usuario.class, id));
    }

    public Usuario buscar(Long id) {
        return em.find(Usuario.class, id);
    }

    public void atualizar(Usuario usuario) {
        em.merge(usuario);
    }

    public List<Usuario> listar() {
        TypedQuery<Usuario> q = em.createQuery("SELECT u FROM Usuario u ORDER BY nome ", Usuario.class);
        return q.getResultList();
    }

}
