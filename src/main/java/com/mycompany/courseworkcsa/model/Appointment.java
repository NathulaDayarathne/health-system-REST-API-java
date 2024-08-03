/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.courseworkcsa.model;

/**
 *
 * @author User
 */
public class Appointment {
    
    private int appointmentID;
    private String appointmentDate;
    private Patient patient;
    private Doctor doctor;
    
    public Appointment() {
    }

    public Appointment(int appointmentID, String appointmentDate, Patient patient, Doctor doctor) {
        this.appointmentID = appointmentID;
        this.appointmentDate = appointmentDate;
        this.patient = patient;
        this.doctor = doctor;
    }

    // Getters and setters
    
    public int getAppointmentId() {
        return appointmentID;
    }

    public void setAppointmentId(int appointmentID) {
        this.appointmentID = appointmentID;
    }
    
    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }
    
    
}
