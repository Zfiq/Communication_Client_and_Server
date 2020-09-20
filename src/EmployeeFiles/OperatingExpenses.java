//Name Zafar 
//Student ID 1671637
package EmployeeFiles;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class OperatingExpenses {

    private double material = 0.0;
    private double rent = 0.0;
    private double utilities = 0.0;

    public OperatingExpenses() {
        material = 100.00;
        rent = 100.00;
        utilities = 100.00;
    }

    public OperatingExpenses(double m, double r, double u) {
        material = m;
        rent = r;
        utilities = u;
    }

    public double getMaterial() {
        return material;
    }

    public double getRent() {
        return rent;
    }

    public double getUtilities() {
        return utilities;
    }

    public void setMaterial(double ma) {
        material = ma;
    }

    public void setRent(double re) {
        rent = re;
    }

    public void setUtilities(double ut) {
        utilities = ut;
    }
    public double OperatingExpensesForAllWeek() throws FileNotFoundException{
        //This method will calculate all the weekly Expenses values line by line.
        // Create an ArrayList of the WeeklyExpenses Class.
        double AddWeeklyExp = 0;
        ArrayList<WeeklyExpenses> WeeklyExpense = new ArrayList<WeeklyExpenses>();
        // Declare a File Object with file name.
        File file = new File("Expenses.txt");
        // Object of Scanner to read the lines.     
        Scanner scan = new Scanner(file);
        // used while loop to go through each line if next line exists.
        while (scan.hasNextLine()) {
            // Declare line as a String to read line.
            String line = scan.nextLine();
            //Create an Object of String Tokenizer to read next Token and to split line with Comma.
            StringTokenizer strtok = new StringTokenizer(line, ",");
            // Declare weekly Material as a String to asign it to nextToken similar method applies to other two String variables.
            String weeklyMaterail = strtok.nextToken();
            //Declared WM as Double to read double values from text file similar method applies to other two double variables.
            double WM = Double.parseDouble(weeklyMaterail);
            String weeklyRent = strtok.nextToken();
            double WR = Double.parseDouble(weeklyRent);
            String weeklyUtility = strtok.nextToken();
            double WU = Double.parseDouble(weeklyUtility);
            // Add all double variable to the ArrayList.
            WeeklyExpense.add(new WeeklyExpenses(WM, WR, WU));
            // Use for each loop to add all the double values from the Expenses.txt
            for (WeeklyExpenses AllWeeklyExp : WeeklyExpense) {
                // Asign AddWeeklyExp to AllWeeklyExp to sum all the double values. 
                AddWeeklyExp = AllWeeklyExp.getWeeklymaterialexpense() + AllWeeklyExp.getWeeklyrentexpense() + AllWeeklyExp.getWeeklyutilitiesexpense();
            }
            }
        return AddWeeklyExp;
     }

    public double totalOperatingExpenses() throws FileNotFoundException {
        //Similar method applyies here to get the total sum of all weekly expenses values than add it with totalOpExpenses for C12 Text Field. 
// Create an ArrayList of the WeeklyExpenses Class.
        double AddWeeklyExp = 0;
        ArrayList<WeeklyExpenses> WeeklyExpense = new ArrayList<WeeklyExpenses>();
        // Declare a File Object with file name.
        File file = new File("Expenses.txt");
        // Object of Scanner to read the lines.     
        Scanner scan = new Scanner(file);
        // used while loop to go through each line if next line exists.
        while (scan.hasNextLine()) {
            // Declare line as a String to read line.
            String line = scan.nextLine();
            //Create an Object of String Tokenizer to read next Token and to split line with Comma.
            StringTokenizer strtok = new StringTokenizer(line, ",");
            // Declare weekly Material as a String to asign it to nextToken similar method applies to other two String variables.
            String weeklyMaterail = strtok.nextToken();
            //Declared WM as Double to read double values from text file similar method applies to other two double variables.
            double WM = Double.parseDouble(weeklyMaterail);
            String weeklyRent = strtok.nextToken();
            double WR = Double.parseDouble(weeklyRent);
            String weeklyUtility = strtok.nextToken();
            double WU = Double.parseDouble(weeklyUtility);
            // Add all double variable to the ArrayList.
            WeeklyExpense.add(new WeeklyExpenses(WM, WR, WU));
            // Use for each loop to add all the double values from the Expenses.txt
            for (WeeklyExpenses AllWeeklyExp : WeeklyExpense) {
                // Asign AddWeeklyExp to AllWeeklyExp to sum all the double values. 
                AddWeeklyExp = AllWeeklyExp.getWeeklymaterialexpense() + AllWeeklyExp.getWeeklyrentexpense() + AllWeeklyExp.getWeeklyutilitiesexpense();
            }
            }
// Add the total of all weekly Expenses to the total Operationg Expenses and the total output from Expenses.txt is 26972.
// After adding the total to the current totalOpExpenses.
        double totalOpExpenses = material + rent + utilities + AddWeeklyExp;
        return totalOpExpenses;

    }

    public String toString() {

        String output;
        output = "The material exp is" + " " + material + " " + "The rent exp is" + " " + rent + " " + "The utilies exp is" + " " + utilities;
        return output;
    }

}
