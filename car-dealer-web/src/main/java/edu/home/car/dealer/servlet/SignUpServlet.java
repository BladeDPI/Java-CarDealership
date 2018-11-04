package edu.home.car.dealer.servlet;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import edu.home.car.dealer.PersonDto;
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
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static edu.home.car.dealer.utils.Freemarker.loadFreeMarkerTemplate;


@WebServlet(urlPatterns = "/signUp")
public class SignUpServlet extends HttpServlet {

    private final Logger LOG = LoggerFactory.getLogger(SignUpServlet.class);

    private Template freemarkerTemplate;

    @Inject
    private Configuration configuration;

    @Override
    public void init() throws ServletException {
        super.init();

        try {
            freemarkerTemplate = configuration.getTemplate("signUp.ftl");
        } catch (IOException e) {
            LOG.error("Failed to read template");
        }
        LOG.info("Sign Up edu.wk.car.dealer.servlet initialized");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LOG.info("Sign Up GET received");
        showLog(resp, "Please sign up", "WoltersKluwer", "Wolters", "Kluwer", "4251", "woltersKluwer@gmail.com", "421", "Cluj Napoca");
    }

    private void showLog(HttpServletResponse resp, String login, String profileName, String firstName,
                         String secondName, String idCardNumber, String email, String phoneNumber, String city) throws IOException {
        final Map<String, Object> model = new HashMap<>();
        model.put("login", login);
        model.put("profileName", profileName);
        model.put("firstName", firstName);
        model.put("secondName", secondName);
        model.put("idCardNumber", idCardNumber);
        model.put("email", email);
        model.put("phoneNumber", phoneNumber);
        model.put("city", city);

        loadFreeMarkerTemplate(LOG, freemarkerTemplate, resp, model);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LOG.info("Sign Up POST received");

        final String profileName = req.getParameter("profileName");
        final String firstName = req.getParameter("firstName");
        final String secondName = req.getParameter("secondName");
        final String idCardNumber = req.getParameter("idCardNumber");
        final String email = req.getParameter("email");
        final String phoneNumber = req.getParameter("phoneNumber");
        final String city = req.getParameter("city");
        final String psw = req.getParameter("psw");
        final String pswRepeat = req.getParameter("psw-repeat");

        if (!psw.equals(pswRepeat)) {
            showLog(resp, "Passwords did not match", profileName, firstName, secondName, idCardNumber, email, phoneNumber, city);
        } else {
            final ClientConfig config = new DefaultClientConfig();
            final Client client = Client.create(config);
            final WebResource service = client.resource(UriBuilder.fromUri(ConstVariables.SING_UP_API_URL).build());

            final PersonDto personDto = new PersonDto();
            personDto.setProfileName(profileName);
            personDto.setFirstName(firstName);
            personDto.setSecondName(secondName);
            personDto.setIdCardNumber(idCardNumber);
            personDto.setEmail(email);
            personDto.setPhoneNumber(phoneNumber);
            personDto.setCity(city);
            personDto.setPassword(psw);

            final NewCookie cookie = SessionManager.getCookie(req);
            final ClientResponse response = service.cookie(cookie).type(MediaType.APPLICATION_JSON).post(ClientResponse.class, personDto);

            SessionManager.putCookie(req, response);

            showLog(resp, response.getEntity(String.class), profileName, firstName, secondName, idCardNumber, email, phoneNumber, city);
        }
    }
}

