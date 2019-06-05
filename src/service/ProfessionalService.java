/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import model.Professional;
import util.JpaUtil;

/**
 *
 * @author E-Commerce
 */
public class ProfessionalService {
 
    public void save(Professional professional){
        
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        manager.persist(professional);
    }
}
    
