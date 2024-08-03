/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.courseworkcsa.model;

/**
 *
 * @author User
 */
public class Doctor extends Person {
    
    private int doctorID;
    private String specialization;
    
    public Doctor() {
    // Default constructor
}

    public Doctor(String name, String contactInformation, String address, int doctorID, String specialization) {
        super(name, contactInformation, address);
        this.doctorID = doctorID;
        this.specialization = specialization;
    }

    // Getter and setter
    
    public int getDoctorId() {
        return doctorID;
    }

    public void setDoctorId(int doctorId) {
        this.doctorID = doctorId;
    }
    
    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
    
    
    
}
