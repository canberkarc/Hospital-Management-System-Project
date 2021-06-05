/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project222;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.UUID;

/**
 *
 * @author omera
 */
public class Project222 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        try {
            Company.loadPersons();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Doctor doctor = new Doctor("ali", "veli", "1", new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998"), "1", "1");
        Nurse nurse = new Nurse("ali", "veli", "1", new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998"), "2", "2");
        LabPersonnel labpers = new LabPersonnel("ali", "veli", "1", new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998"), "3", "3");
        Manager manager = new Manager("ali", "veli", "1", new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998"), "4", "4");
        RecordPersonel recordPersonel = new RecordPersonel("ali", "veli", "1", new SimpleDateFormat("dd/MM/yyyy").parse("31/12/1998"), "5", "5");
        
        Company.hospitalWorkers.put(nurse.getEmail(), nurse);
        Company.hospitalWorkersData.put(nurse.getEmail(), nurse.getPassword());
        
        Company.hospitalWorkers.put(doctor.getEmail(), doctor);
        Company.hospitalWorkersData.put(doctor.getEmail(), doctor.getPassword());
        
        Company.hospitalWorkers.put(labpers.getEmail(), labpers);
        Company.hospitalWorkersData.put(labpers.getEmail(), labpers.getPassword());
        
        Company.hospitalWorkers.put(manager.getEmail(), manager);
        Company.hospitalWorkersData.put(manager.getEmail(), manager.getPassword());
        
        Company.hospitalWorkers.put(recordPersonel.getEmail(), recordPersonel);
        Company.hospitalWorkersData.put(recordPersonel.getEmail(), recordPersonel.getPassword());
        
        
        
        
        

        // TODO code application logic here
        new mainScreen().setVisible(true);

    }
    
}
