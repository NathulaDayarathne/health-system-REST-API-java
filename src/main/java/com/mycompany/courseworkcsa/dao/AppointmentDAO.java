/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.courseworkcsa.dao;
import com.mycompany.courseworkcsa.model.Patient;
import com.mycompany.courseworkcsa.model.Doctor;
import com.mycompany.courseworkcsa.model.Appointment;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class AppointmentDAO {
    
    private static List<Appointment> appointments = new ArrayList<>();

    static {
        Doctor doctor1 = new Doctor("Tim", "0719943755", " no.78, hill Street, Colombo", 1, "Cardiology" );
        Doctor doctor2 = new Doctor("Sarath", "0715433551", " no.23, Mel Street, Moratuwa", 2 ,"Psychology" );
        
        Patient patient1 = new Patient("Thomas Joe", "0718943755", " no.78, hill Street, Colombo", 1, "history1", "Good" );
        Patient patient2 = new Patient("Nathula", "072113321", " no.23, Mel Street, Moratuwa", 2 ,"history2", "Critical" );
        
        appointments.add(new Appointment(1, "2024-05-04", patient1, doctor1));
        appointments.add(new Appointment(2, "2024-08-21", patient2, doctor2));
        appointments.add(new Appointment(3, "2024-05-05", patient1, doctor2));
        // Add more modules as needed
    }
    
    public List<Appointment> getAllAppointments() {
        return appointments;
    }

    public Appointment getAppointmentById(int appointmentId) {
        for (Appointment appointment : appointments) {
            if (appointment.getAppointmentId() == appointmentId) {
                return appointment;
            }
        }
        return null;
    }

    public void addAppointment(Appointment appointment) {
        appointments.add(appointment);
    }

    public void updateAppointment(Appointment updatedAppointment) {
        for (int i = 0; i < appointments.size(); i++) {
            Appointment appointment = appointments.get(i);
            if (appointment.getAppointmentId() == updatedAppointment.getAppointmentId()) {
                appointments.set(i, updatedAppointment);
                return;
            }
        }
    }

    public void deleteAppointment(int appointmentId) {
        appointments.removeIf(module -> module.getAppointmentId() == appointmentId);
    }
    
    public List<Appointment> getAppointmentsByPatientId(int patientId) {
        List<Appointment> patientAppointments = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.getPatient().getPatientId() == patientId) { // Assuming there's a getPatient() method in Appointment class
                patientAppointments.add(appointment);
            }
        }
        return patientAppointments;
    }
    
    public List<Appointment> getAppointmentsByDoctorId(int doctorId) {
        List<Appointment> doctorAppointments = new ArrayList<>();
        for (Appointment appointment : appointments) {
            if (appointment.getDoctor().getDoctorId() == doctorId) {
                doctorAppointments.add(appointment);
            }
        }
        return doctorAppointments;
    }
    
}
