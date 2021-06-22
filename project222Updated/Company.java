/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package project222;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/**
 *
 * @author 
 */
public class Company {
    private static final String personDataFile = ".\\Database\\users.txt";
    private static final String departmentDataFile = ".\\Database\\departments.txt";
    private static final String dayFile = ".\\Database\\day.txt";
    static String name;
    
    static Graph<Departments> departmentsGraph = new Graph<>();
    static SkipList<Person> persons = new SkipList<>();
    static List<Departments> departments = new ArrayList<>();
    static List<PriorityQueue<Appointment>> appointmets = new ArrayList<>();
    static Stack<Appointment>  history = new Stack<>();
    static Map<String,String> hospitalWorkersData =  new HashMap<>();//mail , password
    static Map<String,HospitalWorkers> hospitalWorkers =  new HashMap<>();//mail worker
    static Map<String,HospitalWorkers> hospitalWorkerswithId =  new HashMap<>();//id , worker
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

    private enum DepartmentDataPart{
        ID(0),
        NAME(1),
        MAINPERSONNEL(2),
        HELPERPERSONNEL(3),
        PATIENTS(4),
        TYPE(5);

        private final int val;
        private DepartmentDataPart(int val){
            this.val = val;
        }
        public int getValue(){
            return val;
        }
    }
    
