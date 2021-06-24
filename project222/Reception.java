/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package project222;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

//import project222.RecordPersonel;

/**
 *
 * @author omera
 */
public class Reception extends Departments{
    private final String name = "Reception";
    private ArrayList<RecordPersonel> recWorkers;

    public Reception(int id) {
        super(id);
        recWorkers = new ArrayList<>();
    }
    
    public RecordPersonel getPersonnel(String id) throws NoSuchElementException{
        for(RecordPersonel rec : recWorkers){
            if(rec.getId().equals(id))
                return rec;
        }
        throw new NoSuchElementException();
    }

    public String addPersonnel(RecordPersonel per){
        recWorkers.add(per);
        Company.persons.add(per);
        return per.getId();
    }

    public boolean removePersonnel(String id){
        Iterator<RecordPersonel> iter = recWorkers.iterator();
        while(iter.hasNext()){
            if(iter.next().getId().equals(id)){
                iter.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString(){
        StringBuilder strBuild = new StringBuilder();
        for(RecordPersonel p : recWorkers)
            strBuild.append(p.toString()).append("/n");
        return strBuild.toString();
    }

    public boolean addAppointment(Appointment app){
        //
        return true;
    }

    @Override
    public String saveFormat() {
        StringBuilder strBuild = new StringBuilder(super.saveFormat());
        strBuild.append(";").append(name).append(";");
        for(int i = 0; i < recWorkers.size(); ++i){
            strBuild.append(recWorkers.get(i).getId());
            if(i != recWorkers.size() - 1)
                strBuild.append("%");
        }
        strBuild.append(";-;-;");
        strBuild.append("R");
        return strBuild.toString();
    }
}
