package br.com.therealbatman.rest.informations;

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
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@Path("/parking")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(name = "3 - Informations", description = "Responsável por trazer dos dados cadastrados no estacionamento.")
@RequestScoped
public class ParkingInformationsController {

    @Inject
    ParkingService parkingService;

    @GET
    @Path("/register")
    public Response findRegister(@HeaderParam("licensePlate") @NotNull String licensePlate){
        ParkingRegistration registration = parkingService.findByLincensePlate(licensePlate);
        return Response.status(Response.Status.OK).entity(registration).build();
    }

    @GET
    @Path("/employer")
    public Response findEmployer(@HeaderParam("licensePlate") @NotNull String licensePlate){
        Employer employer = parkingService.findEmployerByLicensePlate(licensePlate);
        return Response.status(Response.Status.OK).entity(employer).build();
    }

    @GET
    @Path("/visitor")
    public Response findVisitor(@HeaderParam("licensePlate") @NotNull String licensePlate){
        Visitor visitor = parkingService.findVisitorByLicensePlate(licensePlate);
        return Response.status(Response.Status.OK).entity(visitor).build();
    }

    @GET
    @Path("/register/all")
    public Response findAllRegister(){
        List<ParkingRegistration> allRegistration = parkingService.listAllRegistration();
        return Response.status(Response.Status.OK).entity(allRegistration).build();
    }
}
