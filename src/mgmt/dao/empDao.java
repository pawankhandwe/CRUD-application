/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgmt.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import static mgmt.dbutil.DBConnection.con;
import mgmt.pojo.Employee;

/**
 *
 * @author HP
 */
public class empDao {

    
    
    public static boolean addEmployee(Employee e)throws SQLException
    {
        
       
       PreparedStatement ps=con.prepareStatement("insert into employees values(?,?,?)");
       ps.setInt(1, e.getEmpid());
       ps.setString(2,e.getEmpname());
       ps.setDouble(3,e.getEmpsal());
       int result=ps.executeUpdate();
       if(result==1)
           return true;
       return false;
       
       
       
        
    }
    public static Employee findEmployee(int empno)throws SQLException
    {
        
        PreparedStatement ps=con.prepareStatement("select * from employees where empno=?");
        ps.setInt(1, empno);
        ResultSet rs=ps.executeQuery();
        Employee e=null;
        if(rs.next())
        {
            e=new Employee();
        e.setEmpid(rs.getInt(1));
        e.setEmpname(rs.getString(2));
        e.setEmpsal(rs.getDouble(3));
        
        
     }
            return e;
        
    }
    public static ArrayList<Employee> getAllEmployee()throws SQLException
    {
       
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery("select * from employees order by empno");
        ArrayList<Employee>empList=new ArrayList<>();
         while(rs.next())
        {
          Employee  e=new Employee();
        e.setEmpid(rs.getInt(1));
        e.setEmpname(rs.getString(2));
        e.setEmpsal(rs.getDouble(3));
        empList.add(e);
        
     }
        
         return empList;
        
    }
    public static boolean deleteEmployee(int empno)throws SQLException
    {  
         
        
         PreparedStatement ps=con.prepareStatement("delete from employees where empno=?");
         
        ps.setInt(1, empno);
        ResultSet rs=ps.executeQuery();
        Employee e;
        e=empDao.findEmployee(empno);
            if(e==null)
            return true;
                
            return false;
               
             
        
                
      }
     public static boolean updateEmployee(int empno,String empname,double empsal)throws SQLException
     {
         
          PreparedStatement ps=con.prepareStatement("update  employees set ename=?,sal=?where empno=? ");
       ps.setString(1,empname);
       ps.setDouble(2,empsal);
       ps.setInt(3, empno);
       int result=ps.executeUpdate();
       if(result==1)
         
       return true;
       
      return false;
       
       
        
       
          
      }
    
    
}
