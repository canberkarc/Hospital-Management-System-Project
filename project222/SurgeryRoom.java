/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package project222;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;
import java.util.Calendar;

/**
 *
 * @author omera
 */
public class SurgeryRoom extends Departments{
    private final String name = "Surgery Room";
    private ArrayList<Doctor> doctors = new ArrayList<>();
    private ArrayList<Nurse> nurses = new ArrayList<>();
    private Patients patient;
    private String surgeryName;
    Date surgeryDate;
    
    public String getName() {
        return this.name;
    }
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
 
    public Date getDate() {
        return surgeryDate;
    }
    
    public void setDate(Date surgeryDate) {
        this.surgeryDate = surgeryDate;
    }
    
    public SurgeryRoom(int id, String surgeryName, ArrayList<Doctor> doctors, ArrayList<Nurse> nurses, Patients patient, Date surgeryDate) {
        super(id);
    	this.doctors = doctors;
    	this.nurses = nurses;
        this.patient = patient;
        this.surgeryName = surgeryName;
        this.surgeryDate = surgeryDate;
    }

    public boolean doSurgery() {
        Date currentTime = Calendar.getInstance().getTime();
        if(currentTime.compareTo(this.getDate()) > 0) // surgery is completed
            return true;
        else
            return false;
    } 
 
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof SurgeryRoom))
            return false;
        SurgeryRoom s = (SurgeryRoom) o;
        return getName().equals(s.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
    
    @Override
    public String toString() {
        String result = "";
        
        result += "Surgery Room{ " + 
                "\n surgery name = " + getSurgeryName() +
                "\n surgery date = " + this.getSurgeryName() +
                "\n patient name = " + getPatient().getName();
        
        if(this.getDoctors().size() > 0) {
            result += "\n doctors = {";
            for(int i = 0; i < this.getDoctors().size(); ++i) {
                result += this.getDoctors().get(i).getName() + " " +
                        this.getDoctors().get(i).getSurname() + ", ";
            }
            result += "}";
        }
        
        if(this.getNurses().size() > 0) {
            result += "\n nurses = {";
            for(int i = 0; i < this.getNurses().size(); ++i) {
                result += this.getNurses().get(i).getName() + " " +
                        this.getNurses().get(i).getSurname() + ", ";
            }
            result += "} \n";
        }
        result += "} \n";
        
        return result;
    }

    
}