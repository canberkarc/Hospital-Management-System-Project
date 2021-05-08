/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project222;

import java.util.Date;
import java.util.UUID;

/**
 *
 * @author omera
 */
public class Manager extends Person{

    public Manager(String name, String surname, String id, Date dateOfBirth) {
        super(name, surname, id, dateOfBirth);
    }
    public void addClinic(String name , int id , String phone){
        
    }
    public void removeClinic(int id){
        
    }
    public String checkPatients(){
        return "";
    }
    
    public void addPersonel(HospitalWorkers worker){
        
    }
    public void removePersonel(HospitalWorkers worker){
        
    }
    public void editPersonel(HospitalWorkers old , HospitalWorkers cur){
        
    }
    
}
