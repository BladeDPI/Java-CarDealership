package edu.home.car.dealer;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.*;
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
                return Response.ok("Already logged in").build();
            }
        }
        catch (ServletException e) {
            return Response.status(Status.UNAUTHORIZED).entity("Failed to login").build();
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
                return Response.status(Status.BAD_REQUEST).entity("Already logged out").build();
            }
        }
        catch (ServletException e) {
            return Response.status(Status.FORBIDDEN).entity("Failed to logout").build();
        }
    }
}