/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.projetofinal.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lisandro_bitencourt
 */
@Entity
@Table(name = "categorias")
@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")    
    private Long id;
    @Column(name = "nome", unique = true, nullable = true, length = 100)
    private String nome;
    @ManyToOne(fetch = FetchType.EAGER)
    private Usuario usuario;
    
   
    
    	@OneToMany(fetch=FetchType.EAGER, mappedBy="categoria", cascade={CascadeType.PERSIST, CascadeType.REMOVE})	
    
    private List<Servico> listServicos = new ArrayList<>();

    public Categoria() {
    }

    public Categoria(Long id, String nome, Usuario usuario) {
        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
    }

    public List<Servico> getListServicos() {
        return listServicos;
    }

    public void setListServicos(List<Servico> listServicos) {
        this.listServicos = listServicos;
    }
    
    

    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    

    public Long getId() {
        return id;
    }

    /*public void setId(Long id) {
        this.id = id;
    }*/

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
