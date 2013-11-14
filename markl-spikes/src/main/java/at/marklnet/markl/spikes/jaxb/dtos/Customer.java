package at.marklnet.markl.spikes.jaxb.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.pojomatic.Pojomatic;
import org.pojomatic.annotations.AutoProperty;
 
/**
 * Maps this type to an XML element.
 * 
 * @author Markus Markl
 *
 */
@AutoProperty
@XmlAccessorType (XmlAccessType.FIELD)
@XmlRootElement
public class Customer {
 
    @XmlElement
    private String name;
    
    @XmlElement
    private int age;
    
    @XmlElement
    private int id;
    
    /**
     * Default c'tor.
     */
    public Customer() {

    }

    /**
     * @param name name to set
     * @param age age to set
     * @param id id to set
     */
    public Customer(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        return Pojomatic.hashCode(this);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object other) {
        return Pojomatic.equals(this, other);
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return Pojomatic.toString(this);
    }
    
    
 
}