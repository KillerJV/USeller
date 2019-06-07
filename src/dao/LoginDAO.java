/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Login;

/**
 *
 * @author E-Commerce
 */
public class LoginDAO {

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = null;
        EntityManager entityManager = null;
        try {
            factory = Persistence.createEntityManagerFactory("ProjetoPU");
            entityManager = factory.createEntityManager();
        } finally {
            //factory.close();
        }
        return entityManager;
    }

    public Login salvar(Login login) {
        EntityManager entityManager = getEntityManager();

        try {
            entityManager.getTransaction().begin();

            System.out.println("Salvando dados do profissional!");

            if (login.getIdLogin() == null) {
                entityManager.persist(login);
            } else {
                login = entityManager.merge(login);
            }
            //entityManager.flush();
            entityManager.getTransaction().commit();
            
        } finally {
            //entityManager.close();
        }

        return login;
    }

    public void excluir(Long id) {
        EntityManager entityManager = getEntityManager();
        try {
            // Inicia uma transação com o banco de dados.
            entityManager.getTransaction().begin();
            // Consulta a pessoa na base de dados através do seu ID.
            Login login = entityManager.find(Login.class, id);
            System.out.println("Excluindo os dados de: " + login.getUserLogin());
            // Remove a pessoa da base de dados.
            entityManager.remove(login);
            // Finaliza a transação.
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }

    public Login consultarPorId(Long id) {
        EntityManager entityManager = getEntityManager();
        Login login = null;
        try {
            //Consulta uma pessoa pelo seu ID.
            login = entityManager.find(Login.class, id);
        } finally {
            entityManager.close();
        }
        return login;
    }

}
