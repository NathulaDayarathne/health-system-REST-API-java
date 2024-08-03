/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.courseworkcsa.resource;

import com.mycompany.courseworkcsa.dao.DoctorDAO;
import com.mycompany.courseworkcsa.dao.PatientDAO;
import com.mycompany.courseworkcsa.model.Person;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author User
 */
@Path("/persons")
public class PersonResource {
     private PatientDAO patientDAO = new PatientDAO();
     private DoctorDAO doctorDAO = new DoctorDAO();
     
     
     @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPersons() {
        try {
            List<Person> persons = new ArrayList<>();
            persons.addAll(patientDAO.getAllPatients());
            persons.addAll(doctorDAO.getAllDoctors());
            return Response.ok(persons).build();
        } catch (Exception e) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR)
                    .entity("Error occurred: " + e.getMessage())
                    .build();
        }
    }
}
