/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicare.model;


public class Appointment {
    
    int id;
    String appointmentTitle, appointmentFor, appointmentBy, appointmentTime;

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public Appointment(int id, String appointmentTitle, String time, String appointmentFor,String appointmentBy) {
        this.id = id;
        this.appointmentTime = time;
        this.appointmentTitle = appointmentTitle;
        this.appointmentFor = appointmentFor;
        this.appointmentBy = appointmentBy;
    }

    public Appointment(int id, String appointmentTitle, String time, String appointmentBy) {
       this.id = id;
       this.appointmentTime = time;
        this.appointmentTitle = appointmentTitle;
        this.appointmentBy = appointmentBy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAppointmentTitle() {
        return appointmentTitle;
    }

    public void setAppointmentTitle(String appointmentTitle) {
        this.appointmentTitle = appointmentTitle;
    }

    public String getAppointmentFor() {
        return appointmentFor;
    }

    public void setAppointmentFor(String appointmentFor) {
        this.appointmentFor = appointmentFor;
    }

    public String getAppointmentBy() {
        return appointmentBy;
    }

    public void setAppointmentBy(String appointmentBy) {
        this.appointmentBy = appointmentBy;
    }
    
}
