/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package prg420_jessemorris_assignments;

/**
 *
 * @author Jesse
 */
public class Employee implements Comparable
{
    
    private String employeeName;
    private double yearSales;
    
    public Employee(String employeeName, double yearSales)
    {
        this.employeeName = employeeName;
        this.yearSales = yearSales;
    }
    
    public void setName(String employeeName)
    {
        this.employeeName=employeeName;
    }
    
    public void setSales(Double yearSales)
    {
        this.yearSales=yearSales;
    }
    
    public String getEmployee()
    {
        return employeeName;
    }
    
    public Double getYearsSales()
    {
        return yearSales;
    }

    boolean compareTo(double yearsSales) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public int compareTo(Object arg0) 
    {
      return this.getYearsSales().compareTo(((Employee) arg0).getYearsSales());
    }
}