/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import javax.persistence.EntityManager;

/**
 *
 * @author blanusal
 */
public class RestHelper {
    
    public EntityManager getEntityManager() {
        return EMF.createEntityManager();
    }
    
    public void persistObject(EntityManager em, Object o) {
        em.getTransaction().begin();
        em.persist(o);
        em.getTransaction().commit();
    }

    public void removeObject(EntityManager em, Object o, Long id) {
        if (o == null) {
            throw new RuntimeException("News at index: " + id + " does not exits");
        }
        em.getTransaction().begin();
        em.remove(o);
        em.getTransaction().commit();
    }

    public void mergeObject(EntityManager em, Object o) {
        em.getTransaction().begin();
        em.merge(o);
        em.getTransaction().commit();
    }
    
}
