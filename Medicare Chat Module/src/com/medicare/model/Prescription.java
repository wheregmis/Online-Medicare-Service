/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.medicare.model;


public class Prescription {
    int id;
    String prescription, prescribedBy, prescribedFor;

    public Prescription(int id, String prescription, String prescribedBy, String prescribedFor) {
        this.id = id;
        this.prescription = prescription;
        this.prescribedBy = prescribedBy;
        this.prescribedFor = prescribedFor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrescription() {
        return prescription;
    }

    public void setPrescription(String prescription) {
        this.prescription = prescription;
    }

    public String getPrescribedBy() {
        return prescribedBy;
    }

    public void setPrescribedBy(String prescribedBy) {
        this.prescribedBy = prescribedBy;
    }

    public String getPrescribedFor() {
        return prescribedFor;
    }

    public void setPrescribedFor(String prescribedFor) {
        this.prescribedFor = prescribedFor;
    }
    
}
