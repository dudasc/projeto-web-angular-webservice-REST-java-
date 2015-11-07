package com.senai.projetofinal.model;

import java.util.Date;



/**
 *
 * @author lisandro_bitencourt
 */
public class Cliente extends Pessoa {
   private String sexo;
   private String cpf;
   private String celular;
   private String telefone;
   private Date dtNascimento;
   private Date dtCadastro;
   private Endereco endereco;
   private Usuario usuario;


    public Cliente(String sexo, String cpf, String celular, String telefone, Date dtNascimento, Date dtCadastro, Endereco endereco, Usuario usuario, Integer id, String nome, String email) {
        super(id, nome, email);
        this.sexo = sexo;
        this.cpf = cpf;
        this.celular = celular;
        this.telefone = telefone;
        this.dtNascimento = dtNascimento;
        this.dtCadastro = dtCadastro;
        this.endereco = endereco;
        this.usuario = usuario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
   
   

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public Date getDtNascimento() {
        return dtNascimento;
    }

    public void setDtNascimento(Date dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public Date getDtCadastro() {
        return dtCadastro;
    }

    public void setDtCadastro(Date dtCadastro) {
        this.dtCadastro = dtCadastro;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
    
   
  
}
