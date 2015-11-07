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
    
    private static EntityManagerFactory entity = null;
    public static void main(String[] args) {
       entity = Persistence.createEntityManagerFactory("projetofinalPU");	
	
		if(entity == null){
			entity = (EntityManagerFactory) entity.createEntityManager();
		}
		
       
    }
    
}
