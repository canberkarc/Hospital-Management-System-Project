public class Lab extends Departments
{
	private final String name = "Lab";
	private ArrayList<LabPersonnel> labWorkers;
	private Queue<Patient> patientsToTest;
	private Stack<Test> testHistory;
	
	public String getName(){
		return this.name; 
	}

	public void addPatientToQueue(Patient p)
	{
	}

	public void addLabPersonnel(LabPersonnel l)
	{
	}

	public void addTest(Test t)
	{
	}

	Stack<Test> getTests()
	{
	}

	LabPersonnel getLabPersonnel(String id)
	{
	}

}
