package edu.home.car.dealer.servlet;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import edu.home.car.dealer.CarDto;
import edu.home.car.dealer.freemarker.CarDtoFreemarker;
import edu.home.car.dealer.utils.ConstVariables;
import edu.home.car.dealer.utils.SessionManager;
import freemarker.template.Configuration;
import freemarker.template.Template;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.util.*;

import static edu.home.car.dealer.utils.Freemarker.loadFreeMarkerTemplate;


@WebServlet(urlPatterns = "/carDeals")
public class CarDealerServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(CarDealerServlet.class);

    private Template freemarkerTemplate;

    @Inject
    private Configuration configuration;

    private final Client client = Client.create(new DefaultClientConfig());

    @Override
    public void init() throws ServletException {
        super.init();

        try {
            freemarkerTemplate = configuration.getTemplate("carDeals.ftl");
        } catch (IOException e) {
            LOG.error("Failed to read template");
        }
        LOG.info("Car dealer edu.home.car.dealer.servlet initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LOG.info("GET all Car deals");

        final Collection<CarDto> carDeals = getAllCars();

        String nickName = SessionManager.getNickName(req);
        if (nickName == null) {
            nickName = "LOGIN - you can only view";
        }

        showCars(resp, carDeals, nickName);
    }

    private Collection<CarDto> getAllCars() {
        final WebResource service = client.resource(UriBuilder.fromUri(ConstVariables.CAR_DEALS_API_URL).build());

        final ClientResponse response = service.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        return response.getEntity(new GenericType<List<CarDto>>() {
        });
    }

    private void showCars(HttpServletResponse resp, Collection<CarDto> carDeals, String nickName) throws IOException {
        final Map<String, Object> model = new HashMap<>();

        Collection<CarDtoFreemarker> carDtoFreemarker = new ArrayList<>();
        for (CarDto carDto : carDeals) {
            carDtoFreemarker.add(new CarDtoFreemarker(carDto));
        }

        model.put("carDeals", carDtoFreemarker);

        model.put("nickName", nickName);

        loadFreeMarkerTemplate(LOG, freemarkerTemplate, resp, model);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LOG.info("Car Dealer POST received");


        final String button = req.getParameter("button");

        switch (button) {
            case "find": {
                findCar(req, resp);
                break;
            }
            default: {
                buyCar(req, resp);
                break;
            }
        }
    }

    private void buyCar(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        final NewCookie cookie = SessionManager.getCookie(req);

        final String id = req.getParameter("button");
        final String nickName = SessionManager.getNickName(req);

        if (nickName == null || cookie == null) {
            final Collection<CarDto> carDeals = getAllCars();
            showCars(resp, carDeals, "You do not have privilege please login");
        } else {
            final WebResource service = client.resource(UriBuilder.fromUri(ConstVariables.CAR_DEALS_API_URL).build());
            final ClientResponse response = service.path(id).path(nickName).cookie(cookie).type(MediaType.APPLICATION_JSON).post(ClientResponse.class);

            SessionManager.putCookie(req, response);

            final Collection<CarDto> carDeals = getAllCars();
            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                final CarDto car = response.getEntity(CarDto.class);
                showCars(resp, carDeals, nickName + " you bought " + car.getTitle());
            } else if (response.getStatus() == Response.Status.NOT_ACCEPTABLE.getStatusCode()) {
                showCars(resp, carDeals, nickName + response.getEntity(String.class));
            } else {
                showCars(resp, carDeals, response.getEntity(String.class));
            }
        }
    }

    private void findCar(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        final WebResource service = client.resource(UriBuilder.fromUri(ConstVariables.CAR_DEALS_API_URL).build());

        final NewCookie cookie = SessionManager.getCookie(req);

        final String id = req.getParameter("id");
        final ClientResponse response = service.path(id).cookie(cookie).type(MediaType.APPLICATION_JSON).get(ClientResponse.class);

        SessionManager.putCookie(req, response);

        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            final CarDto carDeals = response.getEntity(CarDto.class);
            showCars(resp, Collections.singleton(carDeals), SessionManager.getNickName(req));
        } else {
            final Collection<CarDto> carDeals = getAllCars();
            showCars(resp, carDeals, response.getEntity(String.class));
        }
    }
}

