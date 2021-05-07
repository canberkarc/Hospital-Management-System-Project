package project222;
import java.util.ArrayList;
import java.util.Date;

/**
* @author Canberk Arıcı
*/

public class Emergency extends Departments{
	private ArrayList<Doctor> doctors = new ArrayList<>();
    private ArrayList<Nurse> nurses = new ArrayList<>();
 	private ArrayList<Patients> patients = new ArrayList<>();   

 	public ArrayList<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(ArrayList<Doctor> doctors) {
        this.doctors = doctors;
    }

    public ArrayList<Nurse> getNurses() {
        return nurses;
    }

    public void setNurses(ArrayList<Nurse> nurses) {
        this.nurses = nurses;
    }

    public ArrayList<Patients> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Patients> patients) {
        this.patients = patients;
    }

    public Emergency(int id, ArrayList<Doctor> doctors, ArrayList<Nurse> nurses, Patients patients, String surgeryName, Date surgeryDate) {
    	this.doctors = doctors;
    	this.nurses = nurses;
        this.patients = patients;
    }

    public boolean intervention() {
        // wıll be filled
    } 
}
