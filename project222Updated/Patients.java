/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package project222;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author omera
 */
public class Patients extends Person{

    private ArrayList<Test> tests = new ArrayList<>();
    private boolean discharged = false;
    private ArrayList<Appointment> appointments = new ArrayList<>();
    private String covid="No info";
    private boolean vaccinated = false;

    public String getCovid() {
        return covid;
    }

    public void setCovid(String covid) {
        this.covid = covid;
    }

    public boolean isVaccinated() {
        return vaccinated;
    }

    public void setVaccinated(boolean vaccinated) {
        this.vaccinated = vaccinated;
    }
    

    public ArrayList<Appointment> getAppointments() {
        return appointments;
    }

    public void setAppointments(ArrayList<Appointment> appointments) {
        this.appointments = appointments;
    }

    public void addAppointment(Appointment app){
        if(app == null)
            throw new NullPointerException();
        appointments.add(app);
    }

    public ArrayList<Test> getTests() {
        return tests;
    }

    public void setTests(ArrayList<Test> tests) {
        this.tests = tests;
    }

    public boolean isDischarged() {
        return discharged;
    }

    public void setDischarged(boolean discharged) {
        this.discharged = discharged;
    }
    
    public Patients(String name, String surname, String id, Date dateOfBirth) {
        super(name, surname, id, dateOfBirth);
    }

    /*@Override
    public int compareTo(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    
    public String showRecords() {
        String res = "";
    	for(Appointment app:Company.history){
            if(app.getPatient().getId().equals(super.getId()))
                res += app+"\n";
        }
        return res;
    }
    public List<Policlinic> showPoliclinics() {
        List<Policlinic> list = new ArrayList<>();
    	for(int i = 0;i< Company.departments.size();i++){
            if(Company.departments.get(i) instanceof Policlinic)
                list.add((Policlinic)Company.departments.get(i));
        }
        return list;
    }

    @Override
    public String toString() {
        return super.toString() + "discharged=" + discharged + ", appointments=" + appointments + ", covid=" + covid + ", vaccinated=" + vaccinated;
    }

    @Override
    public String saveFormat() {
        StringBuilder strBuild = new StringBuilder(super.saveFormat());
        strBuild.append(";");
        strBuild.append("-").append(";").append("-").append(";").append("P");
        return strBuild.toString();
    }
    
}
