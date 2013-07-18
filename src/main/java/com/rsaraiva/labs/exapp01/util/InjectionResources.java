/**
 * @author rsaraiva
 */
package com.rsaraiva.labs.exapp01.util;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class InjectionResources {
    
    @Produces
    @ApplicationScoped
    private EntityManagerFactory getEntityManagerFactory() {
        return Persistence.createEntityManagerFactory("exapp-01-pu");
    }
    
    @Produces
    @RequestScoped
    private EntityManager getEntityManager(EntityManagerFactory factory) {
        return factory.createEntityManager();
    }
    
    public void close(@Disposes EntityManager em) {
		em.close();
	}
    
    @Produces
    private FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }
}
