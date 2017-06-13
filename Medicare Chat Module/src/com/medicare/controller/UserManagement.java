/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.medicare.controller;


import com.medicare.model.User;
import config.DatabaseConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author NCC
 */
public class UserManagement {
    
   private DatabaseConnection conn;
   private PreparedStatement pst;
    
    public UserManagement() {
         conn= new DatabaseConnection();
    }
    
    //geting all users
   public ArrayList<User> getAllUsers(){
        String query="select * from users";
        ResultSet rs = conn.selectData(query);
        ArrayList<User> data = new ArrayList<>();
        try {
            while (rs.next()) {
           User usr = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(6));
               data.add(usr);
            }
            
       } catch (SQLException sQLException) {
           sQLException.printStackTrace();
        }
        return data;
   }
   
   //getting user details
    public ArrayList<User> getUsersDetail(String username){
        String query="select * from user where username ='"+username+"'";
        
        ResultSet rs = conn.selectData(query);
        ArrayList<User> data = new ArrayList<>();
        try {
            while (rs.next()) {
          User usr = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getInt(6));
              data.add(usr);
            }
            
       } catch (SQLException sQLException) {
           sQLException.printStackTrace();
        }
        return data;
   }
   
 
  
  
  
  //inserting user
       public String insertData(User u){
            String sql;
            sql = "insert INTO users (user_name, user_username, user_password, user_email) "
                    + "Values('" + u.getName() + "','" + u.getUsername() + "','" + u.getPassword() + "',"
                    + "'" + u.getEmail() + "')";
            
            conn.insertData(sql);
           return sql;
            
}   
       //updating users
        public String updateData(User u){
            String sql;
            sql = "UPDATE `users` SET `user_name`= '"+u.getName()+"',`user_password`='"+u.getPassword()+"',"
                    + "`user_email`='"+u.getEmail()+"' WHERE "
                    + "`user_username` ='"+u.getUsername()+"' ";
            System.out.println(sql);
            
        
        
            conn.insertData(sql);
           return sql;
            
}   

      public void setLoginStatus(String username, String status){
            String sql;
            
            if (status.equals("Online")){
            sql = "UPDATE `user` SET `LOGINSTATUS`= 1 WHERE "
                    + "`username` ='"+username+"' ";
            System.out.println(sql);
            conn.insertData(sql);
            }
            else{
                     sql = "UPDATE `user` SET `LOGINSTATUS`= 0 WHERE "
                    + "`username` ='"+username+"' ";
            System.out.println(sql);
            conn.insertData(sql);
                    }
            
}   

    public ArrayList<User> getOnlineDoctors() {
      String query="select username from user where loginstatus=1 and usertypeid=2";
        ResultSet rs = conn.selectData(query);
        ArrayList<User> data = new ArrayList<>();
        try {
            while (rs.next()) {
          User usr = new User(rs.getString("username"));
              data.add(usr);
         
                System.out.println(rs.getString("username"));
            }
            
       } catch (SQLException sQLException) {
           sQLException.printStackTrace();
        }
        return data;
    }
       
    }
    

