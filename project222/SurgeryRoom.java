/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project222;

import java.util.ArrayList;

/**
 *
 * @author omera
 */
public class SurgeryRoom extends Departments{
	
    private ArrayList<Doctor> doctors = new ArrayList<>();
    private ArrayList<Nurse> nurses = new ArrayList<>();
    private Patients patient;
    private String surgeryName;
    
    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    public ArrayList<Nurse> getNurses() {
        return nurses;
    }

    public void setNurses(ArrayList<Nurse> nurses) {
        this.nurses = nurses;
    }

    public Patients getPatient() {
        return patient;
    }

    public void setPatient(Patients patient) {
        this.patient = patient;
    }

    public String getSurgeryName() {
        return surgeryName;
    }

    public void setSurgeryName(String surgeryName) {
        this.surgeryName = surgeryName;
    }
    
    public SurgeryRoom(int id) {
        super(id);
    }
    
    public public SurgeryRoom(ArrayList<Doctor> doctors, ArrayList<Nurse> nurses, Patients patient, String surgeryName) {
    	this.doctors = doctors;
    	this.nurses = nurses;
        this.patient = patient;
        this.surgeryName = surgeryName;
    }
    
}
