/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.courseworkcsa.model;

/**
 *
 * @author User
 */
public class Billing {
    
    private int billID;
    private Patient patient;
    private double amountDue;
    private double amountPaid;
    
    public Billing() {
    }

    public Billing(int billID, Patient patient, double amountDue, double amountPaid) {
        this.billID = billID;
        this.patient = patient;
        this.amountDue = amountDue;
        this.amountPaid = amountPaid;
    }

    // Getters and setters
    public int getBillId() {
        return billID;
    }

    public void setBillId(int billId) {
        this.billID = billId;
    }
    
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public double getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(double amountDue) {
        this.amountDue = amountDue;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(double amountPaid) {
        this.amountPaid = amountPaid;
    }
}
