//Name Zafar Iqbal
//Student ID 1671637 ID
package EmployeeFiles;
public class Expenses extends Payroll implements ExpenseInterface
{
	
	double totalOperExpen=0;
	ExpenseImpl eimpl=new ExpenseImpl();
	
	public double getOperatingExpenses()
	{
		
		double OperExpen=eimpl.getOperatingExpenses();
		totalOperExpen+=OperExpen;
		return totalOperExpen;
		
	}	

	public void expenseType(String  type, double amount)
	{

		if(type.equals("material"))
		  eimpl.setMaterial(amount);
		else if(type.equals("rent"))
		  eimpl.setRent(amount);
		else if(type.equals("utilities"))
		  eimpl.setUtilities(amount);
		
	}

	public double getTotalExpenses()
	{
		double totalexpenses=totalSalaries()+totalOperExpen;
		
		
		return totalexpenses;
	}
}
