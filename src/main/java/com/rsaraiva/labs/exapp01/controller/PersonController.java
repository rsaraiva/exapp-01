/**
 * @author rsaraiva
 */
package com.rsaraiva.labs.exapp01.controller;

import com.rsaraiva.labs.exapp01.model.Person;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.enterprise.context.RequestScoped;

@Named(value = "person")
@RequestScoped
public class PersonController implements java.io.Serializable {

    @Inject private EntityManager em;
    
    private Person person = new Person();
    private List<Person> personList = new ArrayList();
    
    @PostConstruct
    private void init() {
        updatePersonList();
    }
    
    public void save() {
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
        resetPerson();
        updatePersonList();
    }
    
    public void edit(Integer id) {
        person = em.find(Person.class, id);
    }
    
    public void remove(Integer id) {
        em.getTransaction().begin();
        em.remove(em.find(Person.class, id));
        em.getTransaction().commit();
        resetPerson();
        updatePersonList();
    }
    
    public void cancel() {
        resetPerson();
    }
    
    private void updatePersonList() {
        personList = em.createQuery("select p from Person p order by p.name").getResultList();
    }
    
    private void resetPerson() {
        person = new Person();
    }

    public Person getPerson() { return person; }
    public List<Person> getPersonList() { return personList; }
    

}
