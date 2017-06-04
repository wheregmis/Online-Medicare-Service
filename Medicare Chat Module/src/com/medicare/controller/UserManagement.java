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
          User usr = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(6));
               data.add(usr);
            }
            
       } catch (SQLException sQLException) {
           sQLException.printStackTrace();
        }
        return data;
   }
   
   //getting user details
    public ArrayList<User> getUsersDetail(String username){
        String query="select * from users where user_username ='"+username+"'";
        
        ResultSet rs = conn.selectData(query);
        ArrayList<User> data = new ArrayList<>();
        try {
            while (rs.next()) {
          User usr = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6));
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
            sql = "insert INTO users (user_name, user_username, user_password, user_email, user_address) "
                    + "Values('" + u.getName() + "','" + u.getUsername() + "','" + u.getPassword() + "',"
                    + "'" + u.getEmail() + "','" + u.getAddress() + "')";
            
            conn.insertData(sql);
           return sql;
            
}   
       //updating users
        public String updateData(User u){
            String sql;
            sql = "UPDATE `users` SET `user_name`= '"+u.getName()+"',`user_password`='"+u.getPassword()+"',"
                    + "`user_email`='"+u.getEmail()+"',`user_address`='"+u.getAddress()+"' WHERE "
                    + "`user_username` ='"+u.getUsername()+"' ";
            System.out.println(sql);
            
        
        
            conn.insertData(sql);
           return sql;
            
}   

    
       
    }
    

