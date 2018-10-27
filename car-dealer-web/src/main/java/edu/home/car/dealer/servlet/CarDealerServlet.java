package edu.home.car.dealer.servlet;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.GenericType;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import edu.home.car.dealer.CarDealDto;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.util.*;

@WebServlet(urlPatterns = "/carDeals")
public class CarDealerServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(CarDealerServlet.class);

    private Template freemarkerTemplate;

    @Inject
    private Configuration configuration;

    @Override
    public void init() throws ServletException {
        super.init();

        try {
            freemarkerTemplate = configuration.getTemplate("carDeals.ftl");
        }
        catch (IOException e) {
            LOG.error("Failed to read template");
        }
        LOG.info("Blog post edu.home.car.dealer.servlet initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("GET all Car deals");

        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource service = client.resource(UriBuilder.fromUri("http://localhost:8080/car-dealer-api/carDeals").build());

        ClientResponse response = service.type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        Collection<CarDealDto> carDeals = response.getEntity(new GenericType<List<CarDealDto>>() {
        });

        showCars(resp, carDeals);
    }

    private void showCars(HttpServletResponse resp, Collection<CarDealDto> carDeals) throws IOException {
        Map<String, Object> model = new HashMap<>();
        model.put("carDeals", carDeals);
        try {
            freemarkerTemplate.process(model, resp.getWriter());
        }
        catch (TemplateException e) {
            LOG.error("Could not render template");
            resp.getWriter().println("Could not render template");
            resp.setStatus(500);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Car Dealer POST received");

        final String id = req.getParameter("id");

        ClientConfig config = new DefaultClientConfig();
        Client client = Client.create(config);
        WebResource service = client.resource(UriBuilder.fromUri("http://localhost:8080/car-dealer-api/carDeals").build());

        ClientResponse response = service.path(id).cookie(LoginServlet.cookie).type(MediaType.APPLICATION_JSON).get(ClientResponse.class);
        CarDealDto carDeals = response.getEntity(CarDealDto.class);

        showCars(resp, Collections.singleton(carDeals));
    }
}

