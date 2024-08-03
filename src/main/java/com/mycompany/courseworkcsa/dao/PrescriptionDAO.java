/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.courseworkcsa.dao;

import com.mycompany.courseworkcsa.model.Patient;
import com.mycompany.courseworkcsa.model.Prescription;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class PrescriptionDAO {
    
    private static List<Prescription> prescriptions = new ArrayList<>();

    static {
        Patient patient1 = new Patient("Saman Perera", "0718943755", " no.78, hill Street, Colombo", 1, "history1", "Good" );
        Patient patient2 = new Patient("James Silva", "072113321", " no.23, Mel Street, Moratuwa", 2 ,"history2", "Critical" );

        prescriptions.add(new Prescription(1, patient1, "sample medication", "sample dosage", "sample instructions", 13));
        prescriptions.add(new Prescription(2, patient2, "sample medication2", "sample dosage2", "sample instructions2", 20));
        prescriptions.add(new Prescription(3, patient1, "sample medication new", "sample dosage new", "sample instructions new", 10));
        // Add more modules as needed
    }

    public List<Prescription> getAllPrescriptions() {
        return prescriptions;
    }

    public Prescription getPrescriptionById(int prescriptionId) {
        for (Prescription prescription : prescriptions) {
            if (prescription.getPrescriptionId() == prescriptionId) {
                return prescription;
            }
        }
        return null;
    }

    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    public void updatePrescription(Prescription updatedPrescription) {
        for (int i = 0; i < prescriptions.size(); i++) {
            Prescription prescription = prescriptions.get(i);
            if (prescription.getPrescriptionId() == updatedPrescription.getPrescriptionId()) {
                prescriptions.set(i, updatedPrescription);
                return;
            }
        }
    }

    public void deletePrescription(int prescriptionId) {
        prescriptions.removeIf(module -> module.getPrescriptionId() == prescriptionId);
    }
    
    public List<Prescription> getPrescriptionsByPatientId(int patientId) {
        List<Prescription> patientPrescriptions = new ArrayList<>();
        for (Prescription prescription : prescriptions) {
            if (prescription.getPatient().getPatientId() == patientId) {
                patientPrescriptions.add(prescription);
            }
        }
        return patientPrescriptions;
    }
    
}
