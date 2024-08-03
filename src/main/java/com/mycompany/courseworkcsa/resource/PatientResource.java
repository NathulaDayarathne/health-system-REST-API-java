/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.courseworkcsa.resource;

import java.util.List;
import javax.ws.rs.*;
import com.mycompany.courseworkcsa.model.Patient;
import com.mycompany.courseworkcsa.dao.PatientDAO;
import com.mycompany.courseworkcsa.dao.AppointmentDAO;
import com.mycompany.courseworkcsa.dao.BillingDAO;
import com.mycompany.courseworkcsa.dao.MedicalRecordDAO;
import com.mycompany.courseworkcsa.dao.PrescriptionDAO;
import com.mycompany.courseworkcsa.model.Appointment;
import com.mycompany.courseworkcsa.model.Billing;
import com.mycompany.courseworkcsa.model.MedicalRecord;
import com.mycompany.courseworkcsa.model.Prescription;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 * @author User
 */
@Path("/patients")
public class PatientResource {
    
    private static final Logger logger = LoggerFactory.getLogger(PatientResource.class);
    
    
    private PatientDAO patientDAO = new PatientDAO();
    private AppointmentDAO appointmentDAO = new AppointmentDAO();
    private MedicalRecordDAO medicalRecordDAO = new MedicalRecordDAO();
    private PrescriptionDAO prescriptionDAO = new PrescriptionDAO();
    private BillingDAO billingDAO = new BillingDAO();
    
    
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
//    public Response getAllPatients() {
//        try {
//            List<Patient> patients = patientDAO.getAllPatients();
//            return Response.ok(patients).build();
//        } catch (Exception e) {
//            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
//                    .entity("Error occurred: " + e.getMessage())
//                    .build();
//        }
//    }
    
    public Response getAllPatients() {
        try {
            List<Patient> patients = patientDAO.getAllPatients();
            logger.info("Retrieved all patients successfully");
            return Response.ok(patients).build();
        } catch (Exception e) {
            logger.error("Error occurred while retrieving all patients: {}", e.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error occurred: " + e.getMessage())
                    .build();
        }
    }

    @GET
    @Path("/{patientId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPatientById(@PathParam("patientId") int patientId) {
        try {
            Patient patient = patientDAO.getPatientById(patientId);
            if (patient != null) {
                return Response.ok(patient).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Patient not found with ID: " + patientId)
                        .build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error occurred: " + e.getMessage())
                    .build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPatient(Patient patient) {
    try {
        patientDAO.addPatient(patient);
        return Response.status(Response.Status.CREATED)
                .entity("Patient successfully added")
                .build();
    } catch (Exception e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Error occurred while adding a new patient: " + e.getMessage())
                .build();
    }
}

    @PUT
    @Path("/{patientId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePatient(@PathParam("patientId") int patientId, Patient updatedPatient) {
    try {
        Patient existingPatient = patientDAO.getPatientById(patientId);
        if (existingPatient != null) {
            updatedPatient.setPatientId(patientId);
            patientDAO.updatePatient(updatedPatient);
            return Response.ok()
                    .entity("Patient with ID: " + patientId + " successfully updated")
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Patient not found with ID: " + patientId + " for update")
                    .build();
        }
    } catch (Exception e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Error occurred while updating the patient: " + e.getMessage())
                .build();
    }
}

    @DELETE
    @Path("/{patientId}")
    public Response deletePatient(@PathParam("patientId") int patientId) {
        try {
            patientDAO.deletePatient(patientId);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error occurred: " + e.getMessage())
                    .build();
        }
    }
    
    
    @GET
    @Path("/{patientId}/appointments")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAppointmentsByPatientId(@PathParam("patientId") int patientId) {
        try {
            List<Appointment> appointments = appointmentDAO.getAppointmentsByPatientId(patientId);
            if (!appointments.isEmpty()) {
                return Response.ok(appointments).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("No appointments found for patient ID: " + patientId).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error occurred: " + e.getMessage()).build();
        }
    }
    
    
    @GET
    @Path("/{patientId}/medicalRecords")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getMedicalRecordsByPatientId(@PathParam("patientId") int patientId) {
        try {
            List<MedicalRecord> medicalRecords = medicalRecordDAO.getMedicalRecordsByPatientId(patientId);
            if (!medicalRecords.isEmpty()) {
                return Response.ok(medicalRecords).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("No medical records found for patient ID: " + patientId)
                        .build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error occurred: " + e.getMessage())
                    .build();
        }
    }
    
    @GET
    @Path("/{patientId}/prescriptions")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrescriptionsByPatientId(@PathParam("patientId") int patientId) {
        try {
            List<Prescription> prescriptions = prescriptionDAO.getPrescriptionsByPatientId(patientId);
            if (!prescriptions.isEmpty()) {
                return Response.ok(prescriptions).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("No prescriptions found for patient ID: " + patientId)
                        .build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error occurred: " + e.getMessage())
                    .build();
        }
    }
    
    @GET
    @Path("/{patientId}/billings")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBillingsByPatientId(@PathParam("patientId") int patientId) {
        try {
            List<Billing> billings = billingDAO.getBillingsByPatientId(patientId);
            if (!billings.isEmpty()) {
                return Response.ok(billings).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("No billings found for patient ID: " + patientId)
                        .build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error occurred: " + e.getMessage())
                    .build();
        }
    }









    
//    @GET
//    @Path("/{patientId}/modules")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getModulesForStudent(@PathParam("studentId") int studentId) {
//        Student student = studentDAO.getStudentById(studentId);
//
//        if (student != null) {
//            int moduleId = 1; // Assuming the student selected module with ID 1
//            Module selectedModule = moduleDAO.getModuleById(moduleId);
//
//            if (selectedModule != null) {
//                return "{\"module\": \"" + selectedModule.getName()
//                        + "\", \"teacher\": \"" + selectedModule.getTeacher().getName() + "\"}";
//            }
//        }
//
//        // Return an error message if the student or module is not found
//        return "{\"error\": \"Student or module not found\"}";
//    }
    
}
