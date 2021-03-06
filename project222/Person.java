/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package project222;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;
/**
 *
 * @author grup15
 */
public abstract class Person implements Comparable<Person>, DatabaseComponent {
    private String name;
    private String surname;
    private String id;
    private Date dateOfBirth;
    

    public Person(String name, String surname, String id, Date dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.dateOfBirth = dateOfBirth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
    


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
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

    @Override
    public  int compareTo(Person o){
        return ((Person)o).id.compareTo(id);
    }
    
    
    
    @Override
    public String toString() {
        return name + "," + surname + "," + id + "," + dateOfBirth;
    }
    
    
    
    @Override
    public String saveFormat() {
        SimpleDateFormat sformat = new SimpleDateFormat("dd-MM-yyyy");
        StringBuilder strBuild = new StringBuilder();
        strBuild.append(getName()).append(";").
                append(getSurname()).append(";").
                append(getId()).append(";").
                append(sformat.format(getDateOfBirth()));
        return strBuild.toString();
    }
}
