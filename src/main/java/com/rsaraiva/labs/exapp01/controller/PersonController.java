/**
 * @author rsaraiva
 */
package com.rsaraiva.labs.exapp01.controller;

import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

@Named(value = "person")
@ViewScoped
public class PersonController implements java.io.Serializable {

    @Inject private FacesContext context;
    
    private String name = "test";
    
    @PostConstruct
    private void seeInjections() {
        System.out.println(context);
    }

    public String getName() { return name; }
}
