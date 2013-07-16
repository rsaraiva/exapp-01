/**
 * @author rsaraiva
 */
package com.rsaraiva.labs.exapp01.util;

import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;

public class InjectionResources {
    
    @Produces
    private FacesContext getContext() {
        return FacesContext.getCurrentInstance();
    }
}
