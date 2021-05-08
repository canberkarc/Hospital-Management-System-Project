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
public class Doctor extends Person{
    private PriorityQueue<Appointment> appointment;
    public Doctor(String name, String surname, String id, Date dateOfBirth) {
        super(name, surname, id, dateOfBirth);
        appointment = new PriorityQueue<>();
        Company.appointmets.add(appointment);
    }
    public boolean addAppointment(Appointment app){
        appointment.offer(app);
        return true;
    }
    public void doSurgery(Patients patient , String note){
        
    }
    public void giveReciepe(Patients patient , String note){
        
    }
    public void dischargePatient(Patients patient , String note){
        
    }
}
