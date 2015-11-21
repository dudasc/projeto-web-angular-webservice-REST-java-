/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.projetofinal.dao;

import com.senai.projetofinal.model.Categoria;
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
public class CategoriaDAO {

    @PersistenceContext(unitName = "projetofinalPU")
    private EntityManager em;

    public void inserir(Categoria categoria) {
        em.persist(categoria);
    }

    public void excluir(Long id) {
        em.remove(em.getReference(Categoria.class, id));
    }

    public Categoria buscar(Long id) {
        return em.find(Categoria.class, id);
    }

    public Categoria atualizar(Categoria categoria) {
       return em.merge(categoria);
    }

    public List<Categoria> listar() {
        TypedQuery<Categoria> q = em.createQuery("SELECT ct FROM Categoria ct ", Categoria.class);
        return q.getResultList();
    }

}
