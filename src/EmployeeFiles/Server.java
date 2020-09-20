//Name Zafar iqbal
//Student ID 1671637
package EmployeeFiles;

/* This Server class contains different static classes Including Server to recieve response from the client side and to recored
the connection responses multiple times by incrementing when new window or connection opens.
This class also has static classes that exdents Thread separatly and there are 5 different sockets to listen
to the port number from GUI ViewFrame class each button Actions */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server {
//When this server class starts it should give a message in console.

    static class Server2 extends Thread {
//An Integer Client that will count the connection very time when new client is open.

        int Client = 0;

        public void run() {
            //Try catch for IO Exception.
            try {
// An Object of Server socket to get the port number from client.
                ServerSocket sock = new ServerSocket(1110);
//Using while to run this connection multiple times.
while(true){
                //Accept ViewFrame socket.
                Socket FSocket = sock.accept();
                //Increment connection.
                Client++;
                // Message to print in console when it connects successfully.
                System.out.println("Client Connected to server..." + Client);
                //Send the Client counts to ViewFrame Client class via ObjectOutputStream to print as Client 1,Client 2,Client 3...

                ObjectOutputStream clientOut = new ObjectOutputStream(FSocket.getOutputStream());
                clientOut.writeObject(Client);
}
            } catch (IOException ex) {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }// end Try
// Separate static class that exteds Thread for Combobox.

        static class Run1 extends Thread {

            ObjectInputStream in = null;

            public void run() {

//Delay the thread for half a second with separate try catch block.
                try {
                    Thread.sleep(500);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
                //Try catch for IO Exception.
                try {
                    //Get port number from Client ComboBox 
                    ServerSocket socket1 = new ServerSocket(1220);
                    //Set while as true to run this socket multiple times.
                    while (true) {
                        //Accept socket as s1.
                        Socket s1 = socket1.accept();
                        //Confirmation message to print on console once this connection is connected.
                        System.out.println("Server connected to ComboBox...");
                        //Receive an Object stream from client.
                        in = new ObjectInputStream(s1.getInputStream());
                        //Assign an Object as o to ObjectInputStream.
                        Object o = (String) in.readObject();
                        //Confirmation message on console once received from the client side.
                        System.out.println("Server Recived " + o);
                        //Object output Stream to send the Text file data.
                        ObjectOutputStream out = new ObjectOutputStream(s1.getOutputStream());
                        //Object output Stream to send Compensation for all employees.
                        ObjectOutputStream Comp = new ObjectOutputStream(s1.getOutputStream());
                        //Object output Stream to send Compensation for all employees to sum all compensation for C8 total salary.
                        ObjectOutputStream CompSum = new ObjectOutputStream(s1.getOutputStream());
//Read file using Scanner.
                        File file = new File("employee.txt");
                        Scanner scan = new Scanner(file);
                        //If the Object o recieves from ComboBox and equals to Engineers.
                        if (o.equals("Engineers")) {
                            //Get the details of Engineers only from the text file.     
                            while (scan.hasNextLine()) {
                                String line = scan.nextLine();
                                //use String Tokenizer to get specific line by line from employee.txt. 
                                StringTokenizer StTok = new StringTokenizer(line, ",");
                                //Declare String emp and assign it to StringTokenizer nextToken();.
                                String emp = StTok.nextToken();
                                // StringTokenizer emp if Engineer exists in the employee file.
                                if (emp.equals("Engineer")) {
                                    //Retrive the names, SocialSecurity as an Integer,WeeklySalary as ws double.
                                    String name = StTok.nextToken();
                                    //Convert String ssstr into an Integer by assigning SS to Integer parseInt
                                    //It will return an Integer object.
                                    String ssstr = StTok.nextToken();
                                    int ss = Integer.parseInt(ssstr);
                                    //Convert String wsstr into double ws by assigning ws to double parseDouble.
                                    String wsstr = StTok.nextToken();
                                    double ws = Double.parseDouble(wsstr);
                                    String yestr = StTok.nextToken();
                                    //Create an Object of Engineer Class that will take aurgument in constructor.
                                    Engineer engineer = new Engineer(name, ss, ws, 0);
                                    // Send Engineer details through ObjectOutputStream.
                                    out.writeObject(engineer.getName() + "\n" + "SocialSecurityNummber " + engineer.getSS() + "\n" + "ID " + engineer.getID() + "\tSalary " + engineer.getWeeklySalary() + "\n");
                                    //Send Compensation through ObjectOutputStream.
                                    Comp.writeObject(engineer.compensation());
                                    //The total compensation for all employees send through CompSum ObjectOutputStream.
                                    CompSum.writeObject(engineer.compensation() + engineer.getWeeklySalary());
                                }//end if
                            }//end while
                        } //Using nested if condition if Object o recieves Managers from ComboBox. 
                        else if (o.equals("Managers")) {
                            //If Managers is selected from the ComboBox then scan the file using while loop along with similar method as previous.
                            while (scan.hasNextLine()) {
                                String line = scan.nextLine();
                                StringTokenizer StTok = new StringTokenizer(line, ",");
                                String emp = StTok.nextToken();
                                //Retrive the values of Manager from the employee.txt file by assigning variales to next Token.
                                if (emp.equals("Manager")) {
                                    //To get values from the employee.txt line by line.
                                    //Strinig name that will read String names from employees.txt
                                    String name = StTok.nextToken();
                                    //Convert ssstr into an Integer ss parseInt. 
                                    String ssstr = StTok.nextToken();
                                    int ss = Integer.parseInt(ssstr);
                                    //Convert wsstr String into double ws and assign it to Double parseDouble. 
                                    String wsstr = StTok.nextToken();
                                    double ws = Double.parseDouble(wsstr);
                                    //Convert bonusstr String into double bonus and assign it to Double parseDouble.
                                    String bonusstr = StTok.nextToken();
                                    double bonus = Double.parseDouble(bonusstr);
                                    //call an Object of a class Management that will take four arguments.
                                    Management man = new Management(name, ss, ws, bonus);
                                    //Send Manager details through ObjectOutputStream.
                                    out.writeObject("...........................................\n" + man.getName() + "\n" + "SocialSecurityNummber " + man.getSS() + "\n" + "ID " + man.getID() + "\tSalary " + man.getWeeklySalary() + "\n");
                                    //Send Manager Compensation via ObjectOutputStream.
                                    Comp.writeObject(man.compensation() + man.getBonus());
                                    //The total compensation for all employees send through CompSum ObjectOutputStream.
                                    CompSum.writeObject(man.compensation() + man.getBonus());
                                }// end if
                            } // end while
                            // Nested if condition.
                        }//Using nested if condition if Object o recieves Administrative Personnel from ComboBox.
                        else if (o.equals("Administrative Personnel")) {
                            //If Administrative Personnel is selected from the ComboBox then scan the file using while loop.
                            while (scan.hasNextLine()) {
                                //Declare line as a String to read each line and assign it to scan nextLine.
                                String line = scan.nextLine();
                                //Using StringTokenizer which will take two parameters line and a comma separator.
                                StringTokenizer StTok = new StringTokenizer(line, ",");
                                //Delare emp as a String and assign it to StTok next Token.
                                String emp = StTok.nextToken();
                                // If the employee file equals to AdministrativePersonnel.
                                if (emp.equals("AdministrativePersonnel")) {
                                    // Then retrive the names as a String,SS as an Integer,rate as a double,hours as a double.
                                    String name = StTok.nextToken();
                                    //Convert String into an Integer
                                    String ssstr = StTok.nextToken();
                                    int ss = Integer.parseInt(ssstr);
                                    //Convert String ratestr into double rate.
                                    String ratestr = StTok.nextToken();
                                    double rate = Double.parseDouble(ratestr);
                                    String hoursstr = StTok.nextToken();
                                    double hours = Double.parseDouble(hoursstr);
                                    AdministrativePersonnel adminp = new AdministrativePersonnel(name, ss, rate, hours);
                                    //Send Manager details through ObjectOutputStream.
                                    out.writeObject("...........................................\n" + adminp.getName() + "\n" + "SocialSecurityNummber " + adminp.getSS() + "\n" + "ID " + adminp.getID() + "\n");
                                    //Send Manager Compensation via ObjectOutputStream.
                                    Comp.writeObject(adminp.compensation() + adminp.getRate() + adminp.getHours());
                                    //The total compensation for all employees send through CompSum ObjectOutputStream.
                                    CompSum.writeObject(adminp.compensation() + adminp.getHours() + adminp.getRate());
                                }// end if
                            }// end while
                        } // end if else
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
//Separate static class that extends thread for C2 button.

        static class Run2 extends Thread {
//Declare count as an Integer to get number of clicks.

            int count = 0;

            public void run() {
                //Try catch for IO Exception.
                try {
//Get the connection to listen to a specific port number.
                    ServerSocket socket2 = new ServerSocket(1330);
// Set while as true to listen to the socket multiple times.
                    while (true) {
//Accept the socket to get response.
                        Socket s2 = socket2.accept();
                        //Declare an Ingetger to print line if its equals to count button clicks. 
                        int linenumber = 0;
                        //If the ObjectInputStream recives button response.
                        ObjectInputStream c7in = new ObjectInputStream(s2.getInputStream());
                        System.out.println("C2 Received " + c7in.readObject());
//Increment count each time button is clicked.  
                        count++;
                        //To test the button response it should give an output in console.
                        System.out.println("C2 Received " + count);
//Use BufferedReader to read the Expenses text file with FileReader as an aurgument.
                        BufferedReader br = new BufferedReader(new FileReader("expenses.txt"));
                        String line = null;
// while loop to go through all lines.
                        while ((line = br.readLine()) != null) {
// Increment line by one inside the loop.
                            linenumber++;
// If linenumber is equals to click count then read each line with the clicks. 
                            if (linenumber == count) {
                                //Make an arraylist to store all the lines from Expenses file.
                                ArrayList<String> TextLines = new ArrayList<String>();
                                // Declare a File Object with file name.
                                File file = new File("Expenses.txt");
                                // Object of Scanner to read the lines.  
                                Scanner scan2 = new Scanner(file);
                                // used while loop to go through each line if next line exists.
                                while (scan2.hasNextLine()) {
                                    // Declare line2 as a String to read lines separatly.
                                    String line2 = scan2.nextLine();
                                    //Create an Object of String Tokenizer to read next Token and to split line with Comma.
                                    StringTokenizer StTokn = new StringTokenizer(line, ",");
                                    // Declare weekly Material as a String to asign it to nextToken similar method applies to other two String variables.
                                    String weeklyMaterail = StTokn.nextToken();
//double variables is to retrive the double values from the text file through NextToken();
                                    double WM = Double.parseDouble(weeklyMaterail);
                                    //Declared WM as Double to read double values from text file similar method applies to other two double variables.
                                    String weeklyRent = StTokn.nextToken();
                                    double WR = Double.parseDouble(weeklyRent);
                                    String weeklyUtility = StTokn.nextToken();
                                    double WU = Double.parseDouble(weeklyUtility);
                                    //Sum each line separately. 
                                    double SumEachLine = 0;
                                    SumEachLine = WM + WR + WU;
                                    // Add all line to the ArrayList.
                                    TextLines.add(line);
                                    //Declare an object of ObjectOutputStream as ReadPerline to send the array data to the client.
                                    ObjectOutputStream ReadPerline = new ObjectOutputStream(s2.getOutputStream());
                                    ReadPerline.writeObject(TextLines);
                                    //Declare an object of ObjectOutputStream as SumPerLine to send the sum of each line to the client.
                                    ObjectOutputStream SumPerline = new ObjectOutputStream(s2.getOutputStream());
                                    SumPerline.writeObject(SumEachLine);
                                    // To read the lines again when the clicks count reaches to line number 10.
                                    // If count clicks equals to 10 then set the count to zero to read the first line again from the text file.
                                    if (count == 10) {
                                        count = 0;
                                    }//end if
                                } //end while
                            }//end if
                        }//end while
                    }
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        }
//Separate static class extends thread for C10 button.

        static class Run3 extends Thread {

            public void run() {

                try {
                    //Get the connection to listen to a specific port number.
                    ServerSocket socket3 = new ServerSocket(1440);
                    // Set while as true to listen to the socket multiple times.
                    while (true) {
                        //Accept the socket to get response.
                        Socket s3 = socket3.accept();
// After reciving button response via ObjectInputStream.
                        ObjectInputStream C10In = new ObjectInputStream(s3.getInputStream());
                        String o = (String) C10In.readObject();
                        //Show message on the console C10 response.
                        System.out.println("C10 Received " + o);
// ObjectOutputStream to send the total of Operating Expenses for all week as an object.
                        ObjectOutputStream C10out = new ObjectOutputStream(s3.getOutputStream());
                        //Object of OperatingExpenses class to get Operating Expenses For All Week.
                        OperatingExpenses op = new OperatingExpenses();
                        // Send Operating Expenses For All week via Object output stream.
                        C10out.writeObject(op.OperatingExpensesForAllWeek());

                    }
                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
//Separate static class extends thread for C11 button.

        static class Run4 extends Thread {

            public void run() {
                try {
                    //Get the connection to listen to a specific port number.
                    ServerSocket socket4 = new ServerSocket(1550);
                    // Set while as true to listen to the socket multiple times.
                    while (true) {
                        //Accept the socket s4 to get response.
                        Socket s4 = socket4.accept();
                        ObjectInputStream C11In = new ObjectInputStream(s4.getInputStream());
                        String o = (String) C11In.readObject();
                        //When response is received from C11 button it should print the message on the console.
                        System.out.println("C11 Received " + o);
                        //Object of an OperatingExpenses class to get total of Operating Expenses.
                        OperatingExpenses op = new OperatingExpenses();
                        ObjectOutputStream C11out = new ObjectOutputStream(s4.getOutputStream());
                        // Send an Object.
                        C11out.writeObject(op.totalOperatingExpenses());
                    }

                } catch (IOException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
// Main method to call an Object of Server class and an Object thread class.

        public static void main(String[] args) {
            // Declare an objects of the class.
            Server2 ser = new Server2();
            Run1 r1 = new Run1();
            Run2 r2 = new Run2();
            Run3 r3 = new Run3();
            Run4 r4 = new Run4();
            //Start all threads 
            ser.start();
            r1.start();
            r2.start();
            r3.start();
            r4.start();
        }
    }
}
