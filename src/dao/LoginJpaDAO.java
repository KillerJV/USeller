/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.jdbc.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.swing.JOptionPane;
import model.Login;
import model.Professional;
import org.hibernate.Session;

/**
 *
 * @author E-Commerce
 */
public class LoginJpaDAO {

    private static LoginJpaDAO instance;
    protected EntityManager entityManager;

    public static LoginJpaDAO getInstance() {
        if (instance == null) {
            instance = new LoginJpaDAO();
        }

        return instance;
    }

    private LoginJpaDAO() {
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

    public Login getById(final long id) {
        return entityManager.find(Login.class, id);
    }

    public Query consultar(String user, String pass) throws SQLException {
// Manda como parametro para ele duas variaveis para ele procurar no banco de dados!

        Query query = this.entityManager.createNativeQuery("select * from venda.login where userLogin  = ? and password = ?", Login.class);
        query.setParameter(1, user);
        query.setParameter(2, pass);
        List<Login> log = query.getResultList();

        for (Login logins : log) {
            System.out.println(logins.getUserLogin() + "-" + logins.getPassword());
        }
        return query;
    }

    @SuppressWarnings("unchecked")
    public List<Login> findAll() {
        return entityManager.createQuery("FROM "
                + Professional.class.getName()).getResultList();
    }

    public void persist(Login login) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(login);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void merge(Login login) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(login);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void remove(Login login) {
        try {
            entityManager.getTransaction().begin();
            login = entityManager.find(Login.class, login.getIdLogin());
            entityManager.remove(login);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            entityManager.getTransaction().rollback();
        }
    }

    public void removeById(final int id) {
        try {
            Login login = getById(id);
            remove(login);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
