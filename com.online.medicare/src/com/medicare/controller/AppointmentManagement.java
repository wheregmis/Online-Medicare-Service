/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicare.controller;

import com.medicare.model.Appointment;
import com.medicare.model.User;
import config.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Xawbeen Regmi
 */
public class AppointmentManagement {

    
    private DatabaseConnection conn;
    public AppointmentManagement() {
        
        conn = new DatabaseConnection();
    }
    
    
    
    
    
    public ArrayList<Appointment> getAllAppointments(String username, String usertype) {
      String query;
        if(usertype.equals("doctor")){
                query="SELECT * FROM `appointment` WHERE APPOINTMENTBY = '"+username+"'";
        }
        else {
        query="SELECT * FROM `appointment` WHERE APPOINTMENTFOR = '"+username+"'";
        }
        ResultSet rs = conn.selectData(query);
        System.out.println(query);
        ArrayList<Appointment> data = new ArrayList<>();
        try {
            while (rs.next()) {  
             Appointment usr = new Appointment(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
               data.add(usr);
            }
            
       } catch (SQLException sQLException) {
           sQLException.printStackTrace();
        }
        return data;  
        
    }
    
     public ArrayList<Appointment> getOwnAppointment(String username) {
      
        String query="SELECT * FROM `appointment` WHERE APPOINTMENTBY = '"+username+"'";
        ResultSet rs = conn.selectData(query);
        System.out.println(query);
        ArrayList<Appointment> data = new ArrayList<>();
        try {
            while (rs.next()) {  
             Appointment usr = new Appointment(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
               data.add(usr);
            }
            
       } catch (SQLException sQLException) {
           sQLException.printStackTrace();
        }
        return data;  
        
    }

    public void insertData(String Username, String table_click) {
        String sql;
            sql = "insert INTO appointment (appointmenttitle, appointmenttime, appointmentfor, appointmentby) "
                    + "Values('','','" +Username+ "',"
                    + "'" +table_click+ "')";
            
           // System.out.println(sql);
            conn.insertData(sql);
          
    }
    
    //inserting user
      
       //updating users
        public String updateData(int appointmentid, String appointmenttitle, String appointmenttime){
            String sql;
            sql = "UPDATE `appointment` SET `appointmenttitle`= '"+appointmenttitle+"',`appointmenttime`='"+appointmenttime+"' where appointmentid = "+appointmentid;
            System.out.println(sql);
            
        
        
            conn.insertData(sql);
           return sql;
            
}   

    public ArrayList<Appointment> getAppointmentDetail(int appointmentid) {
        String query="SELECT * FROM `appointment` WHERE APPOINTMENTID = "+appointmentid+"";
        ResultSet rs = conn.selectData(query);
        System.out.println(query);
        ArrayList<Appointment> data = new ArrayList<>();
        try {
            while (rs.next()) {  
             Appointment usr = new Appointment(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
               data.add(usr);
            }
            
       } catch (SQLException sQLException) {
           sQLException.printStackTrace();
        }
        return data;  
    }
}


