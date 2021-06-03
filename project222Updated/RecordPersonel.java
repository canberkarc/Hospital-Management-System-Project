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
public class RecordPersonel extends HospitalWorkers{
    
    public RecordPersonel(String name, String surname, String id, Date dateOfBirth,String email , String password) {
        super(name, surname, id, dateOfBirth, email , password);
    }

    public void addPatient(Patients patient){
        Company.patientsData.add(patient);
    }

    public void removePatient(Patients patient){
        Company.patientsData.remove(patient);
    }
    
}
