package edu.home.car.dealer;

import edu.home.car.dealer.model.Car;
import edu.home.car.dealer.model.Options;
import edu.home.car.dealer.service.CarService;

import javax.ejb.EJBAccessException;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Collection;
import java.util.Date;

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
        } catch (EJBAccessException e) {
            return Response.status(Response.Status.FORBIDDEN).entity("You do not have privilege please login").build();
        }
    }

    @POST
    @Path("/{carDealId}/{profileName}")
    public Response buyCarDealById(@PathParam("carDealId") Long id, @PathParam("profileName") String profileName) {
        try {
            final Car carDealById = carDealerService.findCarDealById(id);
            if (carDealById.getPerson().getProfileName().equals(profileName)) {
                return Response.status(Response.Status.NOT_ACCEPTABLE).entity(" you can not but your own car").build();
            } else {
                final Car car = carDealerService.sellCar(carDealById, profileName);

                final ResponseBuilder builder = Response.ok(car);
                return builder.build();
            }
        } catch (EJBAccessException e) {
            return Response.status(Response.Status.FORBIDDEN).entity("You do not have privilege please login").build();
        }
    }

    @POST
    @Path("/createCarDeal/{profileName}")
    public Response createCarDeal(@PathParam("profileName") String profileName, CarDto carDto) {

        try {
            carDealerService.createCarDeal(getCar(carDto), profileName);
            final ResponseBuilder builder = Response.ok("Car deal created");
            return builder.build();
        } catch (EJBAccessException e) {
            return Response.status(Response.Status.FORBIDDEN).entity("You do not have privilege please login").build();
        }

    }

    private Car getCar(CarDto carDto) {
        final OptionsDto optionsDto = carDto.getOptions();
        final Options.OptionBuilder optionBuilder = new Options.OptionBuilder();
        optionBuilder.abs(optionsDto.isAbs()).airbag(optionsDto.isAirbag()).alarm(optionsDto.isAlarm())
                .alloyWheels(optionsDto.isAlloyWheels()).centralLocking(optionsDto.isCentralLocking()).cruiseControl(optionsDto.isCruiseControl())
                .electricMirrors(optionsDto.isElectricMirrors()).electricWindows(optionsDto.isElectricWindows()).leather(optionsDto.isLeather())
                .powerSteering(optionsDto.isPowerSteering()).tripComputer(optionsDto.isTripComputer());

        final Options options = optionBuilder.createOption();

        final Car.CarBuilder carBuilder = new Car.CarBuilder();
        carBuilder.price(carDto.getPrice()).make(carDto.getMake()).model(carDto.getModel()).bodyType(carDto.getBodyType())
                .city(carDto.getCity()).color(carDto.getColor()).fuelType(carDto.getFuelType()).km(carDto.getKm()).year(carDto.getYear())
                .power(carDto.getPower()).trim(carDto.getTrim()).transmission(carDto.getTransmission()).uploadDate(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));

        carBuilder.options(options);
        return carBuilder.createCar();
    }
}