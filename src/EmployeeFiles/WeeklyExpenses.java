//Name Zafar Iqbal
//Student ID 1671637
package EmployeeFiles;

/*This class contains instance variables constructor and getters and setters methods that will 
be used to retrieve the data from the Expenses.txt text file */
public class WeeklyExpenses {

    private double weeklymaterialexpense = 0.0;
    private double weeklyrentexpense = 0.0;
    private double weeklyutilitiesexpense = 0.0;

    public WeeklyExpenses(double weeklymaterialexpense, double weeklyrentexpense, double weeklyutilitiesexpense) {
        this.weeklymaterialexpense = weeklymaterialexpense;
        this.weeklyrentexpense = weeklyrentexpense;
        this.weeklyutilitiesexpense = weeklyutilitiesexpense;
    }

    public double getWeeklymaterialexpense() {
        return weeklymaterialexpense;
    }

    public void setWeeklymaterialexpense(double weeklymaterialexpense) {
        this.weeklymaterialexpense = weeklymaterialexpense;
    }

    public double getWeeklyrentexpense() {
        return weeklyrentexpense;
    }

    public void setWeeklyrentexpense(double weeklyrentexpense) {
        this.weeklyrentexpense = weeklyrentexpense;
    }

    public double getWeeklyutilitiesexpense() {
        return weeklyutilitiesexpense;
    }

    public void setWeeklyutilitiesexpense(double weeklyutilitiesexpense) {
        this.weeklyutilitiesexpense = weeklyutilitiesexpense;
    }

    public String ToString() {
        String WeeklyExpenseOutput = "WeeklyMaterialExpense" + weeklymaterialexpense + "WeeklyRentExpense" + weeklyrentexpense + "WeeklyUtilitiesExpense" + weeklyutilitiesexpense;
        return WeeklyExpenseOutput;
    }
}
