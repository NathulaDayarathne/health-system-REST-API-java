/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.courseworkcsa.model;

/**
 *
 * @author User
 */
public class MedicalRecord {
    
    private int medicalRecordID;
    private Patient patient;
    private String diagnoses;
    private String treatments;
    
    public MedicalRecord() {
    }

    public MedicalRecord(int medicalRecordID, Patient patient, String diagnoses, String treatments) {
        this.medicalRecordID = medicalRecordID;
        this.patient = patient;
        this.diagnoses = diagnoses;
        this.treatments = treatments;
    }

    // Getters and setters
    
    public int getMedicalRecordId() {
        return medicalRecordID;
    }

    public void setMedicalRecordId(int medicalRecordIdID) {
        this.medicalRecordID = medicalRecordIdID;
    }
    
    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDiagnoses() {
        return diagnoses;
    }

    public void setDiagnoses(String diagnoses) {
        this.diagnoses = diagnoses;
    }

    public String getTreatments() {
        return treatments;
    }

    public void setTreatments(String treatments) {
        this.treatments = treatments;
    }
    
    
    
}
