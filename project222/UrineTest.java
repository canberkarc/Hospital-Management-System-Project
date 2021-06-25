
//package project222;

import java.util.*;

/**
*  @author grup15
*  UrineTest Class
*/
@SuppressWarnings("unchecked")
public class UrineTest extends Test implements DatabaseComponent
{
	private int glucose;
	private int nitrites;
	private int bilirubin;
	private int protein;
	private int ketones;
	private int sugar;

/**
*  Constructor For UrineTest Class
*  @param patientID String 
*  @param date Date 
*/
	public UrineTest(String patientID, Date date)
	{
		super(patientID, date);
		glucose = (int)(Math.random() * 100);
		nitrites = (int)(Math.random() * 100);
		bilirubin = (int)(Math.random() * 100);
		protein = (int)(Math.random() * 100);
		ketones = (int)(Math.random() * 100);
		sugar = (int)(Math.random() * 100);
	}

	public UrineTest()
	{
		super("", new Date());
	}

	public int getGlucose()
	{
		return glucose;
	}

	public int getNitrites()
	{
		return nitrites;
	}

	public int getBilirubin()
	{
		return bilirubin;
	}

	public int getProtein()
	{
		return protein;
	}

	public int getKetones()
	{
		return ketones;
	}

	public int getSugar()
	{
		return sugar;
	}

	public void setGlucose(int glucose)
	{
		this.glucose = glucose;
	}

	public void setNitrites(int nitrites)
	{
		this.nitrites = nitrites;
	}

	public void setBilirubin(int bilirubin)
	{
		this.bilirubin = bilirubin;
	}

	public void setProtein(int protein)
	{
		this.protein = protein;
	}

	public void setKetones(int ketones)
	{
		this.ketones = ketones;
	}

	public void setSugar(int sugar)
	{
		this.sugar = sugar;
	}

/**
*  toString Method For UrineTest Class
*  @return String
*/
	public String toString()
	{
		return 	"URINE TEST RESULTS :\n"				
				+ "Date : " + getTestDate() + "\nPatient's ID : " + getPatientID()
				+ "\nGlucose : " + String.valueOf(glucose)
				+ "\nNitrites : " + String.valueOf(nitrites)
				+ "\nBilirubin : " + String.valueOf(bilirubin)
				+ "\nProtein : " + String.valueOf(protein)
				+ "\nKetones : " + String.valueOf(ketones)
				+ "\nSugar : " + String.valueOf(sugar);
	}

	@Override
	public String saveFormat() {
		StringBuilder strBuild = new StringBuilder();

		strBuild.append(getPatientID() + ";" + Company.dateToString(getTestDate()) + ";");
		strBuild.append("U" + ";");
		strBuild.append(getGlucose() + ";" + getNitrites() + ";" + getBilirubin() + ";" + getProtein() + ";" + getKetones() + ";" + getSugar());

		return strBuild.toString();
	}
}