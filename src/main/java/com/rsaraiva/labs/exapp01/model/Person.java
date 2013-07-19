/**
 * @author rsaraiva
 */
package com.rsaraiva.labs.exapp01.model;

import java.util.Objects;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Person other = (Person) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
}
