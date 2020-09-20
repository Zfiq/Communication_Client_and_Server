//Name Zafar Iqbal
//Student ID 1671637
package EmployeeFiles;
public class Management extends Employee 
{
	private double weeklySalary=0.0;
	private double bonus=0.0;
	

	public Management()
	{
	}
	public Management(String nm, int ssn, double ws, double bn) 
	{

		super(nm, ssn);
		setWeeklySalary(ws);
		setBonus(bn);
	}

	public double getWeeklySalary()
	{
		return weeklySalary;
	}

	public double getBonus()
	{
		return bonus;
	}

	public void setWeeklySalary(double wsa)
	{
		weeklySalary=wsa;
	}

	public void setBonus(double bo)
	{
		bonus=bo;
	}

	public double compensation()
	{

		double salary=weeklySalary+bonus;
		return salary;

	}
	 public String toString()
	 {
	   String output;
	   output=super.toString()+"The weekly salary is:"+" "+weeklySalary+" "+"The bonus is"+" "+bonus;
	   return output;
	 }
}
