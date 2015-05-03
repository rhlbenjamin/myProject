/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.query;

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
        EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("testPersistenceUnit");
        LOG.debug("Created Entity Manager Factory");
        EntityManager entityManager = emFactory.createEntityManager();

        Query query = entityManager.createQuery("Select d.name from Detail d");
        List<String> list = query.getResultList();

        for (String name : list) {
            LOG.debug("Name :" + name);
        }
    }
}
