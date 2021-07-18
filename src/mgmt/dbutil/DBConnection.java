/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mgmt.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class DBConnection {
     public static Connection con;
     
    static
    {
    try
    {
     Class.forName("oracle.jdbc.OracleDriver");
    con=DriverManager.getConnection("jdbc:oracle:thin:@//localhost:1521/xe","myproject","java");

JOptionPane.showMessageDialog(null,"connection done sucessfully","sucess",JOptionPane.INFORMATION_MESSAGE);
    }catch(ClassNotFoundException e)
    {
        JOptionPane.showMessageDialog(null,"error in loading driver","error",JOptionPane.ERROR_MESSAGE);
     e.printStackTrace();
     System.exit(1);
    }catch(SQLException ex)
    {
        JOptionPane.showMessageDialog(null," error in opening connection","error",JOptionPane.ERROR_MESSAGE);
     ex.printStackTrace();
     System.exit(1);
    }
        
    }
    public static void closeConnection()
    {
        try
        {
            con.close();
             JOptionPane.showMessageDialog(null,"connection closed sucessfully","sucess",JOptionPane.INFORMATION_MESSAGE);
  
        }catch(SQLException e)
        {
            JOptionPane.showMessageDialog(null," error in closing connection","error",JOptionPane.ERROR_MESSAGE);
              e.printStackTrace();
        }
     }

   
    
}
