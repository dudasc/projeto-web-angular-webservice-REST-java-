/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.projetofinal.model;

import java.util.Date;

/**
 *
 * @author lisandro_bitencourt
 */
public class Especialista extends Pessoa {
    private String celular;
    private String telefone;
    private Date dtCadastro;
    private Categoria categoria;
    private Endereco endereco;

    public Especialista(String celular, String telefone, Date dtCadastro, Categoria categoria, Endereco endereco, Integer id, String nome, String email) {
        super(id, nome, email);
        this.celular = celular;
        this.telefone = telefone;
        this.dtCadastro = dtCadastro;
        this.categoria = categoria;
        this.endereco = endereco;
    }


    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }
    
    
}
