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

@Named(value = "person")
@ViewScoped
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
    
    public void edit() {
        person = em.find(Person.class, person.getId());
    }
    
    public void remove() {
        em.getTransaction().begin();
        em.remove(person);
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
