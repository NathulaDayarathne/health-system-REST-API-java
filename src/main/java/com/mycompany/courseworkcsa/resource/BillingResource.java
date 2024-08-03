/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.courseworkcsa.resource;

import com.mycompany.courseworkcsa.dao.BillingDAO;
import com.mycompany.courseworkcsa.model.Billing;
import java.util.List;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
/**
 *
 * @author User
 */
@Path("/billings")
public class BillingResource {
    
     private BillingDAO billingDAO = new BillingDAO();

   @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllBillings() {
        try {
            List<Billing> billings = billingDAO.getAllBillings();
            return Response.ok(billings).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error occurred: " + e.getMessage())
                    .build();
        }
    }

    @GET
    @Path("/{billId}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBillingById(@PathParam("billId") int billId) {
        try {
            Billing billing = billingDAO.getBillingById(billId);
            if (billing != null) {
                return Response.ok(billing).build();
            } else {
                return Response.status(Response.Status.NOT_FOUND)
                        .entity("Billing not found with ID: " + billId)
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
    public Response addBilling(Billing billing) {
    try {
        billingDAO.addBilling(billing);
        return Response.status(Response.Status.CREATED)
                .entity("Billing successfully added")
                .build();
    } catch (Exception e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Error occurred while adding a new billing: " + e.getMessage())
                .build();
    }
}

    @PUT
    @Path("/{billId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateBilling(@PathParam("billId") int billId, Billing updatedBilling) {
    try {
        Billing existingBilling = billingDAO.getBillingById(billId);
        if (existingBilling != null) {
            updatedBilling.setBillId(billId);
            billingDAO.updateBilling(updatedBilling);
            return Response.ok()
                    .entity("Billing with ID: " + billId + " successfully updated")
                    .build();
        } else {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity("Billing not found with ID: " + billId + " for update")
                    .build();
        }
    } catch (Exception e) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("Error occurred while updating the billing: " + e.getMessage())
                .build();
    }
}

    @DELETE
    @Path("/{billId}")
    public Response deleteBilling(@PathParam("billId") int billId) {
        try {
            billingDAO.deleteBilling(billId);
            return Response.noContent().build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error occurred: " + e.getMessage())
                    .build();
        }
    }

    
    
}
