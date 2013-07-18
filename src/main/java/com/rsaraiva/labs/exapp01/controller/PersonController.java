/**
 * @author rsaraiva
 */
package com.rsaraiva.labs.exapp01.controller;

import com.rsaraiva.labs.exapp01.model.Person;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Named(value = "person")
@ViewScoped
public class PersonController implements java.io.Serializable {

    @Inject private EntityManager em;
    
    private Person person = new Person();
    private List<Person> personList = new ArrayList();
    
    @PostConstruct
    private void seeInjections() {
        System.out.println(em);
        Query query = em.createQuery("select p from Person p order by p.name");
        System.out.println(query);
        personList = query.getResultList();
        System.out.println(personList);
        for (Person person1 : personList) {
            System.out.println(person1);
        }
    }
    
    public void save() {
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        
        person = new Person();
    }

    public Person getPerson() { return person; }
    public List<Person> getPersonList() { return personList; }
    

}
