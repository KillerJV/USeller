/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Professional;

/**
 *
 * @author E-Commerce
 */
public class ProfessionalDAO {

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

    public Professional salvar(Professional professional) {
        EntityManager entityManager = getEntityManager();
       
        try{
            entityManager.getTransaction().begin();

            System.out.println("Salvando dados do profissional!");

            if (professional.getIdProfessional() == null) {
                entityManager.persist(professional);
            } else {
                professional = entityManager.merge(professional);
            }

            entityManager.getTransaction().commit();
        }finally{
            entityManager.close();
        }
        
        return professional;
    }

    public void excluir(Long id) {
        EntityManager entityManager = getEntityManager();
        try {
            // Inicia uma transação com o banco de dados.
            entityManager.getTransaction().begin();
            // Consulta a pessoa na base de dados através do seu ID.
            Professional professional = entityManager.find(Professional.class, id);
            System.out.println("Excluindo os dados de: " + professional.getNameProfessional());
            // Remove a pessoa da base de dados.
            entityManager.remove(professional);
            // Finaliza a transação.
            entityManager.getTransaction().commit();
        } finally {
            entityManager.close();
        }
    }
    
    public Professional consultarPorId(Long id) {
    EntityManager entityManager = getEntityManager();
    Professional professional = null;
    try {
      //Consulta uma pessoa pelo seu ID.
      professional = entityManager.find(Professional.class, id);
    } finally {
      entityManager.close();
    }
    return professional;
  }

}
