
//package project222;

import java.util.*;

/**
*  @author grup15
*  HormoneTest Class
*/
@SuppressWarnings("serial")
public class HormoneTest extends Test
{
	private int tsh;
	private int lh;
	private int prolactin;
	private int cortisol;
	private int gh;
	private int t3;
	private int t4;

/**
*  Constructor For HormoneTest Class
*  @param patientID String 
*  @param date Date 
*/
	public HormoneTest(String patientID, Date date)
	{
		super(patientID, date);
		tsh = (int)(Math.random() * 100);
		lh = (int)(Math.random() * 100);
		prolactin = (int)(Math.random() * 100);
		cortisol = (int)(Math.random() * 100);
		gh = (int)(Math.random() * 100);
		t3 = (int)(Math.random() * 100);
		t4 = (int)(Math.random() * 100);
	}

	public HormoneTest()
	{
		super("", new Date());
	}

	public int getTSH()
	{
		return tsh;
	}

	public int getLH()
	{
		return lh;
	}

	public int getProlactin()
	{
		return prolactin;
	}

	public int getCortisol()
	{
		return cortisol;
	}

	public int getGH()
	{
		return gh;
	}

	public int getT3()
	{
		return t3;
	}

	public int getT4()
	{
		return t4;
	}

	public void setTSH(int tsh)
	{
		this.tsh = tsh;
	}

	public void setLH(int lh)
	{
		this.lh = lh;
	}

	public void setProlactin(int prolactin)
	{
		this.prolactin = prolactin;
	}

	public void setCortisol(int cortisol)
	{
		this.cortisol = cortisol;
	}

	public void setGH(int gh)
	{
		this.gh = gh;
	}

	public void setT3(int t3)
	{
		this.t3 = t3;
	}

	public void setT4(int t4)
	{
		this.t4 = t4;
	}

/**
*  toString Method For HormoneTest Class
*  @return String
*/
	public String toString()
	{
		return 	"HORMONE TEST RESULTS :\n"				
				+ "Date : " + getTestDate() + "\nPatient's ID : " + getPatientID()
				+ "\nTSH : " + String.valueOf(tsh)
				+ "\nLH : " + String.valueOf(lh)
				+ "\nProlactin : " + String.valueOf(prolactin)
				+ "\nCortisol : " + String.valueOf(cortisol)
				+ "\nT3 : " + String.valueOf(t3)
				+ "\nT4 : " + String.valueOf(t4);
	}

}