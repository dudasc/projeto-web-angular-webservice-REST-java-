package com.senai.projetofinal.dao;

/**
 *
 * @author leonardo
 */
public class LoginInvalidoException extends Exception {

    public LoginInvalidoException() {
        super("Usuário/senha inválido");
    }

}
