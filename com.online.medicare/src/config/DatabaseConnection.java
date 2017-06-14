/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import com.medicare.model.User;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class DatabaseConnection {

    
        ResultSet rs;

  // JDBC driver name and database URL
   private final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
   private final String DB_URL = "jdbc:mysql://localhost/online_medicare";
   
   

   //  Database credentials
   private final String USER = "root";
   private final String PASS = "";    

  private Connection conn ;
  private Statement stmt;
  private PreparedStatement pst;
  String sql;
    public DatabaseConnection() {
        try{
      //STEP 2: Register JDBC driver
      Class.forName("com.mysql.jdbc.Driver");

      //STEP 3: Open a connection
      System.out.println("Connecting to database...");
      conn = DriverManager.getConnection(DB_URL,USER,PASS);

      //STEP 4: Execute a query
      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      
      pst=conn.prepareStatement("select * from user where USERNAME=? and USERPASSWORD=?");
      
    }  catch (SQLException | ClassNotFoundException ex) {
        ex.printStackTrace();
       }
    }
  
  public ResultSet selectData(String sql) {

      System.out.println(sql);
       try {
           return stmt.executeQuery(sql);
           
       }
       
       catch (SQLException ex) {
           ex.printStackTrace();
           return null;
       }
      }
  
 
  
   
   public void insertData(String sql){
System.out.println(sql);
      try {
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException se2) {
            }// nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }//end finally try
        }//end try
        System.out.println("Goodbye!");
   }
  
   public boolean loginValidate(String username,String password){
        try {
                        
            pst.setString(1, username); //this replaces the 1st  "?" in the query for username
            pst.setString(2, password);    //this replaces the 2st  "?" in the query for password
            //executes the prepared statement
            rs = pst.executeQuery();
            if(rs.next())
            {
                //TRUE iff the query founds any corresponding data
                return true;
            }
            else
            {
                return false;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            System.out.println("error while validating"+e);
            return false;
        }
   }
  
  
    public static void main(String[] args)  {
        DatabaseConnection db = new DatabaseConnection();
        
    }

    public Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
  
}

