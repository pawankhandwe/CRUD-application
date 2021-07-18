/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgmt.pojo;


public class Employee {
    public Employee()
    {
        
    }

    public Employee(int empid, String empname, double empsal) {
        this.empid = empid;
        this.empname = empname;
        this.empsal = empsal;
    }

    public int getEmpid() {
        return empid;
    }

    public void setEmpid(int empid) {
        this.empid = empid;
    }

    public String getEmpname() {
        return empname;
    }

    public void setEmpname(String empname) {
        this.empname = empname;
    }

    public double getEmpsal() {
        return empsal;
    }

    public void setEmpsal(double empsal) {
        this.empsal = empsal;
    }
    private int  empid;
    private  String empname;
    private double empsal;
    
    
}
