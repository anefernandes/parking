package br.com.therealbatman.rest;

import br.com.therealbatman.domain.Employer;
import br.com.therealbatman.domain.ParkingRegistration;
import br.com.therealbatman.domain.Visitor;
import br.com.therealbatman.services.ParkingService;
import io.smallrye.common.constraint.NotNull;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@Path("/parking")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "1 - Parking", description = "")
@RequestScoped
public class ParkingController {

    @Inject
    ParkingService parkingService;

    @POST
    @Path("/entry")
    @RequestBody(required = true, content =
            @Content(mediaType = "application/json"))
    public Response addEntry(ParkingRegistration parkingRegistration){
        parkingService.addEntrace(parkingRegistration);
        return Response.status(Response.Status.CREATED).build();
    }

    @POST
    @Path("/exit")
    public Response addExit(@NotNull @HeaderParam("licensePlate") String licensePlate){
        parkingService.addExit(licensePlate);
        return Response.status(Response.Status.CREATED).build();
    }

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
