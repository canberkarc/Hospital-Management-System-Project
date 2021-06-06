/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package project222;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 *
 * @author omera
 */
public class Manager extends HospitalWorkers{

    public Manager(String name, String surname, String id, Date dateOfBirth,String email , String password) {
        super(name, surname, id, dateOfBirth,email , password);
    }
    public void addClinic(String name , int id , String phone,Departments department) throws IOException{
        Policlinic cl = new Policlinic(name, 10, 10, 10, id);
        Company.departments.add(cl);
        Company.saveDepartments();
    }
    public void removeClinic(int id) throws IOException{
        for(int i = 0;i< Company.departments.size();i++){
            if(Company.departments.get(i) instanceof Policlinic && Company.departments.get(i).getId() == id){
                Company.departments.remove(i);
                Company.saveDepartments();
            }
        }
    }
    public String checkPatients(){
        String res ="";
        for(int i = 0;i<Company.persons.size();i++){
            if(Company.persons.get(i) instanceof Patients)
                res+= Company.persons.get(i)+"\n";
        }
        return res;
    }
    
    
    
    
    
    public void addPersonel(HospitalWorkers worker) throws IOException{
        Company.persons.add(worker);
        Company.hospitalWorkersData.put(worker.getEmail(),worker.getPassword());
        Company.hospitalWorkers.put(worker.getEmail(), worker);
        Company.savePersons();
    }
    public void removePersonel(HospitalWorkers worker) throws IOException{
        Company.persons.remove(worker);
        Company.hospitalWorkersData.remove(worker.getEmail());
        Company.hospitalWorkers.remove(worker.getEmail());
        Company.savePersons();
    }
    public void editPersonel(HospitalWorkers old , HospitalWorkers cur) throws IOException{
        Company.persons.add(cur);
        Company.hospitalWorkersData.put(cur.getEmail(),cur.getPassword());
        Company.hospitalWorkers.put(cur.getEmail(), cur);
        Company.hospitalWorkers.remove(old.getEmail());
        Company.persons.remove(old);
        Company.hospitalWorkersData.remove(old.getEmail());
        Company.savePersons();
    }
    
    @Override
    public String saveFormat() {
        StringBuilder strBuild = new StringBuilder(super.saveFormat());
        strBuild.append(";");
        strBuild.append("M");
        return strBuild.toString();
    }
}
