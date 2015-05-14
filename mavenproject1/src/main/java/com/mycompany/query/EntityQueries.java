/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.query;

import com.mycompany.entity.Details;
import com.mycompany.mavenproject1.Home;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import org.apache.log4j.Logger;

/**
 *
 * @author Rahul
 */
public class EntityQueries {

    private static Logger LOG = Logger.getLogger(EntityQueries.class);

    public static void main(String args[]) {
        LOG.debug("Starts... Creating Entity Manager Factory");
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("persistenceUnit");
        LOG.debug("Created Entity Manager Factory");
        EntityManager entityManager = emFactory.createEntityManager();
        Details service = new Details();
        service.setName("RB");
        service.setTel(12);
        entityManager.getTransaction().begin();
        entityManager.persist(service);


        Query query = entityManager.createQuery("Select d.name from Detail d");

        List<String> list = query.getResultList();

        for (String name : list) {
            LOG.debug("Name :" + name);
        }

        entityManager.getTransaction().commit();
        entityManager.close();
        emFactory.close();
    }
}
