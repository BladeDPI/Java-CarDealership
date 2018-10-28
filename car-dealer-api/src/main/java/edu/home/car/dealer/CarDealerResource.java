package edu.home.car.dealer;

import edu.home.car.dealer.model.Car;
import edu.home.car.dealer.service.CarService;

import javax.ejb.EJBAccessException;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import java.util.Collection;

@ApplicationScoped
@Path("/carDeals")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarDealerResource {

    @Inject
    private CarService carDealerService;

    @GET
    @Path("/")
    public Response findAllAvailable() {
        final Collection<Car> allCarDeals = carDealerService.findAllAvailable();
        final ResponseBuilder builder = Response.ok(allCarDeals);
        return builder.build();
    }

    @GET
    @Path("/{carDealId}")
    public Response findCarDealById(@PathParam("carDealId") Long id) {
        try {
            final Car carDealById = carDealerService.findCarDealById(id);
            final ResponseBuilder builder = Response.ok(carDealById);
            return builder.build();
        }
         catch(EJBAccessException e){
                return Response.status(Response.Status.FORBIDDEN).entity("Please login").build();
            }
        }
    }