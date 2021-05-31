
package project222;

import java.util.*;
import java.io.Serializable;


/**
*  @author grup15
*  Test Abstract Class
*/
@SuppressWarnings("unchecked")
public abstract class Test
{
	private Date testDate;
	private String patientID;

/**
*  Getter Method For testDate
*  @return testDate Date
*/
	public Date getTestDate()
	{
		return testDate;
	}

/**
*  Getter Method For Patient's ID
*  @return String Patient's ID
*/
	public String getPatientID()
	{
		return patientID;
	}

	public void setPatientsID(String patientID)
	{
		this.patientID = patientID;
	}

	public void setTestDate(Date testDate)
	{
		this.testDate = testDate;
	}

/**
*  Constructor For Test Class
*  @param patientID String 
*  @param testDate Date 
*/
	public Test(String patientID, Date testDate)
	{
		this.testDate = testDate;
		this.patientID = patientID;
	}


}