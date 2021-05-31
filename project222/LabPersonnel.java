import java.io.*;
import java.lang.*;
import java.util.*;

/**
*  @author grup15
*  LabPersonnel Class
*/
public class LabPersonnel extends HospitalWorkers
{

/**
*  Constructor For LabPersonnel Class
*  @param name String 
*  @param surname String 
*  @param id String
*  @param dateOfBirth Date
*/	
	public LabPersonnel(String name, String surname, String id, Date dateOfBirth) 
	{
        super(name, surname, id, dateOfBirth);
    }

/**
*  Prints the Patients Waiting To Be Tested.
*  @param patientsToTest Queue <Patients>
*/
	public boolean displayWaitingPatients(Queue <Patients> patientsToTest)
	{
		Patients temp;
		int length = patientsToTest.size(); 

		if(length == 0)
		{
			System.out.println("THERE IS NO PATIENTS IN THE QUEUE");
			return false;
		}
		else
		{
			for(int i = 0; i < length; i++)
			{
				temp = patientsToTest.poll();
				patientsToTest.offer(temp);
				System.out.println(temp);
			}
			return true;
		}
	}

/**
*  Creates a new BloodTest Object
*  @param p Patients
*  @return Test BloodTest
*/
	public Test makeBloodTest(Patients p)
	{	
		Test temp = new BloodTest(p.getId(), new Date());
		return temp;
	}

/**
*  Creates a new HormoneTest Object
*  @param p Patients
*  @return Test HormoneTest
*/
	public Test makeHormoneTest(Patients p)
	{	
		Test temp = new HormoneTest(p.getId(), new Date());
		return temp;
	}

/**
*  Creates a new UrineTest Object
*  @param p Patients
*  @return Test UrineTest
*/
	public Test makeUrineTest(Patients p)
	{	
		Test temp = new UrineTest(p.getId(), new Date());
		return temp;
	}

/**
*  Polls the first Patient in the Queue and makes BloodTest
*  @param patientsToTest Queue <Patients>
*  @param testHistory Stack <Test>
*/
	public boolean makeBloodTestToNextPatient(Queue <Patients> patientsToTest, Stack <Test> testHistory) 
	{
		if(patientsToTest.size() == 0)
		{
			System.out.println("THERE IS NO PATIENTS IN THE QUEUE");
	 		return false;
		}
		else
		{
			Test temp = makeBloodTest(patientsToTest.poll());
			writeToTheFile(temp);
			testHistory.push(temp);
			System.out.println("MADE TEST TO THE FIRST PATIENT IN THE QUEUE");
			return true;
		}	
	}

/**
*  Polls the first Patient in the Queue and makes HormoneTest
*  @param patientsToTest Queue <Patients>
*  @param testHistory Stack <Test>
*/
	public boolean makeHormoneTestToNextPatient(Queue <Patients> patientsToTest, Stack <Test> testHistory)
	{
		if(patientsToTest.size() == 0)
		{
			System.out.println("THERE IS NO PATIENTS IN THE QUEUE");
	 		return false;
		}
		else
		{
			Test temp = makeHormoneTest(patientsToTest.poll());
			writeToTheFile(temp);
			testHistory.push(temp);
			System.out.println("MADE TEST TO THE FIRST PATIENT IN THE QUEUE");
			return true;
		}	
	}

/**
*  Polls the first Patient in the Queue and makes UrineTest
*  @param patientsToTest Queue <Patients>
*  @param testHistory Stack <Test>
*/
	public boolean makeUrineTestToNextPatient(Queue <Patients> patientsToTest, Stack <Test> testHistory)
	{
		if(patientsToTest.size() == 0)
		{
			System.out.println("THERE IS NO PATIENTS IN THE QUEUE");
	 		return false;
		}
		else
		{
			Test temp = makeUrineTest(patientsToTest.poll());
			writeToTheFile(temp);
			testHistory.push(temp);
			System.out.println("MADE TEST TO THE FIRST PATIENT IN THE QUEUE");
			return true;
		}	
	}	

	public void writeToTheFile(Test test)
	{
		try
		{	
			FileWriter fileWritter = new FileWriter("tests.txt",true);
			if(test instanceof BloodTest)
			{	
				BloodTest temp = (BloodTest) test;
				fileWritter.write("BLOODTEST;");				
				fileWritter.write(temp.getPatientID() + ";");				
				fileWritter.write(temp.getTestDate() + ";");				
				fileWritter.write(temp.getBloodType() + ";");
				fileWritter.write(temp.getRH() + ";");
				fileWritter.write(temp.getVitaminB() + ";");
				fileWritter.write(temp.getVitaminD() + ";");
				fileWritter.write(temp.getVitaminA() + ";");
				fileWritter.write(temp.getVitaminE() + ";");
				fileWritter.write(temp.getHemoglobin() + ";");
				fileWritter.write(temp.getPotassium() + ";");
				fileWritter.write(temp.getCalcium() + ";\n");		
			}
			else if(test instanceof HormoneTest)
			{	
				HormoneTest temp = (HormoneTest) test;
				fileWritter.write("HORMONETEST;");
				fileWritter.write(temp.getPatientID() + ";");				
				fileWritter.write(temp.getTestDate() + ";");				
				fileWritter.write(temp.getTSH() + ";");
				fileWritter.write(temp.getLH() + ";");
				fileWritter.write(temp.getProlactin() + ";");
				fileWritter.write(temp.getCortisol() + ";");
				fileWritter.write(temp.getGH() + ";");
				fileWritter.write(temp.getT3() + ";");
				fileWritter.write(temp.getT4() + ";\n");		
			}
			else if(test instanceof UrineTest)
			{	
				UrineTest temp = (UrineTest) test;
				fileWritter.write("URINETEST;");
				fileWritter.write(temp.getPatientID() + ";");				
				fileWritter.write(temp.getTestDate() + ";");				
				fileWritter.write(temp.getGlucose() + ";");
				fileWritter.write(temp.getNitrites() + ";");
				fileWritter.write(temp.getBilirubin() + ";");
				fileWritter.write(temp.getProtein() + ";");
				fileWritter.write(temp.getKetones() + ";");
				fileWritter.write(temp.getSugar() + ";\n");		
			}
			fileWritter.close();
		}
		catch(IOException e){} 	
		catch (Exception e) {}
	
	
	}

}