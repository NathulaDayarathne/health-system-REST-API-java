/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.courseworkcsa.dao;

import com.mycompany.courseworkcsa.model.Doctor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class DoctorDAO {
    
    private static List<Doctor> doctors = new ArrayList<>();

    static {
        doctors.add(new Doctor("Tom", "0719943755", " no.78, hill Street, Colombo", 1, "Cardiology" ));
        doctors.add(new Doctor("Sam", "071555551", " no.23, Mel Street, Moratuwa", 2 ,"Psychology" ));
        // Add more students as needed
    }

    public List<Doctor> getAllDoctors() {
        return doctors;
    }

    public Doctor getDoctorById(int doctorId) {
        for (Doctor doctor : doctors) {
            if (doctor.getDoctorId() == doctorId) {
                return doctor;
            }
        }
        return null;
    }

    public void addDoctor(Doctor doctor) {
        int newDoctorId = getNextDoctorId();
        doctor.setDoctorId(newDoctorId);
        doctors.add(doctor);
    }

    public void updateDoctor(Doctor updatedDoctor) {
        for (int i = 0; i < doctors.size(); i++) {
            Doctor doctor = doctors.get(i);
            if (doctor.getDoctorId() == updatedDoctor.getDoctorId()) {
                doctors.set(i, updatedDoctor);
                System.out.println("Doctor updated: " + updatedDoctor);
                return;
            }
        }
    }

    public void deleteDoctor(int id) {
        doctors.removeIf(doctor -> doctor.getDoctorId() == id);
    }
    
    public int getNextDoctorId() {
        // Initialize maxUserId with a value lower than any possible userId
        int maxDoctorId = Integer.MIN_VALUE;

        // Iterate through the list to find the maximum userId
        for (Doctor doctor : doctors) {
            int doctorId = doctor.getDoctorId();
            if (doctorId > maxDoctorId) {
                maxDoctorId = doctorId;
            }
        }

        // Increment the maximum userId to get the next available userId
        return maxDoctorId + 1;
    }
    
}
    

