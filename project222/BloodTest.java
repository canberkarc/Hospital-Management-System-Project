import java.util.*;

//package project222;

/**
*  @author grup15
*  BloodTest Class
*/
@SuppressWarnings("serial")
public class BloodTest extends Test
{
	private String bloodType;
	private String rH;
	private int vitaminB;
	private int vitaminD;
	private int vitaminA;
	private int vitaminE;
	private int hemoglobin;
	private int potassium;
	private int calcium;

/**
*  Constructor For BloodTest Class
*  @param patientID String 
*  @param date Date 
*/	
	public BloodTest(String patientID, Date date)
	{
		super(patientID, date);
		vitaminB = (int)(Math.random() * 100);
		vitaminD = (int)(Math.random() * 100);
		vitaminA = (int)(Math.random() * 100);
		vitaminE = (int)(Math.random() * 100);
		hemoglobin = (int)(Math.random() * 100);
		potassium = (int)(Math.random() * 100);
		calcium = (int)(Math.random() * 100);

		int bloodT = (int)(Math.random() * 4);
		int rhT = (int)(Math.random() * 2);
		if(bloodT == 1)	bloodType = "0";
		else if(bloodT == 2)	bloodType = "A";
		else if(bloodT == 3)	bloodType = "B";
		else 	bloodType = "AB";

		if(rhT == 1)	rH = "+";
		else rH = "-";
	}

	public BloodTest()
	{
		super("", new Date());
	}

	public String getBloodType()
	{
		return bloodType;
	}

	public String getRH()
	{
		return rH;
	}

	public int getVitaminB()
	{
		return vitaminB;
	}

	public int getVitaminD()
	{
		return vitaminD;
	}

	public int getVitaminA()
	{
		return vitaminA;
	}

	public int getVitaminE()
	{
		return vitaminE;
	}

	public int getHemoglobin()
	{
		return hemoglobin;
	}

	public int getPotassium()
	{
		return potassium;
	}

	public int getCalcium()
	{
		return calcium;
	}

	public void setBloodType(String bloodType)
	{
		this.bloodType = bloodType;
	}

	public void setRH(String rH)
	{
		this.rH = rH;
	}

	public void setVitaminB(int vitaminB)
	{
		this.vitaminB = vitaminB;
	}

	public void setVitaminD(int vitaminD)
	{
		this.vitaminD = vitaminD;
	}

	public void setVitaminA(int vitaminA)
	{
		this.vitaminA = vitaminA;
	}

	public void setVitaminE(int vitaminE)
	{
		this.vitaminE = vitaminE;
	}

	public void setHemoglobin(int hemoglobin)
	{
		this.hemoglobin = hemoglobin;
	}

	public void setPotassium(int potassium)
	{
		this.potassium = potassium;
	}

	public void setCalcium(int calcium)
	{
		this.calcium = calcium;
	}

/**
*  toString Method For BloodTest Class
*  @return String
*/
	public String toString()
	{
		return 	"BLOOD TEST RESULTS :\n"				
				+ "Date : " + getTestDate() + "\nPatient's ID: " + getPatientID()
				+ "\nBlood Type : " + bloodType + " rH : " + rH
				+ "\nVitamin-A : " + String.valueOf(vitaminA)
				+ "\nVitamin-B : " + String.valueOf(vitaminB)
				+ "\nVitamin-D : " + String.valueOf(vitaminD)
				+ "\nVitamin-E : " + String.valueOf(vitaminE)
				+ "\nHemoglobin : " + String.valueOf(hemoglobin)
				+ "\nPotassium : " + String.valueOf(potassium)
				+ "\nCalcium : " + String.valueOf(calcium);
	}

}