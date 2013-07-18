/**
 * @author rsaraiva
 */
package com.rsaraiva.labs.exapp01.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Person implements java.io.Serializable {
    
    @Id @GeneratedValue
    private Integer id;
    
    private String name;
    
    private Integer age;

    public Integer getId() { return id; }
    public String getName() { return name; }
    public Integer getAge() { return age; }

    public void setId(Integer id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setAge(Integer age) { this.age = age; }
}
