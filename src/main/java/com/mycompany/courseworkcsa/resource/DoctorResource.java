/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.courseworkcsa.resource;

import com.mycompany.courseworkcsa.dao.AppointmentDAO;
import com.mycompany.courseworkcsa.dao.DoctorDAO;
import com.mycompany.courseworkcsa.model.Appointment;
import com.mycompany.courseworkcsa.model.Doctor;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author User
 */

@Path("/doctors")
public class DoctorResource {
    
    private DoctorDAO doctorDAO = new DoctorDAO();
    private AppointmentDAO appointmentDAO = new AppointmentDAO();
    
    
     @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllDoctors() {
        try {
            List<Doctor> doctors = doctorDAO.getAllDoctors();
            return Response.ok(doctors).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error occurred: " + e.getMessage())
                    .build();
        }
    }

    @GET
    @Path("/{doctorId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getDoctorById(@PathParam("doctorId") int doctorId) {
        try {
            Doctor doctor = doctorDAO.getDoctorById(doctorId);
            if (doctor != null) {
                return Response.ok(doctor).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Doctor not found with ID: " + doctorId)
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
    public Response addDoctor(Doctor doctor) {
    try {
        doctorDAO.addDoctor(doctor);
        return Response.status(Response.Status.CREATED)
                .entity("Doctor successfully added")
                .build();
    } catch (Exception e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Error occurred while adding a new doctor: " + e.getMessage())
                .build();
    }
}

    @PUT
    @Path("/{doctorId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateDoctor(@PathParam("doctorId") int doctorId, Doctor updatedDoctor) {
    try {
        Doctor existingDoctor = doctorDAO.getDoctorById(doctorId);
        if (existingDoctor != null) {
            updatedDoctor.setDoctorId(doctorId);
            doctorDAO.updateDoctor(updatedDoctor);
            return Response.ok()
                    .entity("Doctor with ID: " + doctorId + " successfully updated")
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Doctor not found with ID: " + doctorId + " for update")
                    .build();
        }
    } catch (Exception e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Error occurred while updating the doctor: " + e.getMessage())
                .build();
    }
}

    @DELETE
    @Path("/{doctorId}")
    public Response deleteDoctor(@PathParam("doctorId") int doctorId) {
    try {
        doctorDAO.deleteDoctor(doctorId);
        return Response.noContent()
                .entity("Doctor with ID: " + doctorId + " successfully deleted")
                .build();
    } catch (Exception e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Error occurred while deleting the doctor: " + e.getMessage())
                .build();
    }
}
    
     @GET
    @Path("/{doctorId}/appointments")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAppointmentsByDoctorId(@PathParam("doctorId") int doctorId) {
        try {
            List<Appointment> appointments = appointmentDAO.getAppointmentsByDoctorId(doctorId);
            if (!appointments.isEmpty()) {
                return Response.ok(appointments).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND).entity("No appointments found for doctor ID: " + doctorId).build();
            }
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("Error occurred: " + e.getMessage()).build();
        }
    }
    
    
    
}
