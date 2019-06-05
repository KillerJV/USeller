/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import model.Login;
import util.JpaUtil;

/**
 *
 * @author E-Commerce
 */
public class LoginService {
    
    public void saveLogin(Login login){
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        manager.persist(login);
        tx.commit();
    }

    public List<Login> findLogin() {
        EntityManager manager = JpaUtil.getEntityManager();
        EntityTransaction tx = manager.getTransaction();
        tx.begin();
        
        List<Login> listLogin = null;
        
        try{
        listLogin = manager.createQuery("From Login l").getResultList();
        }catch(Exception e){
            System.err.println(e);
        }finally{
            manager.close();
        }
        return listLogin;
    }
}
