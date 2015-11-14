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
import javax.persistence.NoResultException;
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
    
    
    
    public Usuario login(String username, String password) throws LoginInvalidoException {
        try {
            String jpql = "SELECT u FROM Usuario u "
                    + "WHERE u.login = :login AND u.senha = :senha";
            TypedQuery<Usuario> q = em.createQuery(jpql, Usuario.class);
            q.setParameter("login", username);
            q.setParameter("senha", password);
            return q.getSingleResult();
        } catch (NoResultException ex) {
            throw new LoginInvalidoException();
        }
    }

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
        TypedQuery<Usuario> q = em.createQuery("SELECT u FROM Usuario u ", Usuario.class);
        return q.getResultList();
    }

}
