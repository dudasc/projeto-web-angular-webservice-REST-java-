package com.senai.projetofinal.model;

import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import org.eclipse.persistence.annotations.CascadeOnDelete;

/**
 *
 * @author lisandro_bitencourt
 */
@Entity
@Table(name = "clientes")
@XmlRootElement
public class Cliente extends Pessoa {

    @Column(name = "sexo", nullable = true, length = 1)
    private String sexo;

    @Column(name = "cpf", unique = true, nullable = true, length = 11)
    private String cpf;

    @Column(name = "celular", unique = true, nullable = true, length = 11)
    private String celular;

    @Column(name = "telefone", unique = true, nullable = true, length = 11)
    private String telefone;

    @Temporal(TemporalType.DATE)
    @Column(name = "dtNascimento", nullable = true)
    private Date dtNascimento;

    @Temporal(TemporalType.DATE)
    @Column(name = "dtCadastro", nullable = true)
    private Date dtCadastro;
//CacadePersiste ja insere os dados do endereço da Fk
    
    @OneToOne(fetch = FetchType.EAGER, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @CascadeOnDelete()
    @JoinColumn(name = "id_endereco")
    private Endereco endereco;

    public Cliente() {
    }

    public Cliente(String sexo, String cpf, String celular, String telefone, Date dtNascimento, Date dtCadastro, Integer id, String nome, String email) {
        super(id, nome, email);
        this.sexo = sexo;
        this.cpf = cpf;
        this.celular = celular;
        this.telefone = telefone;
        this.dtNascimento = dtNascimento;
        this.dtCadastro = dtCadastro;

        //this.endereco = endereco;
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

}
