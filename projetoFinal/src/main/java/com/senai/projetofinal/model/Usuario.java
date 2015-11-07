/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.projetofinal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author lisandro_bitencourt
 */
@Entity
@Table(name = "usuarios")
@XmlRootElement
public class Usuario extends Pessoa {

    @Column(name = "login", unique = true, nullable = true)
    private String login;
    @Column(name = "senha", nullable = true)
    private String senha;

    //JPA precisa de um contrutor vazio em cada class model para gerar as tabelas

    public Usuario() {
        
    }
    
    
    

    public Usuario(String login, String senha, Integer id, String nome, String email) {
        super(id, nome, email);
        this.login = login;
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
