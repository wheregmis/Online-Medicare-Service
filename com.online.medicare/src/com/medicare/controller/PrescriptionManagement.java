/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicare.controller;

import com.medicare.model.Appointment;
import com.medicare.model.Prescription;
import config.DatabaseConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class PrescriptionManagement {

    private DatabaseConnection conn;
  public PrescriptionManagement(){
  conn = new DatabaseConnection();
  }

    public void insertData(Prescription p) {
        String sql;
            sql = "insert INTO prescription (prescription, prescribedby, prescriptionfor) "
                    + "Values('"+p.getPrescription()+"','" +p.getPrescribedBy()+ "',"
                    + "'" +p.getPrescribedFor()+ "')";
            
            System.out.println(sql);
         //   conn.insertData(sql);
    }

    public ArrayList<Prescription> getAllPrescription(String Username, String usertype) {
      String query;
        if(usertype.equals("patient")){
                query="SELECT * FROM `prescription` WHERE prescriptionfor = '"+Username+"'";
        }
        else {
        query="SELECT * FROM `prescription` WHERE prescribedby = '"+Username+"'";
        }
        ResultSet rs = conn.selectData(query);
        System.out.println(query);
        ArrayList<Prescription> data = new ArrayList<>();
        try {
            while (rs.next()) {  
             Prescription usr = new Prescription(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
               data.add(usr);
            }
            
       } catch (SQLException sQLException) {
           sQLException.printStackTrace();
        }
        return data;  
    }

    public ArrayList<Prescription> getPrescriptionDeatil(int table_click) {
        String query;
        
                query="SELECT * FROM `prescription` WHERE prescriptionid = "+table_click;
        
        ResultSet rs = conn.selectData(query);
        System.out.println(query);
        ArrayList<Prescription> data = new ArrayList<>();
        try {
            while (rs.next()) {  
             Prescription usr = new Prescription(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4));
               data.add(usr);
            }
            
       } catch (SQLException sQLException) {
           sQLException.printStackTrace();
        }
        return data;  
    }
}