/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.projetofinal.model;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author duda
 */
@Entity
@Table(name = "agendamentos")
@XmlRootElement

@XmlAccessorType(XmlAccessType.FIELD)
public class Agenda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private Cliente cliente;
    private Usuario usuario;
    @Temporal(TemporalType.DATE)
    @Column(name = "dtCadastro", nullable = true)
    private Date dataCadastro;
    @Temporal(TemporalType.TIME)
    @Column(name = "horario", nullable = true)
    private Time horario;
    @Column(name = "status")
    private Integer status = 0;
    @OneToMany
    private List<Servico> listaServicos = new ArrayList<>();
    @Column(name = "valorTotal")
    private Double valorTotal;

    public Agenda(Long id, Cliente cliente, Usuario usuario, Date dataCadastro, Time horario, Integer status, Double valorTotal) {
        this.id = id;
        this.cliente = cliente;
        this.usuario = usuario;
        this.dataCadastro = dataCadastro;
        this.horario = horario;
        this.status = status;
        this.valorTotal = valorTotal;
    }

    public Long getId() {
        return id;
    }

    /*public void setId(Long id) {
        this.id = id;
    }*/

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Time getHorario() {
        return horario;
    }

    public void setHorario(Time horario) {
        this.horario = horario;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Servico> getListaServicos() {
        return listaServicos;
    }

    public void setListaServicos(List<Servico> listaServicos) {
        this.listaServicos = listaServicos;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }
    
    
    
}
