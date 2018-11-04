package edu.home.car.dealer;

import edu.home.car.dealer.model.Person;
import edu.home.car.dealer.service.PersonService;

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
    private HttpServletRequest request;

    @Inject
    private HttpSession session;

    @Inject
    private PersonService personService;

    @POST
    @Path("/signUp")
    public Response singUp(PersonDto personDto) {
        try {
            if (personService.findPersonByProfileName(personDto.getProfileName()) == null) {
                personService.createPerson(getPerson(personDto));
                return Response.ok("User successful created").build();
            } else {
                return Response.status(Status.CONFLICT).entity("Profile name already used, please choose another.").build();
            }
        } catch (final Exception e) {
            return Response.status(Status.INTERNAL_SERVER_ERROR).entity("Failed to create user - " + e.getMessage()).build();
        }
    }

    private Person getPerson(PersonDto personDto) {
        Person.PersonBuilder personBuilder = new Person.PersonBuilder();
        personBuilder.profileName(personDto.getProfileName()).firstName(personDto.getFirstName()).
                secondName(personDto.getSecondName()).idCardNumber(personDto.getIdCardNumber()).email(personDto.getEmail())
                .city(personDto.getCity()).phoneNumber(personDto.getPhoneNumber()).password(personDto.getPassword());
        return personBuilder.createPerson();
    }

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
        } catch (final ServletException e) {
            return Response.status(Status.UNAUTHORIZED).entity("Failed to login - " + e.getMessage()).build();
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
        } catch (final ServletException e) {
            return Response.status(Status.FORBIDDEN).entity("Failed to logout - " + e.getMessage()).build();
        }
    }
}