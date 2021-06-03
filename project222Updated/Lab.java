
package project222;

import java.io.*;
import java.lang.*;
import java.util.*;
import java.text.SimpleDateFormat;

/**
*  @author grup15
*  Lab Class
*/
public class Lab extends Departments
{
	private final String name = "Lab";
	private Queue <Patients> patientsToTest;
	private Stack <Test> testHistory;

/**
*  Constructor For Lab Class
*  @param id int 
*/
	public Lab(int id)
	{
		super(id);
		patientsToTest = new ArrayDeque<Patients>();
		testHistory = new Stack<Test>();
		readFromTheFile();
	}

        
/**
*  Getter Method For patientsToTest
*  @return patientsToTest Queue <Patients> 
*/
	public Queue <Patients> getPatientsToTest()
	{
		return patientsToTest;
	}

/**
*  Getter Method For patientsToTest
*  @return testHistory Stack <Test> 
*/
	public Stack <Test> getTestHistory()
	{
		return testHistory;
	}

	public void addPatient(Patients p)
	{
		patientsToTest.offer(p);
	}

/**
*  Adds input labPersonnel to the Queue
*  @param labPersonnel LabPersonnel
*/
	public void addLabPersonnel(LabPersonnel labPersonnel)
	{
		getWorkers().add(labPersonnel);
	}

/**
*  Gets the i'th labPersonnel from the Queue
*  @return i'th labPersonnel HospitalWorkers
*/
	HospitalWorkers getLabPersonnel(int i)
	{
		if(i < 0 || i >= getWorkers().size())	throw new IndexOutOfBoundsException();

		return getWorkers().get(i);
	}

	@SuppressWarnings("unchecked")
	public void readFromTheFile()
	{
		try
		{
			String line = "";  
			String splitBy = ";";  
			BufferedReader br = new BufferedReader(new FileReader("tests.txt"));  
			while ((line = br.readLine()) != null)   
			{ 
				String[] temp = line.split(splitBy); 	

				if(temp[0].equals("BLOODTEST") == true)
				{	
						
					BloodTest tempTest = new BloodTest();
					tempTest.setPatientsID(temp[1]);
					try 
					{		
						SimpleDateFormat formatter5 = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss"); 
						Date date5=formatter5.parse(temp[2]);   
						tempTest.setTestDate(date5); 
					}
					catch(Exception E){}

					tempTest.setBloodType(temp[3]);
					tempTest.setRH(temp[4]);
					tempTest.setVitaminB(Integer.parseInt(temp[5]));
					tempTest.setVitaminD(Integer.parseInt(temp[6]));
					tempTest.setVitaminA(Integer.parseInt(temp[7]));
					tempTest.setVitaminE(Integer.parseInt(temp[8]));
					tempTest.setHemoglobin(Integer.parseInt(temp[9]));
					tempTest.setPotassium(Integer.parseInt(temp[10]));
					tempTest.setCalcium(Integer.parseInt(temp[11]));
					testHistory.add(tempTest);
				}
				else if(temp[0].equals("HORMONETEST") == true)
				{	
						
					HormoneTest tempTest = new HormoneTest();
					tempTest.setPatientsID(temp[1]);
					try 
					{		
						SimpleDateFormat formatter5 = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss"); 
						Date date5=formatter5.parse(temp[2]);   
						tempTest.setTestDate(date5); 
					}
					catch(Exception E){}

					tempTest.setTSH(Integer.parseInt(temp[3]));
					tempTest.setLH(Integer.parseInt(temp[4]));
					tempTest.setProlactin(Integer.parseInt(temp[5]));
					tempTest.setCortisol(Integer.parseInt(temp[6]));
					tempTest.setGH(Integer.parseInt(temp[7]));
					tempTest.setT3(Integer.parseInt(temp[8]));
					tempTest.setT4(Integer.parseInt(temp[9]));
					testHistory.add(tempTest);
				}
				else if(temp[0].equals("URINETEST") == true)
				{	
						
					UrineTest tempTest = new UrineTest();
					tempTest.setPatientsID(temp[1]);
					try 
					{		
						SimpleDateFormat formatter5 = new SimpleDateFormat("E, MMM dd yyyy HH:mm:ss"); 
						Date date5=formatter5.parse(temp[2]);   
						tempTest.setTestDate(date5); 
					}
					catch(Exception E){}

					tempTest.setGlucose(Integer.parseInt(temp[3]));
					tempTest.setNitrites(Integer.parseInt(temp[4]));
					tempTest.setBilirubin(Integer.parseInt(temp[5]));
					tempTest.setProtein(Integer.parseInt(temp[6]));
					tempTest.setKetones(Integer.parseInt(temp[7]));
					tempTest.setSugar(Integer.parseInt(temp[8]));
					testHistory.add(tempTest);
				}

			}
			br.close();
		}
			catch(IOException e){}
    
	}

	public String printTestHistory()
	{
            String res = "";
		int length = testHistory.size();

		if(length == 0)	
		{
			res+=("THERE IS NO TEST IN THE HISTORY");
			return res;
		}
		for(int i = 0; i < length; i++)
		{
			res+=(testHistory.pop()+"\n");
		}
		return res;
	}

}