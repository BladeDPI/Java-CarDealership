package edu.home.car.dealer.servlet;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import edu.home.car.dealer.LoginDto;
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
import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


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
        LOG.info("Car dealer edu.wk.blog.servlet initialized");
    }


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LOG.info("Sign Up GET received");
        showLog(resp, "Please sign up", "WoltersKluwer", "Wolters", "Kluwer", "4251", "woltersKluwer@gmail.com", "421", "Cluj Napoca");
    }

    private void showLog(HttpServletResponse resp, String login, String profileName, String firstName,
                         String secondName, String idCardNumber, String email, String phoneNumber, String city) throws IOException {
        final Map<String, String> model = new HashMap<>();
        model.put("login", login);
        model.put("profileName", profileName);
        model.put("firstName", firstName);
        model.put("secondName", secondName);
        model.put("idCardNumber", idCardNumber);
        model.put("email", email);
        model.put("phoneNumber", phoneNumber);
        model.put("city", city);

        try {
            freemarkerTemplate.process(model, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error("Could not render template");
            resp.getWriter().println("Could not render template");
            resp.setStatus(500);
        }
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

        if(!psw.equals(pswRepeat)){
            showLog(resp, "Passwords did not match", profileName, firstName, secondName, idCardNumber, email, phoneNumber, city);
        }
        else {
            //TODO nickName
            showLog(resp, "There was an error", profileName, firstName, secondName, idCardNumber, email, phoneNumber, city);
        }
    }
}

