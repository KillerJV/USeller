/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Professional;

/**
 *
 * @author E-Commerce
 */
public class ProfessionalJpaDAO {

    private static ProfessionalJpaDAO instance;
    protected EntityManager entityManager;

    public static ProfessionalJpaDAO getInstance() {
        if (instance == null) {
            instance = new ProfessionalJpaDAO();
        }

        return instance;
    }

    private ProfessionalJpaDAO() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory
                = Persistence.createEntityManagerFactory("ProjetoPU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }

        return entityManager;
    }

    public Professional getById(final int id) {
        return entityManager.find(Professional.class, id);
    }

    @SuppressWarnings("unchecked")
    public List<Professional> findAll() {
        return entityManager.createQuery("FROM "
                + Professional.class.getName()).getResultList();
    }

    public void persist(Professional cliente) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(cliente);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Professional cliente) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(cliente);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Professional cliente) {
        try {
            entityManager.getTransaction().begin();
            cliente = entityManager.find(Professional.class, cliente.getIdProfessional());
            entityManager.remove(cliente);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(final int id) {
        try {
            Professional cliente = getById(id);
            remove(cliente);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
