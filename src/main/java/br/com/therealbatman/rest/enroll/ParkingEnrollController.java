package br.com.therealbatman.rest.enroll;

import br.com.therealbatman.domain.Employer;
import br.com.therealbatman.domain.Visitor;
import br.com.therealbatman.services.ParkingService;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/parking")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "2 - Enroll", description = "Realização de cadastro dos funcionários e visitantes para utilização do estacionamento.")
@RequestScoped
public class ParkingEnrollController {
    @Inject
    ParkingService parkingService;

    @POST
    @Path("/enroll/employer")
    public Response addEmployer(Employer employer){
        parkingService.enrollEmployer(employer);
        return Response.status(Response.Status.CREATED).build();
    }

    @POST
    @Path("/enroll/visitor")
    public Response addVisitor(Visitor visitor){
        parkingService.enrollVisitor(visitor);
        return Response.status(Response.Status.CREATED).build();
    }
}
