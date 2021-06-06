/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package project222;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.management.loading.PrivateMLet;

/**
 *
 * @author omera
 */
public class Appointment implements Comparable<Appointment>, DatabaseComponent{
    private Policlinic poli;
    private Doctor doct;
    private Patients patient;
    private String note = "No note";
    private Date date;
    private String recipe = "No reciepe";
    private boolean surgeon;
    

    public boolean isSurgeon() {
        return surgeon;
    }

    public void setSurgeon(boolean surgeon) {
        this.surgeon = surgeon;
    }

    public Appointment(Policlinic poli, Doctor doct, Patients patient, Date date) {
        this.poli = poli;
        this.doct = doct;
        this.patient = patient;
        this.date = date;
    }

    public Policlinic getPoli() {
        return poli;
    }

    public void setPoli(Policlinic poli) {
        this.poli = poli;
    }

    public Doctor getDoct() {
        return doct;
    }

    public void setDoct(Doctor doct) {
        this.doct = doct;
    }

    public Patients getPatient() {
        return patient;
    }

    public void setPatient(Patients patient) {
        this.patient = patient;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRecipe() {
        return recipe;
    }

    public void setRecipe(String recipe) {
        this.recipe = recipe;
    }

    

    @Override
    public int compareTo(Appointment o) {
        if(date.getTime() > o.getDate().getTime())
            return 1;
        if(date.getTime() < o.getDate().getTime())
            return -1;
        return 0;
    }

    @Override
    public String saveFormat() {
        SimpleDateFormat smpf = new SimpleDateFormat("dd/MM/yyyy");
        StringBuilder strBuild = new StringBuilder();
        strBuild.append(poli.getId()).append(";");
        strBuild.append(doct.getId()).append(";");
        strBuild.append(patient.getId()).append(";");
        strBuild.append(smpf.format(getDate())).append(";");
        strBuild.append(note).append(";");
        strBuild.append(recipe).append(";");
        strBuild.append(surgeon);
        return strBuild.toString();
    }
    
    
}
