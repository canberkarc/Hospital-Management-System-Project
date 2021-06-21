/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
///package project222;

import java.util.ArrayList;

/**
 *
 * @author grup15
 */
public abstract class Departments implements DatabaseComponent{
    /**
    * List to keep hospital workers
    */
    private ArrayList<HospitalWorkers> workers = new ArrayList<>();
    
    /**
    * Department id
    */
    private int id;

    /**
    *   Constructor\
    * @param id
    */ 
    public Departments(int id) {
        this.id = id;
    }

    /**
    * Getter of workers list
    */
    public ArrayList<HospitalWorkers> getWorkers() {
        return workers;
    }

    /**
    * Setter of workers list
    */
    public void setWorkers(ArrayList<HospitalWorkers> workers) {
        this.workers = workers;
    }

    /** Getter of department id
    */
    public int getId() {
        return id;
    }

    /** Setter of department id
    */
    public void setId(int id) {
        this.id = id;
    }

    /** equals method
    */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Departments other = (Departments) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    /** toString method
    */
    @Override
    public String toString() {
        return "Departments{" + "id=" + id + '}';
    }
    
    /** Method to save format
    */
    @Override
    public String saveFormat() {
        StringBuilder strBuild = new StringBuilder();
        strBuild.append(id);
        return strBuild.toString();
    }
}
