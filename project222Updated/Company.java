/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project222;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
    private static final String personDataFile = ".\\Database\\users.txt";
    static String name;
    
    
    static List<Person> persons = new ArrayList<>();
    static List<Departments> departments = new ArrayList<>();
    static List<PriorityQueue<Appointment>> appointmets = new ArrayList<>();
    static Stack<Appointment>  history = new Stack<>();
    static Map<String,String> hospitalWorkersData =  new HashMap<>();//mail , password
    static Map<String,HospitalWorkers> hospitalWorkers =  new HashMap<>();//mail , password
    static Set<Patients> patientsData = new TreeSet<>();

    private enum DataPart{
        NAME(0),
        SURNAME(1),
        ID(2),
        BIRTH(3),
        MAIL(4),
        PASSWORD(5),
        TYPE(6);

        private final int val;
        private DataPart(int val){
            this.val = val;
        }
        public int getValue(){
            return val;
        }
    }
    
    public Company(String name) throws IOException {
        this.name = name;
        loadPersons();
    }
    
    public void saveDay(){
        
    }
    
    
    
    public static void savePersons() throws IOException{
        File datab = new File(personDataFile);
        BufferedWriter bwriter = new BufferedWriter(new FileWriter(datab));
        for(Person p : persons){
            bwriter.write(p.saveFormat());
            bwriter.newLine();
        }
        bwriter.close();
    }

    public static void loadPersons() throws IOException{
        FileSplitter fsplit = new FileSplitter(personDataFile, ";");
        List<String> line = fsplit.nextLine();
        while(line != null && !line.isEmpty()){
            Person person = createPerson(line);
            persons.add(person);
            if(!line.get(DataPart.TYPE.getValue()).equals("P")){
                HospitalWorkers hworker = (HospitalWorkers) person;
                hospitalWorkersData.put(hworker.getEmail(), hworker.getPassword());
                hospitalWorkers.put(hworker.getEmail(), hworker);
            }
            line = fsplit.nextLine();
        }
        if(line != null)
            fsplit.nextLine();
    }

    private static Person createPerson(List<String> line){
        Person returnVal = null;
        if(line.get(DataPart.TYPE.getValue()).equals("D")){
            returnVal = new Doctor(line.get(DataPart.NAME.getValue()), 
                                    line.get(DataPart.SURNAME.getValue()),
                                    line.get(DataPart.ID.getValue()),
                                    createDate(line.get(DataPart.BIRTH.getValue())),
                                    line.get(DataPart.MAIL.getValue()),
                                    line.get(DataPart.PASSWORD.getValue()));
        }
        else if(line.get(DataPart.TYPE.getValue()).equals("M")){
            returnVal = new Manager(line.get(DataPart.NAME.getValue()), 
                                    line.get(DataPart.SURNAME.getValue()),
                                    line.get(DataPart.ID.getValue()),
                                    createDate(line.get(DataPart.BIRTH.getValue())),
                                    line.get(DataPart.MAIL.getValue()),
                                    line.get(DataPart.PASSWORD.getValue()));
        }
        else if(line.get(DataPart.TYPE.getValue()).equals("L")){
            returnVal = new LabPersonnel(line.get(DataPart.NAME.getValue()), 
                                    line.get(DataPart.SURNAME.getValue()),
                                    line.get(DataPart.ID.getValue()),
                                    createDate(line.get(DataPart.BIRTH.getValue())),
                                    line.get(DataPart.MAIL.getValue()),
                                    line.get(DataPart.PASSWORD.getValue()));
        }
        else if(line.get(DataPart.TYPE.getValue()).equals("R")){
            returnVal = new RecordPersonel(line.get(DataPart.NAME.getValue()), 
                                    line.get(DataPart.SURNAME.getValue()),
                                    line.get(DataPart.ID.getValue()),
                                    createDate(line.get(DataPart.BIRTH.getValue())),
                                    line.get(DataPart.MAIL.getValue()),
                                    line.get(DataPart.PASSWORD.getValue()));
        }
        else if(line.get(DataPart.TYPE.getValue()).equals("N")){
            returnVal = new Nurse(line.get(DataPart.NAME.getValue()), 
                                    line.get(DataPart.SURNAME.getValue()),
                                    line.get(DataPart.ID.getValue()),
                                    createDate(line.get(DataPart.BIRTH.getValue())),
                                    line.get(DataPart.MAIL.getValue()),
                                    line.get(DataPart.PASSWORD.getValue()));
        }
        else if(line.get(DataPart.TYPE.getValue()).equals("P")){
            returnVal = new Patients(line.get(DataPart.NAME.getValue()), 
                                    line.get(DataPart.SURNAME.getValue()),
                                    line.get(DataPart.ID.getValue()),
                                    createDate(line.get(DataPart.BIRTH.getValue())));
        }

        return returnVal;
    }

    private static Date createDate(String date){
        String[] part = date.split("-");
        Calendar cal = Calendar.getInstance() ;
        cal.set(Integer.parseInt(part[0]), Integer.parseInt(part[1]), Integer.parseInt(part[2]));
        return cal.getTime();
    }
}
