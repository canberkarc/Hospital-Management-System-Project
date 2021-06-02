/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project222;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/**
 *
 * @author 
 */
public class Company {
    static String name;
    
    static List<Person> persons = new ArrayList<>();
    static List<Departments> departments = new ArrayList<>();
    static List<PriorityQueue<Appointment>> appointmets = new ArrayList<>();
    static Stack<Appointment>  history = new Stack<>();
    static Map<String,String> hospitalWorkersData =  new HashMap<>();//mail , password
    static Map<String,HospitalWorkers> hospitalWorkers =  new HashMap<>();//mail , password
    static Set<Patients> patientsData = new TreeSet<>();
    
    public Company(String name) {
        this.name = name;
    }
    
    public void saveDay(){
        
    }
    
    
    
    
}
