//package project222;
import java.util.ArrayList;
import java.util.Random;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author Canberk Arıcı
 */

public class Emergency extends Departments{
    private final String name = "Emergency";
    private ArrayList<Doctor> doctors = new ArrayList<>(5);
    private ArrayList<Nurse> nurses = new ArrayList<>(5);
    private ArrayList<Patients> patients = new ArrayList<>(10);

    public Emergency(int id, ArrayList<Doctor> doctors, ArrayList<Nurse> nurses, ArrayList<Patients> patients) {
        super(id);
        this.doctors = doctors;
        this.nurses = nurses;
        this.patients = patients;
    }

    public boolean addDoctor (Doctor newDoctor) {
        return doctors.add(newDoctor);
    }

    public Doctor removeDoctor (int index) {
        if (index < 0 || index > doctors.size())
            throw new IndexOutOfBoundsException();
        return doctors.remove(index);
    }

    public boolean addNurse (Nurse newNurse) {
        return nurses.add(newNurse);
    }

    public Nurse removeNurse (int index) {
        if (index < 0 || index > nurses.size())
            throw new IndexOutOfBoundsException();
        return nurses.remove(index);
    }

    public boolean addPatient (Patients newPatient) {
        return patients.add(newPatient);
    }

    public Patients removePatient (int index) {
        if (index < 0 || index > patients.size())
            throw new IndexOutOfBoundsException();
        return patients.remove(index);
    }

    public String getName(){
        return this.name;
    }

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

    public int getNumberOfPatients(){
        return patients.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Emergency))
            return false;
        Emergency e = (Emergency) o;
        return getName().equals(e.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    public String displayPatientStatus(Patients patient){
        boolean check = false;

        for(int i=0; i<patients.size(); i++){
            if(patients.get(i).equals(patient))
                check = true;
        }

        if(check == false){
            return "This patient is not in emergency.";
        }
        else{
            return patient.toString();
        }
    }

    public boolean dischargePatient(Patients emergencyPatient) {
        Random rand = new Random();
        boolean check = false;

        if(patients.size() == 0){
            return false;
        }

         for(int i=0; i<patients.size(); i++){
             if(patients.get(i).equals(emergencyPatient))
                 check = true;
         }

         if(check == false){
             return false;
         }

        if(doctors.size() == 0 && nurses.size() > 0){
            int nurseInd = rand.nextInt(nurses.size());
            emergencyPatient.setDischarged(false);
            return false;
        }
        else if(doctors.size() > 0 && nurses.size() > 0){
            int nurseInd = rand.nextInt(nurses.size());
            int doctorInd = rand.nextInt(doctors.size());
            emergencyPatient.setDischarged(true);
            return true;
        }
        else if(doctors.size() > 0 && nurses.size() == 0){
            int doctorInd = rand.nextInt(doctors.size());
            emergencyPatient.setDischarged(true);
            return true;
        }
        else{
            emergencyPatient.setDischarged(false);
            return false;
        }
    }

    public boolean transferPatient(Patients patient, Departments depToTransfer){
        boolean check = false;

        for(int i=0; i<patients.size(); i++){
            if(patients.get(i).equals(patient))
                check = true;
        }

        if(check == false)
            return false;

        if(Company.departments.size() == 0)
            return false;

        for(int i=0; i<Company.departments.size(); i++){
            if(Company.departments.get(i).equals(depToTransfer)){
                if(Company.departments.get(i) instanceof Lab){
                    ((Lab)Company.departments.get(i)).addPatient(patient);
                }
                else if(Company.departments.get(i) instanceof Policlinic){
                    ((Policlinic)Company.departments.get(i)).addPatient(patient);
                }
                else if(Company.departments.get(i) instanceof SurgeryRoom){
                    ((SurgeryRoom)Company.departments.get(i)).setPatient(patient);
                }
                this.patients.remove(patient);
                return true;
            }
        }

        return false;

    }

    public String toString(){
        String str = "";
        if(this.patients.size() > 0){
            str += "Patients in Emergency: \n";
            for(int i=0; i<this.patients.size(); i++){
                str = str + "Name: " + this.patients.get(i).getName() + "\n"
                + "Surname: " + this.patients.get(i).getSurname() + "\n" + "Id: " + this.patients.get(i).getId() + "\n\n";
            }
        }
        if(this.doctors.size() > 0){
            str += "Doctors in Emergency: \n";
            for (int i=0; i<this.doctors.size(); i++){
                str = str + "Name: " + this.doctors.get(i).getName() + "\n"
                + "Surname: " + this.doctors.get(i).getSurname() + "\n" + "Id: " + this.doctors.get(i).getId() + "\n\n";
            }
        }
        if(this.nurses.size() > 0){
            str += "Nurses in Emergency: \n";
            for (int i=0; i<this.nurses.size(); i++){
                str = str + "Name: " + this.nurses.get(i).getName() + "\n"
                        + "Surname: " + this.nurses.get(i).getSurname() + "\n" + "Id: " + this.doctors.get(i).getId() + "\n\n";
            }
        }
        return str;
    }

    @Override
    public String saveFormat() {
        StringBuilder strBuild = new StringBuilder(super.saveFormat());
        strBuild.append(";");
        for(int i = 0; i < doctors.size(); ++i){
            strBuild.append(doctors.get(i).getId());
            if(i != doctors.size() - 1)
                strBuild.append("%");
        }
        strBuild.append(";");
        for(int i = 0; i < nurses.size(); ++i){
            strBuild.append(nurses.get(i).getId());
            if(i != nurses.size() - 1)
                strBuild.append("%");
        }
        strBuild.append(";");
        for(int i = 0; i < patients.size(); ++i){
            strBuild.append(patients.get(i).getId());
            if(i != patients.size() - 1)
                strBuild.append("%");
        }
        strBuild.append(";E");
        return strBuild.toString();
    }
}