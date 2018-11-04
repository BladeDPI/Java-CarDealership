package edu.home.car.dealer.servlet;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import edu.home.car.dealer.CarDto;
import edu.home.car.dealer.OptionsDto;
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
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@WebServlet(urlPatterns = "/createCarDeal")
public class SellCarServlet extends HttpServlet {

    private final Logger LOG = LoggerFactory.getLogger(SellCarServlet.class);

    private Template freemarkerTemplate;

    @Inject
    private Configuration configuration;

    @Override
    public void init() throws ServletException {
        super.init();

        try {
            freemarkerTemplate = configuration.getTemplate("createCarDeal.ftl");
        } catch (IOException e) {
            LOG.error("Failed to read template");
        }
        LOG.info("Create cer deal edu.wk.car.dealer.servlet initialized");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LOG.info("Create cer deal GET received");

        String nickName = SessionManager.getNickName(req);
        String login = "logged in";
        if (nickName == null) {
            nickName = "Not authorized";
            login = "Please login";
        }
        showLog(resp, nickName, login, "2500", "BMW", "7 Series", "728i", "1050000", "1998", "Petrol", "Sedan", "Green", "Bucuresti", "145", "Automatic");
    }

    private void showLog(HttpServletResponse resp, String nickName, String login, String price, String make,
                         String model, String trim, String km, String year, String fuelType, String bodyType,
                         String color, String city, String power, String transmission) throws IOException {
        final Map<String, String> modelFreeMark = new HashMap<>();

        modelFreeMark.put("nickName", nickName);
        modelFreeMark.put("login", login);

        modelFreeMark.put("price", price);
        modelFreeMark.put("make", make);
        modelFreeMark.put("model", model);
        modelFreeMark.put("trim", trim);
        modelFreeMark.put("km", km);
        modelFreeMark.put("year", year);
        modelFreeMark.put("fuelType", fuelType);
        modelFreeMark.put("bodyType", bodyType);
        modelFreeMark.put("color", color);
        modelFreeMark.put("city", city);
        modelFreeMark.put("power", power);
        modelFreeMark.put("transmission", transmission);

        try {
            freemarkerTemplate.process(modelFreeMark, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error("Could not render template");
            resp.getWriter().println("Could not render template");
            resp.setStatus(500);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LOG.info("Create cer deal POST received");

        final int price = Integer.parseInt(req.getParameter("price"));
        final String make = req.getParameter("make");
        final String model = req.getParameter("model");
        final String trim = req.getParameter("trim");
        final int km = Integer.parseInt(req.getParameter("km"));
        final int year = Integer.parseInt(req.getParameter("year"));
        final String fuelType = req.getParameter("fuelType");
        final String bodyType = req.getParameter("bodyType");
        final String color = req.getParameter("color");
        final String city = req.getParameter("city");
        final int power = Integer.parseInt(req.getParameter("power"));
        final String transmission = req.getParameter("transmission");

        final String nickName = SessionManager.getNickName(req);

        if (nickName != null) {
            final OptionsDto optionsDto = createOptionsDTO(req);

            final CarDto carDto = createCarDTO(price, make, model, trim, km, year, fuelType, bodyType, color, city, power, transmission, optionsDto);

            final ClientConfig config = new DefaultClientConfig();
            final Client client = Client.create(config);
            final WebResource service = client.resource(UriBuilder.fromUri("http://localhost:8080/car-dealer-api/carDeals/createCarDeal").build());

            final NewCookie cookie = SessionManager.getCookie(req);
            final ClientResponse response = service.path(nickName).cookie(cookie).type(MediaType.APPLICATION_JSON).post(ClientResponse.class, carDto);

            if (response.getStatus() == Response.Status.OK.getStatusCode()) {
                SessionManager.putCookie(req, response);
            }

            final String message = response.getEntity(String.class);
            showLog(resp, nickName, message, String.valueOf(price), make, model, trim, String.valueOf(km), String.valueOf(year), fuelType, bodyType, color, city, String.valueOf(power), transmission);
        } else {
            showLog(resp, "Not authorized", "Please login", String.valueOf(price), make, model, trim, String.valueOf(km), String.valueOf(year), fuelType, bodyType, color, city, String.valueOf(power), transmission);
        }

    }

    private OptionsDto createOptionsDTO(HttpServletRequest req) {
        final boolean abs = req.getParameter("abs") != null;
        final boolean airbag = req.getParameter("airbag") != null;
        final boolean alarm = req.getParameter("alarm") != null;
        final boolean alloyWheels = req.getParameter("alloyWheels") != null;
        final boolean centralLocking = req.getParameter("centralLocking") != null;
        final boolean cruiseControl = req.getParameter("cruiseControl") != null;
        final boolean electricMirrors = req.getParameter("electricMirrors") != null;
        final boolean electricWindows = req.getParameter("electricWindows") != null;
        final boolean tripComputer = req.getParameter("tripComputer") != null;
        final boolean leather = req.getParameter("leather").equals("leather");
        final boolean powerSteering = req.getParameter("powerSteering") != null;

        final OptionsDto options = new OptionsDto();
        options.setAbs(abs);
        options.setAirbag(airbag);
        options.setAlarm(alarm);
        options.setAlloyWheels(alloyWheels);
        options.setCentralLocking(centralLocking);
        options.setCruiseControl(cruiseControl);
        options.setCentralLocking(centralLocking);
        options.setElectricMirrors(electricMirrors);
        options.setElectricWindows(electricWindows);
        options.setTripComputer(tripComputer);
        options.setLeather(leather);
        options.setPowerSteering(powerSteering);

        return options;
    }

    private CarDto createCarDTO(int price, String make, String model, String trim, int km, int year, String fuelType,
                                String bodyType, String color, String city, int power, String transmission, OptionsDto optionsDto) {

        final CarDto car = new CarDto();
        car.setPrice(price);
        car.setMake(make);
        car.setModel(model);
        car.setTrim(trim);
        car.setKm(km);
        car.setYear(year);
        car.setFuelType(fuelType);
        car.setBodyType(bodyType);
        car.setColor(color);
        car.setCity(city);
        car.setPower(power);
        car.setTransmission(transmission);
        car.setOptions(optionsDto);

        return car;
    }
}

