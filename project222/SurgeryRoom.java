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
    
    public SurgeryRoom(int id) {
        super(id);
    }
    
    public public SurgeryRoom(ArrayList<Doctor> doctors, ArrayList<Nurse> nurses, Patients patient) {
    	this.doctors = doctors;
    	this.nurses = nurses;
    	this.patient = patient;
	}
    
}
