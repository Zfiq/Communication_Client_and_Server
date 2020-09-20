//Name Zafar Iqbal
//Student ID 1671637
package EmployeeFiles;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExpenseImpl extends OperatingExpenses implements ExpenseInterface
 {
	
	public double getOperatingExpenses()
	{

		double totalopexp=0;
            try {
                totalopexp = totalOperatingExpenses();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(ExpenseImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
		return totalopexp;
	}
}
