package prg420_jessemorris_assignments;

import java.text.*;
import java.util.Locale;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Jesse D. Morris
 * @version 2.0
 * @course PRG420 Java Programming 1
 * @instructor James Kadlec
 * 
 * This class provides functionality for calculating an employee's commission 
 * earnings based on their reaching a predetermined sales quota 
 * 
 */
public class earningsCalculator
{ 
    //Declare salary variable
    private static int salary;
    //Declare the sales target
    private static int salesTarget;
    //Variable for the basic commission rate
    private static double commission;
    //Variable for the commission earned by the employee based on sales
    //and added to salary to determine total earnings.    
    private static double commEarned;
    //Variable for the employee's total yearly 
    //compensation with salary and commission
    private static double totalEarnings;
    
    public static void calculateEarnings(double sales)
    {   
     //Set salary to 50000
     salary = 50000;
     //Set salesTarget to 100000
     salesTarget = 100000;
     //Set commission equal to 5%
     commission = 0.05;

    //Calculate commission on reaching full sales target
    if(sales/salesTarget>=1.00)
    {
        commEarned = (sales * commission);
        totalEarnings = commEarned + salary;
        System.out.println();
        NumberFormat nF = NumberFormat.getCurrencyInstance(Locale.US);
        String yearlyEarnings = nF.format(totalEarnings);
        System.out.println("You have reached your full sales target.");
        System.out.println("You have earned: " + yearlyEarnings);
    }
    
   //Calculate commission on reaching 80% of sales target
   else if(sales/salesTarget>=0.80)
   {
     DecimalFormat D = new DecimalFormat("#.##%");
     commEarned = (sales * commission);
     totalEarnings = commEarned + salary;
     double percentOfTarget = (sales/salesTarget);
     NumberFormat nF = NumberFormat.getCurrencyInstance(Locale.US);
     String yearlyEarnings = nF.format(totalEarnings);
     System.out.println();
     System.out.println("You have reached " + D.format(percentOfTarget) 
             + " of your sales target"
             + " and will receive a commission.");
     System.out.println("You have earned: " + yearlyEarnings);
   }
        //Below minimum sales target to receive a commission
         else
         {
             totalEarnings = (double) salary;
             NumberFormat nF = NumberFormat.getCurrencyInstance(Locale.US);
             String yearlyEarnings = nF.format(totalEarnings);
             System.out.println();
             System.out.println("You have not reached your"
                     + " sales target, and will not receive"
                     + " a commission.");
             System.out.println("You have earned: " + yearlyEarnings);
         }
    
    
        NumberFormat nF = NumberFormat.getCurrencyInstance(Locale.US);
        String yearlyEarnings = nF.format(totalEarnings);
    }
    
    //Calculate earnings at and up to 150% above employee's current sales
    //and output a table for the user's reference.
    public static void potentialEarnings(double sales)
    {
        
        int tabEarnings = (int) sales;
        NumberFormat form = NumberFormat.getCurrencyInstance(Locale.US);
        
        if(sales/100000<0.80)
        {
            //System.exit(0);
        }
        else
        {
             System.out.println("Potential Earnings up to 150% of"
                    + " your current sales "
                    + "are contained in the table below.");
             System.out.println("*Note these totals are based"
                    + " on an accelerated "
                    + "commission of 6.25% starting at $100,000.00");
            while(tabEarnings<=sales*1.50)
            {
                if(sales/100000<1.00)
                {
                    commEarned=(tabEarnings * 0.05);
                    totalEarnings = commEarned + salary;
                    String possiblePay1 = form.format(tabEarnings);
                    String possiblePay2 = form.format(totalEarnings);
                    System.out.println("Sales: " + possiblePay1 + 
                        ";     " + "Employee Pay: " + possiblePay2);
                    tabEarnings+=5000;
                }
                else
                {
                    commEarned = (tabEarnings * 0.0625);
                    totalEarnings = commEarned + salary;            
                    String possiblePay1 = form.format(tabEarnings);
                    String possiblePay2 = form.format(totalEarnings);
                    System.out.println("Sales: " + possiblePay1 + 
                        ";     " + "Employee Pay: " + possiblePay2);
                    tabEarnings+=5000;
                }
            }
        }
    }
    
    /*compareEarnings method, designed to sort the elements in an ArrayList
     provided as an argument and then compare sales earnings between elements*/
    public void compareEarnings(ArrayList<Employee> sales)
    {
     NumberFormat nF = NumberFormat.getCurrencyInstance(Locale.US);
     Collections.sort(sales);
     
     System.out.println("Employees by sales in Descending order: ");
     for(int i=sales.size()-1;i>=0;--i)
      {
      System.out.println(sales.get(i).getEmployee() + 
              "; " + sales.get(i).getYearsSales());
      }
     for(int i=sales.size()-1;i>=0;--i)
     {   
     int most = sales.size()-1;
     if(i == most)
      {
      }
     Double diff=sales.get(most).getYearsSales() - sales.get(i).getYearsSales();
     System.out.println(sales.get(i).getEmployee() + " must sell at least " + 
           nF.format(diff)
           + " More to meet the sales of " + sales.get(most).getEmployee());
     }
    }
}
