/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project222;

import java.util.Date;
import java.util.PriorityQueue;
import java.util.UUID;

/**
 *
 * @author omera
 */
public class Doctor extends HospitalWorkers{
    private PriorityQueue<Appointment> appointment;
    public Doctor(String name, String surname, String id, Date dateOfBirth,String email , String password) {
        super(name, surname, id, dateOfBirth, email ,  password);
        appointment = new PriorityQueue<>();
        Company.appointmets.add(appointment);
    }
    public boolean addAppointment(Appointment app){
        appointment.offer(app);
        return true;
    }
    public void doSurgery(Appointment appo , String note){
        appo.setSurgeon(true);
        appo.setNote(note);
    }
    public void giveReciepe(Appointment appo , String note){
        appo.setRecipe(note);
    }
    public void dischargePatient(Appointment appo , String note){
        appo.getPatient().setDischarged(true);
    }
}
