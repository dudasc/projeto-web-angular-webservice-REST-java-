/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.senai.projetofinal.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author duda
 */
public class GerarBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       EntityManagerFactory factory = Persistence.createEntityManagerFactory("projetosenaiPU");
       EntityManager entityManager = factory.createEntityManager();
       
    }
    
}