    public Company(String name){
        this.name = name;
        Company.appointmets.add(new PriorityQueue<Appointment>());
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
            }else{
                Patients pat = (Patients) person;
                patientsData.add(pat);
            }
            line = fsplit.nextLine();
        }
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

    public static Date createDate(String date){
        String[] part = date.split("-");
        Calendar cal = Calendar.getInstance() ;
        cal.set(Integer.parseInt(part[2]), Integer.parseInt(part[1]) - 1, Integer.parseInt(part[0]));
        System.out.println(cal.getTime());
        return cal.getTime();
    }

    public static Date getCurrentDate() throws IOException{
        File dayf = new File(dayFile);
        BufferedReader breader = new BufferedReader(new FileReader(dayf));
        String day = breader.readLine();
        breader.close();
        return createDate(day);
    }

    public static void updateCurrentDate(Date date) throws IOException{
        File dayf = new File(dayFile);
        BufferedWriter bwriter = new BufferedWriter(new FileWriter(dayf));
        bwriter.write(dateToString(date));
        bwriter.close();
        loadAppointment(date);
    }

    public static void saveDepartments() throws IOException{
        File datab = new File(departmentDataFile);
        BufferedWriter bwriter = new BufferedWriter(new FileWriter(datab));
        for(Departments d : departments){
            bwriter.write(d.saveFormat());
            bwriter.newLine();
        }
        bwriter.close();
    }

    public static void loadDepartments() throws IOException{
        FileSplitter fsplit = new FileSplitter(departmentDataFile, ";");
        List<String> line = fsplit.nextLine();
        while(line != null && !line.isEmpty()){
            Departments department = createDepartment(line);
            departments.add(department);
            line = fsplit.nextLine();
        }
        /*if(line != null)
            fsplit.nextLine();*/
    }

    private static Departments createDepartment(List<String> line){
        Departments returnVal = null;
        if(line.get(DepartmentDataPart.TYPE.getValue()).equals("P")){
            String doctorLine = line.get(DepartmentDataPart.MAINPERSONNEL.getValue());
            String[] doctors = doctorLine.split("%");
            String nurseLine = line.get(DepartmentDataPart.HELPERPERSONNEL.getValue());
            String[] nurses = nurseLine.split("%");
            String patientLine = line.get(DepartmentDataPart.PATIENTS.getValue());
            String[] patients = patientLine.split("%");
            Policlinic pol = new Policlinic(line.get(DepartmentDataPart.NAME.getValue()), doctors.length, nurses.length, patients.length, Integer.parseInt(line.get(DepartmentDataPart.ID.getValue())));
            pol.setId(Integer.parseInt(line.get(DepartmentDataPart.ID.getValue())));
            for(int i = 0; i < doctors.length; ++i)
                pol.addDoctor((Doctor) hospitalWorkers.get(doctors[i]));
            for(int i = 0; i < nurses.length; ++i)
                pol.addNurse((Nurse) hospitalWorkers.get(nurses[i]));
            for(int i = 0; i < patients.length; ++i){
                Patients pat = findPatient(patients[i]);
                if(pat != null)
                    pol.addPatient(pat);
            }
            returnVal = pol;
        }
        else if(line.get(DepartmentDataPart.TYPE.getValue()).equals("E")){
            String doctorLine = line.get(DepartmentDataPart.MAINPERSONNEL.getValue());
            String[] doctors = doctorLine.split("%");
            String nurseLine = line.get(DepartmentDataPart.HELPERPERSONNEL.getValue());
            String[] nurses = nurseLine.split("%");
            String patientLine = line.get(DepartmentDataPart.PATIENTS.getValue());
            String[] patients = patientLine.split("%");
            Emergency pol = new Emergency(Integer.parseInt(line.get(DepartmentDataPart.ID.getValue())), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
            pol.setId(Integer.parseInt(line.get(DepartmentDataPart.ID.getValue())));
            for(int i = 0; i < doctors.length; ++i)
                pol.addDoctor((Doctor) hospitalWorkers.get(doctors[i]));
            for(int i = 0; i < nurses.length; ++i)
                pol.addNurse((Nurse) hospitalWorkers.get(nurses[i]));
            for(int i = 0; i < patients.length; ++i){
                Patients pat = findPatient(patients[i]);
                if(pat != null)
                    pol.addPatient(pat);
            }
            returnVal = pol;
        }
        else if(line.get(DepartmentDataPart.TYPE.getValue()).equals("L")){
            String patientLine = line.get(DepartmentDataPart.PATIENTS.getValue());
            String[] patients = patientLine.split("%");
            Lab pol = new Lab(Integer.parseInt(line.get(DepartmentDataPart.ID.getValue())));
            pol.setId(Integer.parseInt(line.get(DepartmentDataPart.ID.getValue())));
            for(int i = 0; i < patients.length; ++i){
                Patients pat = findPatient(patients[i]);
                if(pat != null)
                    pol.addPatient(pat);
            }
            returnVal = pol;
        }
        else if(line.get(DepartmentDataPart.TYPE.getValue()).equals("R")){
            String recPersonnelLine = line.get(DepartmentDataPart.MAINPERSONNEL.getValue());
            String[] recPersonnels = recPersonnelLine.split("%");
            Reception pol = new Reception(Integer.parseInt(line.get(DepartmentDataPart.ID.getValue())));
            pol.setId(Integer.parseInt(line.get(DepartmentDataPart.ID.getValue())));
            for(int i = 0; i < recPersonnels.length; ++i){
                pol.addPersonnel((RecordPersonel) hospitalWorkers.get(recPersonnels[i]));
            }
            returnVal = pol;
        }

        return returnVal;
    }
    public static Patients findPatient(String id){
        TreeSet<Patients> patientsTree = (TreeSet<Patients>) patientsData;
        Patients patToFind = new Patients(null, null, id, null);

        Patients found = patientsTree.ceiling(patToFind);
        if(found != null && found.equals(patToFind))
            return found;
        return null;
    }

    public static Departments findDepartment(int id){
        for(Departments d : departments)
            if(d.getId() == id)
                return d;

        return null;
    }

    private static String dateToString(Date date){
        SimpleDateFormat smpf = new SimpleDateFormat("dd-MM-yyyy");
        return smpf.format(date);
    }

    public static void addAppointmentToDataBase(Appointment a) throws IOException{
        System.out.println(dateToString(a.getDate()));
        String filename = ".\\Database\\Appointment\\" + dateToString(a.getDate()) + ".txt";
        System.out.println(filename);
        File f = new File(filename);
        Queue<Appointment> apps = new LinkedList<>();
        if(f.exists()){
            FileSplitter fsplit = new FileSplitter(f.getName(), ";");
            List<String> strList = fsplit.nextLine();
            while(strList != null && !strList.isEmpty()){
                apps.offer(createAppointment(strList));
                strList = fsplit.nextLine();
            }
            apps.offer(a);
            BufferedWriter bwrite = new BufferedWriter(new FileWriter(f));
        
            while(!apps.isEmpty()){
                bwrite.write(apps.poll().saveFormat());
                bwrite.newLine();
            }
            bwrite.close();
        }else{
            if(f.createNewFile()){
                BufferedWriter bwrite = new BufferedWriter(new FileWriter(f));
                bwrite.write(a.saveFormat());
                bwrite.close();
            }
        }
    }

    public static void loadAppointment(Date date) throws IOException{
        SimpleDateFormat smpf = new SimpleDateFormat("dd-MM-yyyy");
        String filename = ".\\Database\\Appointment\\" + smpf.format(date) + ".txt";
        FileSplitter fsplit = new FileSplitter(filename, ";");
        List<String> line = fsplit.nextLine();
        while(line != null && !line.isEmpty()){
            Appointment app = createAppointment(line);
            app.getPatient().addAppointment(app);
            app.getDoct().addAppointment(app);
            line = fsplit.nextLine();
        }
        if(line != null)
            fsplit.nextLine();
    }

    private static Appointment createAppointment(List<String> line){
        return new Appointment((Policlinic)findDepartment(Integer.parseInt(line.get(0))), (Doctor)hospitalWorkers.get(line.get(1)),
                                         findPatient(line.get(2)), createDate(line.get(3)));
    }
}
