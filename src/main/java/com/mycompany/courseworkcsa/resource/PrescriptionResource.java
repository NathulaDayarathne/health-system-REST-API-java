/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.courseworkcsa.resource;

import com.mycompany.courseworkcsa.dao.PrescriptionDAO;
import com.mycompany.courseworkcsa.model.Prescription;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author User
 */
@Path("/prescriptions")
public class PrescriptionResource {
    
    private PrescriptionDAO prescriptionDAO = new PrescriptionDAO();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPrescriptions() {
        try {
            List<Prescription> prescriptions = prescriptionDAO.getAllPrescriptions();
            return Response.ok(prescriptions).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error occurred: " + e.getMessage())
                    .build();
        }
    }

    @GET
    @Path("/{prescriptionId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPrescriptionById(@PathParam("prescriptionId") int prescriptionId) {
        try {
            Prescription prescription = prescriptionDAO.getPrescriptionById(prescriptionId);
            if (prescription != null) {
                return Response.ok(prescription).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Prescription not found with ID: " + prescriptionId)
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
    public Response addPrescription(Prescription prescription) {
    try {
        prescriptionDAO.addPrescription(prescription);
        return Response.status(Response.Status.CREATED)
                .entity("Prescription successfully added")
                .build();
    } catch (Exception e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Error occurred while adding a new prescription: " + e.getMessage())
                .build();
    }
}

    @PUT
    @Path("/{prescriptionId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updatePrescription(@PathParam("prescriptionId") int prescriptionId, Prescription updatedPrescription) {
    try {
        Prescription existingPrescription = prescriptionDAO.getPrescriptionById(prescriptionId);
        if (existingPrescription != null) {
            updatedPrescription.setPrescriptionId(prescriptionId);
            prescriptionDAO.updatePrescription(updatedPrescription);
            return Response.ok()
                    .entity("Prescription with ID: " + prescriptionId + " successfully updated")
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Prescription not found with ID: " + prescriptionId + " for update")
                    .build();
        }
    } catch (Exception e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Error occurred while updating the prescription: " + e.getMessage())
                .build();
    }
}

    @DELETE
    @Path("/{prescriptionId}")
    public Response deletePrescription(@PathParam("prescriptionId") int prescriptionId) {
        try {
            prescriptionDAO.deletePrescription(prescriptionId);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error occurred: " + e.getMessage())
                    .build();
        }
    }
}
