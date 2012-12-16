package prg420_jessemorris_assignments;

import java.util.Scanner;
import java.text.*;
import java.util.Locale;
import java.util.ArrayList;
import java.io.*;
/**
 *
 * @author Jesse D. Morris
 * @version 2.0
 * @course PRG420 Java Programming 1
 * @instructor James Kadlec
 * 
 * Main method for the application.  Handles accepting user input and
 * instantiating objects of the earningsCalculator class to 
 * act upon user input.
 * 
 **/

/*References:
 * 
 * MenuStub.java
 * @author James Kadlec
 * 
 */
public class courseAssignments
{
    
    //Declare variables to hold user input.
    static double employeeSales;
    static String employeeName;
    static ArrayList<Employee> employeeList = new ArrayList<Employee>();
    
    public static void main (String[] args) throws IOException
    {
        //Declare a variable to represent the menu options provided
        int selection;
        //Print program title
        System.out.println("Employee Earnings Calculator"); 
        //Display the menu while the user has not selected to close the program.
        do 
            {
            System.out.println();
            //Display instructions to the user
            System.out.print("Select a number from the menu options provided ");
            System.out.println("and then press the enter key.");
            System.out.println();
            //Print out menu options
            System.out.println("  1: Enter Employees");
            System.out.println("  2: Calculate Employee Earnings");
            System.out.println("  3: Compare Employee Earnings");
            System.out.println("  4: Exit");
            //Read input from the user to select menu option
            selection = (int)System.in.read();
            System.in.read();
                    //Switch statement to determine what actions are taken
                    //based on a particular menu selection
                    switch(selection)
                    {
                            case '1':enterEmployee();
                            break;
                            case '2':calculateEmployeeEarnings(employeeList);
                            break;
                            case '3':compareEarners();
                            break;
                            case '4':System.exit(0);
                            continue;
                            default:System.out.println("Invalid entry. " + 
                                    "Make another selection.");
                    }         
            }
            //Check to make sure the user hasn't attempted to exit
            while((selection != '4') && (selection != '4'));
            }
/*End of the main method.*/
    
        /**
        *  enterEmployee:   
        *  Requests input from the user and then creates and
        *  returns an ArrayList of employee objects to the main method.   
        **/       
        static ArrayList<Employee> enterEmployee()      
        {

                //Instantiate a new scanner object to accept user input.
                Scanner input = new Scanner(System.in);
                //Request the user input their name.
                System.out.print("Please enter your name:");
                //Read the name from the user
                employeeName = input.nextLine();
                //Request the user input their yearly sales totals.
                System.out.print("Please enter your yearly earnings:");
                //Check to ensure that the proper value is entered by the user.
                    while(!input.hasNextDouble())
                    {
                        System.out.println("Please enter a positive number "
                          + "for your yearly earnings.  Alphabetical characters"
                          + " will not be accepted.");
                            input.next();
                    }
                //Read sales from the user
                employeeSales = input.nextDouble();
                //Add values provided by the user to the employeeList.
                employeeList.add(new Employee(employeeName, employeeSales));

                return employeeList;

        }

        /**
        * calculateEmployeeEarnings:
        * Uses the employeeList ArrayList to call the earningsCalculator class
        * and the calculateEarnings() and potentialEarnings methods from that 
        * class to calculate the earnings for each employee in the list.
        * These method then display the employee earnings and a table
        * detailing their possible earnings up to and including
        * 150% of their sales.
        **/

        static void calculateEmployeeEarnings(ArrayList<Employee> employeeList)
        {
        //Loop through the employeeList and call
        //the calculateEarnings method to calculate total yearly pay
        //also call the potentialEarnings method to calculate potential pay.
        int count = employeeList.size();
        for(int i=0;i<count;i++)
        {
        //Print the employee's name for easy reference.
        System.out.println(employeeList.get(i).getEmployee());
        //Instantiate a new earningsCalculator object
        //to act on the user's input
        earningsCalculator calc = new earningsCalculator();
        //calculate actual employee's earnings
        calc.calculateEarnings(employeeList.get(i).getYearsSales());
        //Pad the output
        System.out.println();
        //calculate potential employee earnings
        earningsCalculator.potentialEarnings
                (employeeList.get(i).getYearsSales());
        //Pad the output
        System.out.println();
        }
        }   

        /**
        * 
        * compareEarners:
        * Calls the compareEarnings() method in the earningsCalculator class 
        * to sort the employeeList into Descending order.  
        * The compareEarnings() method then shows the differences in earnings
        * between the highest earning employee and each lower earning employee.
        * 
        **/

        static void compareEarners()      
        {         
            earningsCalculator calc = new earningsCalculator();

            calc.compareEarnings(employeeList);
        }
}