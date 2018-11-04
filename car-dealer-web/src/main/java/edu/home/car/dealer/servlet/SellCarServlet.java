package edu.home.car.dealer.servlet;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import edu.home.car.dealer.PersonDto;
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


@WebServlet(urlPatterns = "/sellCar")
public class SellCarServlet extends HttpServlet {

    private final Logger LOG = LoggerFactory.getLogger(SellCarServlet.class);

    private Template freemarkerTemplate;

    @Inject
    private Configuration configuration;

    @Override
    public void init() throws ServletException {
        super.init();

        try {
            freemarkerTemplate = configuration.getTemplate("sellCar.ftl");
        } catch (IOException e) {
            LOG.error("Failed to read template");
        }
        LOG.info("Sell car edu.wk.car.dealer.servlet initialized");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LOG.info("Sell car GET received");

        String nickName = SessionManager.getNickName(req);
        if (nickName == null) {
            nickName = "Please login";
        }
        showLog(resp, nickName, "2500", "BMW", "7 Series", "728i", "1050000", "1998", "Petrol", "Sedan", "Green", "Bucuresti", "145", "Automatic");
    }

    private void showLog(HttpServletResponse resp, String nickName, String price, String make, String model,
                         String trim, String km, String year, String fuelType, String bodyType, String color,
                         String city, String power, String transmission) throws IOException {
        final Map<String, String> modelFreeMark = new HashMap<>();
        modelFreeMark.put("login", nickName);
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
        LOG.info("Sell car POST received");

        final String price = req.getParameter("price");
        final String make = req.getParameter("make");
        final String model = req.getParameter("model");
        final String trim = req.getParameter("trim");
        final String km = req.getParameter("km");
        final String year = req.getParameter("year");
        final String fuelType = req.getParameter("fuelType");
        final String bodyType = req.getParameter("bodyType");
        final String color = req.getParameter("color");
        final String city = req.getParameter("city");
        final String power = req.getParameter("power");
        final String transmission = req.getParameter("transmission");

    }
}

