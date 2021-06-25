/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package project222;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.UUID;
import java.util.Random;

/**
 *
 * @author omera
 */
public class Manager extends HospitalWorkers{

    /**
    * Constructor
    * @param name
    * @param surname
    * @param id
    * @param dateOfBirth
    * @param email
    * @param password
    */
    public Manager(String name, String surname, String id, Date dateOfBirth,String email , String password) {
        super(name, surname, id, dateOfBirth,email , password);
    }

    /**
    * Method to add clinic
    * @param name
    * @param id
    * @param phone
    * @throws IOException
    */
    public void addClinic(String name , int id , String phone) throws IOException{
        Policlinic cl = new Policlinic(name, 10, 10, 10, id);
        Company.departments.add(cl);
        Company.departmentsGraph.addVertex(cl);
        Company.saveDepartments();
    }

    /**
    * Method to remove clinic
    * @param id
    * @throws IOException
    */
    public void removeClinic(int id) throws IOException{
        for(int i = 0;i< Company.departments.size();i++){
            if(Company.departments.get(i) instanceof Policlinic && Company.departments.get(i).getId() == id){
                Company.departments.remove(i);
                Company.saveDepartments();
                Company.departmentsGraph.removeVertex(Company.departments.get(i));
            }
        }
    }

    /**
    *   Method to connect departments which are in the same buildings
    *   @param pol Policlinic
    */
    public void connectDepartments(Policlinic pol){
        for(int i=0; i < Company.departments.size(); i++){
            Random ran = new Random();
            int rand = ran.nextInt(2);
            if(!pol.equals(Company.departments.get(i))){
                if(rand == 1 && !Company.departmentsGraph.hasEdge(pol, Company.departments.get(i))){
                    Company.departmentsGraph.addEdge(pol, Company.departments.get(i));
                    Company.departmentsGraph.addEdge(Company.departments.get(i), pol);
                }
            }
        }
    }

    public String checkPatients(){
        ArrayList<Person> pat = new ArrayList<>(Company.persons);
        SortAlgorithm.quick(pat, new Comparator<Person>(){
            @Override
            public int compare(Person o1, Person o2) {
                return o1.compareTo(o2);
            }
        });

        String res ="";
        for(int i = 0;i<pat.size();i++){
            if(pat.get(i) instanceof Patients)
                res+= pat.get(i)+"\n";
        }
        return res;
    }
 
    /**
    * add personel to hospital 
    * @param worker
    * @throws IOException
    */   
    public void addPersonel(HospitalWorkers worker) throws IOException{
        Company.persons.add(worker);
        Company.hospitalWorkersData.put(worker.getEmail(),worker.getPassword());
        Company.hospitalWorkers.put(worker.getEmail(), worker);
        Company.hospitalWorkerswithId.put(worker.getId(),worker);
        Company.savePersons();
    }

    /**
    * remove personel from hospital 
    * @param worker
    * @throws IOException
    */  
    public void removePersonel(HospitalWorkers worker) throws IOException{
        Company.persons.remove(worker);
        Company.hospitalWorkersData.remove(worker.getEmail());
        Company.hospitalWorkers.remove(worker.getEmail());
        Company.hospitalWorkerswithId.remove(worker.getId());
        Company.savePersons();
    }

    /**
    * edit personel in hospital 
    * @param old
    * @param cur
    * @throws IOException
    */  
    public void editPersonel(HospitalWorkers old , HospitalWorkers cur) throws IOException{
        Company.persons.add(cur);
        Company.hospitalWorkersData.put(cur.getEmail(),cur.getPassword());
        Company.hospitalWorkers.put(cur.getEmail(), cur);
        Company.hospitalWorkers.remove(old.getEmail());
        Company.persons.remove(old);
        Company.hospitalWorkersData.remove(old.getEmail());
        Company.savePersons();
    }

    /** Method to save format
    */
    @Override
    public String saveFormat() {
        StringBuilder strBuild = new StringBuilder(super.saveFormat());
        strBuild.append(";");
        strBuild.append("M");
        return strBuild.toString();
    }
}
