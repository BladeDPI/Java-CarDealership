/*
 * *************************************************************************
 * Copyright (C) Wolters Kluwer Financial Services. All rights reserved.
 *
 * This computer program is protected by copyright law and international
 * treaties. Unauthorized reproduction or distribution of this program,
 * or any portion of it, may result in severe civil and criminal penalties,
 * and will be prosecuted to the maximum extent possible under the law.
 * *************************************************************************
 */
package edu.home.car.dealer;

import edu.home.car.dealer.model.CarDeal;
import edu.home.car.dealer.service.CarDealerService;

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
    private CarDealerService carDealerService;

    @GET
    @Path("/")
    public Response findAll() {

        final Collection<CarDeal> allCarDeals = carDealerService.findAllCarDeals();
        ResponseBuilder builder = Response.ok(allCarDeals);
        return builder.build();
    }

    @GET
    @Path("/{carDealId}")
    public Response findCarDealById(@PathParam("carDealId") Long id) {
        final CarDeal carDealById = carDealerService.findCarDealById(id);
        ResponseBuilder builder = Response.ok(carDealById);
        return builder.build();
    }
}