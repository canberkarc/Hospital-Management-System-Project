/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package project222;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author omera
 */
public abstract class HospitalWorkers extends Person{
    
    private String email;
    private String password;

    public HospitalWorkers(String name, String surname, String id, Date dateOfBirth,String email , String password) {
        super(name, surname, id, dateOfBirth);
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return super.toString() + " email=" + email;
    }
    
    @Override
    public String saveFormat() {
        StringBuilder strBuild = new StringBuilder(super.saveFormat());
        strBuild.append(";");
        strBuild.append(getEmail()).append(";").append(getPassword());
        return strBuild.toString();
    }
}
