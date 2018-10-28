package edu.home.car.dealer;

import edu.home.car.dealer.model.Car;
import edu.home.car.dealer.service.CarService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
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
    public Response findAll() {
        final Collection<Car> allCarDeals = carDealerService.findAllCarDeals();
        final ResponseBuilder builder = Response.ok(allCarDeals);
        return builder.build();
    }

    @GET
    @Path("/{carDealId}")
    public Response findCarDealById(@PathParam("carDealId") Long id) {
        final Car carDealById = carDealerService.findCarDealById(id);
        final ResponseBuilder builder = Response.ok(carDealById);
        return builder.build();
    }
}