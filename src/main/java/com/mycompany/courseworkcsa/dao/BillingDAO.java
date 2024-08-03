/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.courseworkcsa.dao;

import com.mycompany.courseworkcsa.model.Billing;
import com.mycompany.courseworkcsa.model.Patient;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class BillingDAO {
    
     private static List<Billing> billings = new ArrayList<>();
     
      static {
        
        Patient patient1 = new Patient("Thomas Joe", "0718943755", " no.78, hill Street, Colombo", 1, "history1", "Good" );
        Patient patient2 = new Patient("Nathula", "072113321", " no.23, Mel Street, Moratuwa", 2 ,"history2", "Critical" );
        
        billings.add(new Billing(1, patient1, 15000, 50000));
        billings.add(new Billing(2, patient2, 5000, 35000));
        billings.add(new Billing(3, patient1, 7500, 60000));
        // Add more modules as needed
    }

    public List<Billing> getAllBillings() {
        return billings;
    }

    public Billing getBillingById(int billId) {
        for (Billing billing : billings) {
            if (billing.getBillId() == billId) {
                return billing;
            }
        }
        return null;
    }

    public void addBilling(Billing billing) {
        billings.add(billing);
    }

    public void updateBilling(Billing updatedBilling) {
        for (int i = 0; i < billings.size(); i++) {
            Billing billing = billings.get(i);
            if (billing.getBillId() == updatedBilling.getBillId()) {
                billings.set(i, updatedBilling);
                return;
            }
        }
    }

    public void deleteBilling(int billId) {
        billings.removeIf(billing -> billing.getBillId() == billId);
    }

    public List<Billing> getBillingsByPatientId(int patientId) {
        List<Billing> patientBillings = new ArrayList<>();
        for (Billing billing : billings) {
            if (billing.getPatient().getPatientId() == patientId) {
                patientBillings.add(billing);
            }
        }
        return patientBillings;
    }
    
}
