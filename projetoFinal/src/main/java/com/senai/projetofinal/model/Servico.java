/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.projetofinal.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.persistence.annotations.CascadeOnDelete;

/**
 *
 * @author lisandro_bitencourt
 */
@Entity
@Table(name = "servicos")
@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
public class Servico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nome", length = 100)
    private String nome;
    @Column(name = "valor")
    private Double valor;

    //CacadePersiste ja insere os dados do endereço da Fk
    @ManyToOne(fetch = FetchType.EAGER, cascade = {CascadeType.REFRESH})
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;

    /*@ManyToOne(fetch = FetchType.EAGER)
     @JoinColumn(name = "id_usuario")
     private Usuario usuario;*/
   
    //@ManyToMany(mappedBy = "Servico")
    //private List<Agenda> listaAgenda = new ArrayList<>();

    public Servico() {
    }

    public Servico(Long id, String nome, Double valor, Categoria categoria, Agenda agenda) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.categoria = categoria;

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

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

}
