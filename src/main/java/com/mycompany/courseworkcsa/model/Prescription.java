/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.courseworkcsa.model;

/**
 *
 * @author User
 */
public class Prescription {
    
    private int prescriptionID;
    private Patient patient;
    private String medication;
    private String dosage;
    private String instructions;
    private int durationDays;
    
    public Prescription() {
    }

    public Prescription(int prescriptionID, Patient patient, String medication, String dosage, String instructions, int durationDays) {
        this.prescriptionID = prescriptionID;
        this.patient = patient;
        this.medication = medication;
        this.dosage = dosage;
        this.instructions = instructions;
        this.durationDays = durationDays;
    }

    // Getters and setters
    
    public int getPrescriptionId() {
        return prescriptionID;
    }

    public void setPrescriptionId(int prescriptionID) {
        this.prescriptionID = prescriptionID;
    }
    
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getMedication() {
        return medication;
    }

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public int getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(int durationDays) {
        this.durationDays = durationDays;
    }
    
    
    
}
