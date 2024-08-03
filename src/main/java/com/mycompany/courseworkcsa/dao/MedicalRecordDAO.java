/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.courseworkcsa.dao;
import com.mycompany.courseworkcsa.model.Patient;
import com.mycompany.courseworkcsa.model.MedicalRecord;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class MedicalRecordDAO {
    
    private static List<MedicalRecord> medicalRecords = new ArrayList<>();
    
    static {
       
        Patient patient1 = new Patient("Saman", "0718943755", " no.78, hill Street, Colombo", 1, "history1", "Good" );
        Patient patient2 = new Patient("James", "072113321", " no.23, Mel Street, Moratuwa", 2 ,"history2", "Critical" );
        
        medicalRecords.add(new MedicalRecord(1, patient1, "Level 2 lung cancer", "Chemo-therapy"));
        medicalRecords.add(new MedicalRecord(2, patient2, "Bacterial Infection", "treating with Antibiotics"));
        medicalRecords.add(new MedicalRecord(3, patient1, "Virus Infection", "treating with Antibiotics"));
        // Add more modules as needed
    }
    
     public List<MedicalRecord> getAllMedicalRecords() {
        return medicalRecords;
    }

    public MedicalRecord getMedicalRecordById(int medicalRecordId) {
        for (MedicalRecord medicalRecord : medicalRecords) {
            if (medicalRecord.getMedicalRecordId() == medicalRecordId) {
                return medicalRecord;
            }
        }
        return null;
    }

    public void addMedicalRecord(MedicalRecord medicalRecord) {
        medicalRecords.add(medicalRecord);
    }

    public void updateMedicalRecord(MedicalRecord updatedMedicalRecord) {
        for (int i = 0; i < medicalRecords.size(); i++) {
            MedicalRecord medicalRecord = medicalRecords.get(i);
            if (medicalRecord.getMedicalRecordId() == updatedMedicalRecord.getMedicalRecordId()) {
                medicalRecords.set(i, updatedMedicalRecord);
                return;
            }
        }
    }

    public void deleteMedicalRecord(int medicalRecordId) {
        medicalRecords.removeIf(module -> module.getMedicalRecordId() == medicalRecordId);
    }
    
     public List<MedicalRecord> getMedicalRecordsByPatientId(int patientId) {
        List<MedicalRecord> patientMedicalRecords = new ArrayList<>();
        for (MedicalRecord medicalRecord : medicalRecords) {
            if (medicalRecord.getPatient().getPatientId() == patientId) {
                patientMedicalRecords.add(medicalRecord);
            }
        }
        return patientMedicalRecords;
    }
    
    
}
