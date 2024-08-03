/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.courseworkcsa.model;

/**
 *
 * @author User
 */
public class Patient extends Person {
    private int patientID;
    private String medicalHistory;
    private String currentHealthStatus;
    
     public Patient() {
    // Default constructor
}
    public Patient(String name, String contactInformation, String address, int patientID, String medicalHistory, String currentHealthStatus) {
        super(name, contactInformation, address);
        this.patientID = patientID;
        this.medicalHistory = medicalHistory;
        this.currentHealthStatus = currentHealthStatus;
    }
    
     // Getters and setters
    public int getPatientId() {
        return patientID;
    }

    public void setPatientId(int patientId) {
        this.patientID = patientId;
    }
    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public String getCurrentHealthStatus() {
        return currentHealthStatus;
    }

    public void setCurrentHealthStatus(String currentHealthStatus) {
        this.currentHealthStatus = currentHealthStatus;
    }
}
