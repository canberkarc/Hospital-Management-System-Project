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
    private ArrayList<HospitalWorkers> workers = new ArrayList<>();
    
    
    private int id;

    public Departments(int id) {
        this.id = id;
    }

    public ArrayList<HospitalWorkers> getWorkers() {
        return workers;
    }

    public void setWorkers(ArrayList<HospitalWorkers> workers) {
        this.workers = workers;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


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

    @Override
    public String toString() {
        return "Departments{" + "id=" + id + '}';
    }
    
    @Override
    public String saveFormat() {
        StringBuilder strBuild = new StringBuilder();
        strBuild.append(id);
        return strBuild.toString();
    }
}
