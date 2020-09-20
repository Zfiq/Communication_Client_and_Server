//Name Zafar Iqbal
//Student ID 1671637
package EmployeeFiles;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

public class CorporationTest {

    //Using Invokelater Runnable EDT Event Dispatch Thread  will put it on a queue.Another thread, the Event Dispatch Thread,
    //pops Runnables off that queue and invokes their run method.
    public static void main(String[] args) throws IOException {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                try {

                    ViewFrame viewFrame = new ViewFrame();

                } catch (IOException ex) {
                    Logger.getLogger(CorporationTest.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(CorporationTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        Expenses expense = new Expenses();
        expense.expenseType("material", 1000.00);
        expense.expenseType("rent", 800.00);
        expense.expenseType("utilities", 200.00);
        expense.outputEmployeeData();
        System.out.println("The sum of all salaries paid was:" + " " + expense.totalSalaries());
        System.out.println("The total operating expenses was" + " " + expense.getOperatingExpenses());
        System.out.println("The total of all expenses was" + " " + expense.getTotalExpenses());
        expense.expenseType("material", 300.00);
        expense.expenseType("rent", 500.00);
        expense.expenseType("utilities", 1200.00);
        System.out.println("The total operating expenses was" + " " + expense.getOperatingExpenses());
        System.out.println("The total of all expenses was" + " " + expense.getTotalExpenses());
    }
}
