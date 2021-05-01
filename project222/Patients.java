/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project222;

import java.util.ArrayList;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author omera
 */
public class Patients extends Person{

    ArrayList<Test> tests = new ArrayList<>();
    
    public Patients(String name, String surname, String id, Date dateOfBirth) {
        super(name, surname, id, dateOfBirth);
    }

    @Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
