//Name Zafar Iqbal
//Student ID 1671637
package EmployeeFiles;

/*This is a GUI client class to view the GUI frame.In this class Grid Bag Constraints is used to arrange
the GUI components.There are four sockets with different port number is used for each Button Actions. */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ViewFrame {
// Declare GUI swing components according to the project Design.

    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel(new GridBagLayout());
    private JLabel EMPLOYEES = new JLabel("EMPLOYEES");
    private String[] C1Combobox = {"Engineers", "Managers", "Administrative Personnel"};
    private JComboBox C1ComboBox = new JComboBox(C1Combobox);
    private JLabel C3label = new JLabel("Engineers Information");
    private JTextArea C3TextArea = new JTextArea(10, 35);
    private JLabel CompensationLabel = new JLabel();
    private JTextField C5TextField = new JTextField(15);
    private JButton C7Button = new JButton("Total Salary");
    private JTextField C8TextField = new JTextField(10);
    private JTextField C9TextField = new JTextField(10);
    private JButton C10Button = new JButton();
    private JLabel OPERATINGEXPENSES = new JLabel("OPERATING EXPENSES");
    private JButton C2Button = new JButton("Press For Display");
    private JTextField C4TextField = new JTextField(15);
    private JButton C11Button = new JButton();
    private JTextField C12TextField = new JTextField(10);
    private JLabel Client = new JLabel("Client");
    private JTextArea ClientTF = new JTextArea(1, 2);
    //IP number for ViewFrame GUI with port as localhost.
    int ip = 1110;
    String port = "localhost";
    //Declared Double variables outside ActionListener to sum all compensation.
    double SumComp1 = 0;
    double SumComp2 = 0;
    double SumComp3 = 0;
    double TotalOfAllEmpCompensation = 0;

    public ViewFrame() throws IOException, ClassNotFoundException {

// Create frame in the class Constructor along with GridBagConstraints to arrange all components.
        Socket FrameSocket = new Socket(port, ip);
        ObjectInputStream ClientIn = new ObjectInputStream(FrameSocket.getInputStream());
        ClientTF.setEditable(false);
        ClientTF.append(String.valueOf(ClientIn.readObject()));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //GUI frame Set size.
        frame.setSize(2000, 2000);
        //Set visibility to true 
        frame.setVisible(true);
//GUI contentPAne add to panel and move to west.
        frame.getContentPane().add(panel, BorderLayout.WEST);

//GridBagConstrains to arrange Components 
        GridBagConstraints c = new GridBagConstraints();
//////////////// SECTION ONE./////////////////////////

        // Employees Label
        c.insets = new Insets(-310, -600, 250, 50);  // Arrange JLabel Name Employees on Top Left to a small degree. 
// Add label and an Object of GridBagConstraints c to the panel.
        panel.add(EMPLOYEES, c);
// String Array values for ComboBox 
        c.gridx = 0;
        c.gridy = 10;
        c.insets = new Insets(-690, -600, 40, 50);  // Arrange ComboBox TOP LEFT 
        // Add ComboBox to panel along with c.
        panel.add(C1ComboBox, c);
// Arrange Text Area for C3 according to the project design.
        C3label.setPreferredSize(new Dimension(290, 20));
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(-200, -900, 250, 50);  // Arrange C3Text Area on the left side of the panel. 
        panel.add(C3label, c);
        C3TextArea.setLineWrap(true);
        C3TextArea.setEditable(false);
        c.insets = new Insets(-250, -600, 10, 50);  // 
        JScrollPane scroll = new JScrollPane(C3TextArea, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
//Scroll for C3Text Area add to panel.
        panel.add(scroll, c);

        // Compensation Label arrage at the bottom of C3 TextArea which is C5. 
        CompensationLabel.setText("Compensation");
        c.insets = new Insets(-50, -600, 10, 50);  // Arrange C5 TextFeild at the bottom of C3TextArea.
        // Compensation label add to panel.
        panel.add(CompensationLabel, c);
        C5TextField.setText("C5");
        c.insets = new Insets(-5, -600, 10, 50);
        //C5TextField add to panel
        panel.add(C5TextField, c);

        //////////////////SECTION TWO.////////////////////////
        // Operating Expenses Label for top right.
        c.insets = new Insets(-310, 700, 250, 50);
        panel.add(OPERATINGEXPENSES, c);
        // C2 Button Press for Display.
        C2Button.setPreferredSize(new Dimension(133, 25));
        c.insets = new Insets(-200, 700, 250, 50);  // Arrange JLabel Name Employees on Top Left. 
        panel.add(C2Button, c);
        // C4 TextField to Display values from Expenses.txt file.
        C4TextField = new JTextField(15);
        c.insets = new Insets(-140, 700, 250, 50);
        panel.add(C4TextField, c);

        //////////////////SECTION THREE.////////////////////////
        // Arrange C7 Button for Total Salary at the bottom. 
        c.insets = new Insets(200, -800, 10, 10);
        panel.add(C7Button, c);
        // Arrange C8 Text Field to display total salary after button is pressed.Position Bottom
        C8TextField.setText("C8");
        c.insets = new Insets(200, -500, 10, 50);
        panel.add(C8TextField, c);
        // C9 Text Field for Total Operating Expenses.
        c.insets = new Insets(200, -20, 10, 50);
        panel.add(C9TextField, c);
        // C10 Button to Display Total Operating Expenses.
        C10Button.setText("Total O.E.");
        c.insets = new Insets(200, -250, 10, 50);
        panel.add(C10Button, c);
        // C11 Button to Display Total Expenses.
        C11Button.setText("Total Expense");
        c.insets = new Insets(200, 250, 10, -220);
        panel.add(C11Button, c);
        // C12 Text Field.
        c.insets = new Insets(200, -20, 10, -780);
        panel.add(C12TextField, c);
        //Arrange Client Label on the top between Employee and OPERATINGEXPENSE. 
        c.insets = new Insets(-310, 150, 250, 50);
        panel.add(Client, c);
        //Set text field for client number.
        c.insets = new Insets(-310, 220, 250, 50);
        panel.add(ClientTF, c);
        // ComboBox add Action Listener
        C1ComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Start up a new thread so that our queries won't block the user interface.
                Thread C1Thread = new Thread() {
                    public void run() {
                        // If ActionListener object e sources equals to C1Combobox. 
                        if (e.getSource() == C1ComboBox) {
                            // If ComboBox selected value equals to Engineers show Engineers details from Server through Object Stream.
                            if (C1ComboBox.getSelectedItem().equals("Engineers")) {
                                String line = "";
                                //Thread delay for half a second.
                                try {
                                    Thread.sleep(500);
                                } catch (Exception ex) {
                                }
                                //Confirmation message once selected by using JOption Pane.
                                JOptionPane.showMessageDialog(null, "Engineers selected Please scroll to the bottom to view the new selected Employees");
                                // Try catch block for IO Exception
                                try {
                                    //Create a Socket using an ip as localhost and specific port number.
                                    Socket socket1 = new Socket("localhost", 1220);
                                    //Send an output to server through ObjectOutputStream as comboOut.
                                    ObjectOutputStream comboOut = new ObjectOutputStream(socket1.getOutputStream());
                                    //Send Get selected item from ComboBox from Client.
                                    comboOut.writeObject(C1ComboBox.getSelectedItem());
                                    //Receive data from employee.txt from Server through ObjectInputStream from server.
                                    ObjectInputStream comboIn = new ObjectInputStream(socket1.getInputStream());
                                    //Receive compensation for C5 TextField through Object Stream from server.
                                    ObjectInputStream Comp1 = new ObjectInputStream(socket1.getInputStream());
                                    //Receive Compensation for all employees to sum all.
                                    ObjectInputStream CompSum = new ObjectInputStream(socket1.getInputStream());
                                    //Assign Line and cast as a String to comboIn.readObject is not equals to null.
                                    //While loop of comboIn.readObject to go through all Engineer if exists.
                                    while ((line = (String) comboIn.readObject()) != null) {
                                        //C3TextField to display selected items.
                                        C3TextArea.append(String.valueOf(line));
                                        //C5TextField to display the compensation of selected employees.
                                        C5TextField.setText(String.valueOf(Comp1.readObject()));
                                        //Assign SumComp1 to Compensation for total.
                                        SumComp1 = (double) CompSum.readObject();
                                    }// end while.
                                } catch (IOException ex) {
                                    Logger.getLogger(ViewFrame.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (ClassNotFoundException ex) {
                                    Logger.getLogger(ViewFrame.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }//Using nested if condition if user selects Managers
                            else if (C1ComboBox.getSelectedItem().equals("Managers")) {
                                //Comfimation message through JOptionPane.
                                JOptionPane.showMessageDialog(null, "Managers selected Please scroll to the bottom to view the new selected Employees");
                                //Thread delay for half a second.
                                try {
                                    Thread.sleep(500);
                                } catch (Exception ex) {
                                }
                                //Try catch block for IO Exception it might throw an Exception.
                                try {
                                    //Using the same ip as localhost and port number.
                                    Socket socket1 = new Socket("localhost", 1220);
                                    //Send an output to server through ObjectOutputStream as ManOut.
                                    ObjectOutputStream ManOut = new ObjectOutputStream(socket1.getOutputStream());
                                    //Send Get selected item from ComboBox from Client to server.
                                    ManOut.writeObject(C1ComboBox.getSelectedItem());
                                    //Receive data from employee.txt from Server through ObjectInputStream.
                                    ObjectInputStream comboIn2 = new ObjectInputStream(socket1.getInputStream());
                                    //Receive compensation for C5 TextField through Object Stream from server.
                                    ObjectInputStream Comp2 = new ObjectInputStream(socket1.getInputStream());
                                    //Receive Compensation for all employees to sum all.
                                    ObjectInputStream CompSum = new ObjectInputStream(socket1.getInputStream());
                                    String line2 = "";
                                    //Assign Line and cast as a String to comboIn2.readObject is not equals to null.
                                    //While loop of comboIn2.readObject to go through all Manager if exists in the employee.txt.
                                    while ((line2 = (String) comboIn2.readObject()) != null) {
                                        //C3TextField to display selected items.
                                        C3TextArea.append(String.valueOf(line2));
                                        //C5TextField to display the compensation of selected employees.
                                        C5TextField.setText(String.valueOf(Comp2.readObject()));
                                        //Assign SumComp2 to Compensation for total.
                                        SumComp2 = (double) CompSum.readObject();
                                    }
                                } catch (IOException ex) {
                                    Logger.getLogger(ViewFrame.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (ClassNotFoundException ex) {
                                    Logger.getLogger(ViewFrame.class.getName()).log(Level.SEVERE, null, ex);
                                }

                            }//Nested if Condition if user selects Administrative Personnel.
                            else if (C1ComboBox.getSelectedItem().equals("Administrative Personnel")) {
                                //Comfimation message through JOptionPane.
                                JOptionPane.showMessageDialog(null, "Administrative Personnel selected");
                                //Thread delay for half a second.
                                try {
                                    Thread.sleep(500);
                                } catch (Exception ex) {
                                }
                                //Try catch block for IOException.
                                try {
                                    //Using the same ip as localhost and port number as 1200.
                                    Socket socket1 = new Socket("localhost", 1220);
                                    //Send an output to server through ObjectOutputStream as AdminOut.
                                    ObjectOutputStream AdminOut = new ObjectOutputStream(socket1.getOutputStream());
                                    //Send Get selected item from ComboBox from Client to server.
                                    AdminOut.writeObject(C1ComboBox.getSelectedItem());
                                    //Receive data from employee.txt from Server through ObjectInputStream.
                                    ObjectInputStream comboIn3 = new ObjectInputStream(socket1.getInputStream());
                                    //Receive compensation for C5 TextField through Object Stream from server.
                                    ObjectInputStream Comp3 = new ObjectInputStream(socket1.getInputStream());
                                    //Receive Compensation for all employees to sum all.
                                    ObjectInputStream CompSum = new ObjectInputStream(socket1.getInputStream());
                                    String line3 = "";
                                    //Assign Line and cast as a String to comboIn3.readObject and is not equals to null.
                                    //While loop of comboIn3.readObject to go through all Administrative Personnel if exists in the employee.txt.
                                    while ((line3 = (String) comboIn3.readObject()) != null) {
                                        //C3TextField to display selected items.
                                        C3TextArea.append(String.valueOf(line3));
                                        //C5TextField to display the compensation of selected employees.
                                        C5TextField.setText(String.valueOf(Comp3.readObject()));
                                        //Assign SumComp2 to Compensation for total.
                                        SumComp3 = (double) CompSum.readObject();
                                    }

                                } catch (IOException ex) {
                                    Logger.getLogger(ViewFrame.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (ClassNotFoundException ex) {
                                    Logger.getLogger(ViewFrame.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            }
                        }
                    }
                };
                //Start up C1Thread as a new thread so that our queries won't block the user interface.
                C1Thread.start();
            }
        });
//C2 Button as “Press for Display”
//When the user clicks the button, one of the lines per click from the file Expenses.txt appears on the JTextField component C4 one week at a time 
        C2Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Start up a new thread so it won't block the user interface.
                Thread C2ButtonThread = new Thread() {
                    public void run() {
                        //Try catch block for IO Exception.
                        try {
                            //Using separate socket with ip as localhost and port number as 1300.
                            Socket socket2 = new Socket("localhost", 1330);
                            //Send an output to server when the C2 button is pressed through ObjectOutputStream as C2out.
                            ObjectOutputStream C2out = new ObjectOutputStream(socket2.getOutputStream());
                            C2out.writeObject("C2");
                            //Receive data from Expenses.txt from Server through ObjectInputStream.
                            ObjectInputStream Perline = new ObjectInputStream(socket2.getInputStream());
                            //Read per line on click and diplay on C4TextFeild.
                            C4TextField.setText(String.valueOf(Perline.readObject()));
                            //Receive the sum of each line per click from server via ObjectStream..
                            ObjectInputStream SumPerLine = new ObjectInputStream(socket2.getInputStream());
                            //Once Received from server display sum per line from the Expenses.txt file and display on C5 TextField.
                            C5TextField.setText(String.valueOf(SumPerLine.readObject()));
                            //For test console display. 
                            ObjectInputStream C2in = new ObjectInputStream(socket2.getInputStream());
                            System.out.println("File OutPut " + C2in.readObject());

                        } catch (IOException ex) {
                            Logger.getLogger(ViewFrame.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(ViewFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }// end try catch.
                };// end thread
                //Start up C2Thread as a new thread so that our queries won't block the user interface.
                C2ButtonThread.start();
            }
        });
        //The total compensation for all employees should be displayed on JTextField C8 when the JButton C7 is pressed.
        //The label on the JButton is “Total Salaries”.
        C7Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//Assign TotalOfAllEmpCompensation double variable to all Sum Compensation.
                TotalOfAllEmpCompensation = SumComp1 + SumComp2 + SumComp3;
                System.out.println("Total Salary " + TotalOfAllEmpCompensation);
                C8TextField.setText(String.valueOf(TotalOfAllEmpCompensation));

            }
        });
        //The total Operating Expenses for all weeks is displayed on JTextField C9 when JButton C10 is pressed. The label on the JButton is “Total O. E.”
        C10Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Start a new Thread for C10Button so it won't block the user interface.
                Thread C10Thread = new Thread() {
                    public void run() {
                        //Try catch block for IO Exception.
                        try {
                            //Using separate socket with ip as localhost and port number as 1400.
                            Socket socket3 = new Socket("localhost", 1440);
                            //Sent response to server through ObjectStream when the C10Button is pressed.
                            ObjectOutputStream C10out = new ObjectOutputStream(socket3.getOutputStream());
                            C10out.writeObject("C10");
                            //Receive the Operating Expenses For All Week from the server through Input ObjectStream.
                            ObjectInputStream c10in = new ObjectInputStream(socket3.getInputStream());
                            //Once data received display on C9 TextField once button is pressed.
                            C9TextField.setText(String.valueOf(c10in.readObject()));
                        } catch (IOException ex) {
                            Logger.getLogger(ViewFrame.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(ViewFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                };
                //Start C10 Thread 
                C10Thread.start();
            }
        });
        //C11 Button as “Total Expenses” which will display the total expenses Operating Expenses for all weeks.
        C11Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Start a new Thread for C11Button so it won't block the user interface.
                Thread C11Thread = new Thread() {
                    public void run() {
                        //Try catch block for IO Exception.
                        try {
                            //Using separate socket with ip as localhost and port number as 1500.
                            Socket socket3 = new Socket("localhost", 1550);
                            //Sent response to server through ObjectStream when the C11Button is pressed.
                            ObjectOutputStream C11out = new ObjectOutputStream(socket3.getOutputStream());
                            C11out.writeObject("C11");
                            //Receive the total Operating Expenses For All Week from the server through Input ObjectStream.
                            ObjectInputStream C11in = new ObjectInputStream(socket3.getInputStream());
                            //Once data received display on C12 TextField once button is pressed.
                            C12TextField.setText(String.valueOf(C11in.readObject()));
                        } catch (IOException ex) {
                            Logger.getLogger(ViewFrame.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (ClassNotFoundException ex) {
                            Logger.getLogger(ViewFrame.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                };
                //Start C11 Button Thread 
                C11Thread.start();
            }
        });
    }
}
