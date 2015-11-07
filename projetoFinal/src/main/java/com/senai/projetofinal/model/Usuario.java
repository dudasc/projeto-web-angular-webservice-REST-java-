/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.projetofinal.model;

/**
 *
 * @author lisandro_bitencourt
 */
public class Usuario extends Pessoa {
    private String login;
    private String senha;

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
