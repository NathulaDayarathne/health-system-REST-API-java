/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.courseworkcsa.dao;

import com.mycompany.courseworkcsa.model.Patient;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class PatientDAO {
    
    private static List<Patient> patients = new ArrayList<>();

    static {
        patients.add(new Patient("John Doe", "0718943755", " no.78, hill Street, Colombo", 1, "Allergic to penicillin, history of asthma", "Stable" ));
        patients.add(new Patient("Peter Rodes", "0715443321", " no.23, Mel Street, Moratuwa", 2 ,"History of heart disease", "Critical" ));
        // Add more students as needed
    }

    public List<Patient> getAllPatients() {
        return patients;
    }

    public Patient getPatientById(int patientId) {
        for (Patient patient : patients) {
            if (patient.getPatientId() == patientId) {
                return patient;
            }
        }
        return null;
    }

    public void addPatient(Patient patient) {
        int newPatientId = getNextPatientId();
        patient.setPatientId(newPatientId);
        patients.add(patient);
    }

    public void updatePatient(Patient updatedPatient) {
        for (int i = 0; i < patients.size(); i++) {
            Patient patient = patients.get(i);
            if (patient.getPatientId() == updatedPatient.getPatientId()) {
                patients.set(i, updatedPatient);
                System.out.println("Patient updated: " + updatedPatient);
                return;
            }
        }
    }

    public void deletePatient(int id) {
        patients.removeIf(patient -> patient.getPatientId() == id);
    }
    
    public int getNextPatientId() {
        // Initialize maxUserId with a value lower than any possible userId
        int maxPatientId = Integer.MIN_VALUE;

        // Iterate through the list to find the maximum userId
        for (Patient patient : patients) {
            int patientId = patient.getPatientId();
            if (patientId > maxPatientId) {
                maxPatientId = patientId;
            }
        }

        // Increment the maximum userId to get the next available userId
        return maxPatientId + 1;
    }
    
}
