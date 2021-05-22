package project222;

import java.util.ArrayList;
import java.util.Objects;

/**
 * @author group15
 */
public class Policlinic extends Departments{

    private String name;
    private int doctorCapacity;
    private int nurseCapacity;
    private int patientCapacity;
    private ArrayList<Doctor> doctors = new ArrayList<>();
    private ArrayList<Nurse> nurses = new ArrayList<>();
    private ArrayList<Patients> patients = new ArrayList<>();

    public ArrayList<Patients> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Patients> patients) {
        this.patients = patients;
    }

    Policlinic (String name, int doctorCapacity, int nurseCapacity, int patientCapacity,int id) {
        super(id);
        this.name = name;
        this.doctorCapacity = doctorCapacity;
        this.nurseCapacity = nurseCapacity;
        this.patientCapacity = patientCapacity;
        System.out.println("" + this.toString());
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    public void setNurses(ArrayList<Nurse> nurses) {
        this.nurses = nurses;
    }



    public void setDoctorCapacity(int doctorCapacity) {
        this.doctorCapacity = doctorCapacity;
    }

    public void setNurseCapacity(int nurseCapacity) {
        this.nurseCapacity = nurseCapacity;
    }

    public void setPatientCapacity(int patientCapacity) {
        this.patientCapacity = patientCapacity;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public ArrayList<Nurse> getNurses() {
        return nurses;
    }



    public int getDoctorCapacity() {
        return doctorCapacity;
    }

    public int getNurseCapacity() {
        return nurseCapacity;
    }

    public int getPatientCapacity() {
        return patientCapacity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Policlinic))
            return false;
        Policlinic that = (Policlinic) o;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return "Policlinic{" +
                "name='" + name + '\'' +
                ", doctorCapacity=" + doctorCapacity +
                ", nurseCapacity=" + nurseCapacity +
                ", patientCapacity=" + patientCapacity +
                '}';
    }

    public boolean addDoctor (Doctor newDoctor) {
        if (doctors.size() == doctorCapacity) {
            System.out.println("Doctor capacity is full!");
            return false;
        }
        return doctors.add(newDoctor);
    }

    public Doctor removeDoctor (int index) {
        if (doctors.isEmpty()) {
            System.out.println("There is not even one doctor in this clinic.");
            return null;
        }
        if (index < 0 || index > doctors.size())
            throw new IndexOutOfBoundsException();
        return doctors.remove(index);
    }

    public boolean addNurse (Nurse newNurse) {
        if (nurses.size() == nurseCapacity) {
            System.out.println("Nurse capacity is full!");
            return false;
        }
        return nurses.add(newNurse);
    }

    public Nurse removeNurse (int index) {
        if (nurses.isEmpty()) {
            System.out.println("There is not even one nurse in this clinic.");
            return null;
        }
        if (index < 0 || index > nurses.size())
            throw new IndexOutOfBoundsException();
        return nurses.remove(index);
    }

    public boolean addPatient (Patients newPatient) {
        if (patients.size() == patientCapacity) {
            System.out.println("Patient capacity is full!");
            return false;
        }
        return patients.add(newPatient);
    }

    public Patients removePatient (int index) {
        if (patients.isEmpty()) {
            System.out.println("There is not even one patient in this clinic.");
            return null;
        }
        if (index < 0 || index > patients.size())
            throw new IndexOutOfBoundsException();
        return patients.remove(index);
    }

    public String viewDoctors() {
        String result = "---------------Doctor List:\n";
        if (doctors.size() == 0)
            return result + "-";
        for (int i = 0; i < doctors.size(); ++i) {
            result += i + ". " + doctors.get(i).getName() + "\n";
        }
        return result;
    }

    public String viewNurses() {
        String result = "---------------Nurse List:\n";
        if (nurses.size() == 0)
            return result + "-";
        for (int i = 0; i < nurses.size(); ++i) {
            result += i + ". " + nurses.get(i).getName() + "\n";
        }
        return result;
    }

    public String viewPatients() {
        String result = "---------------Patient List:\n";
        if (patients.size() == 0)
            return result + "-";
        for (int i = 0; i < patients.size(); ++i) {
            result += i + ". " + patients.get(i).getName() + "\n";
        }
        return result;
    }

    public boolean searchDoctor (Doctor doctor) {
        for (int i = 0; i < doctors.size(); ++i) {
            if (doctors.get(i).equals(doctor)) {
                return true;
            }
        }
        return false;
    }

    public boolean searchNurse (Nurse nurse) {
        for (int i = 0; i < nurses.size(); ++i) {
            if (nurses.get(i).equals(nurse)) {
                return true;
            }
        }
        return false;
    }

    public boolean searchPatient (Patients patient) {
        for (int i = 0; i < patients.size(); ++i) {
            if (patients.get(i).equals(patient)) {
                return true;
            }
        }
        return false;
    }

}
