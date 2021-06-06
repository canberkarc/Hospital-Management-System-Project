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
public class Nurse extends HospitalWorkers{
    
    public Nurse(String name, String surname, String id, Date dateOfBirth,String email , String password) {
        super(name, surname, id, dateOfBirth, email ,  password);
    }
    
    public void updatePatientInfo(Appointment appo,String note) {
    	appo.setNote(note);
    }
    
    public void vaccinate(Patients patient) {
    	patient.setVaccinated(true);
    }
    
    public void covidTest(Patients patient,String result) {
    	patient.setCovid(result);
    }
     
    @Override
    public String saveFormat() {
        StringBuilder strBuild = new StringBuilder(super.saveFormat());
        strBuild.append(";");
        strBuild.append("N");
        return strBuild.toString();
    }
}
