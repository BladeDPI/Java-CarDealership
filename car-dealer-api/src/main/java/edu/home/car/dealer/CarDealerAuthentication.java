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

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@ApplicationScoped
@Path("")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CarDealerAuthentication {

    @Inject
    HttpServletRequest request;

    @Inject
    HttpSession session;

    @POST
    @Path("/login")
    public Response login(LoginDto loginDto) {
        try {
            if (request.getUserPrincipal() == null) {
                request.login(loginDto.getUsername(), loginDto.getPassword());
                return Response.ok("Login successful").build();
            } else {
                return Response.ok("Already loged in").build();
            }
        }
        catch (ServletException e) {
            return Response.status(Status.UNAUTHORIZED).build();
        }
    }

    @POST
    @Path("/logout")
    public Response logout() {
        try {
            if (request.getUserPrincipal() != null) {
                request.logout();
                session.invalidate();
                return Response.ok("Logout successful").build();
            } else {
                return Response.status(Status.BAD_REQUEST).build();
            }
        }
        catch (ServletException e) {
            return Response.status(Status.FORBIDDEN).build();
        }
    }
}