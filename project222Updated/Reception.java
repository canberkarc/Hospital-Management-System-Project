/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project222;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 * @author omera
 */
public class Reception extends Departments{
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

    public void addPersonnel(RecordPersonel per){
        recWorkers.add(per);
        Company.persons.add(per);
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

    public boolean addAppointment(Appointment app){
        //
        return true;
    }
}
