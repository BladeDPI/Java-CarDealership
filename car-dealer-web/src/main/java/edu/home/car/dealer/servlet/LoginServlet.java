package edu.home.car.dealer.servlet;

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
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;


@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private final Logger LOG = LoggerFactory.getLogger(LoginServlet.class);

    private Template freemarkerTemplate;

    @Inject
    private Configuration configuration;

    @Override
    public void init() throws ServletException {
        super.init();

        try {
            freemarkerTemplate = configuration.getTemplate("login.ftl");
        } catch (IOException e) {
            LOG.error("Failed to read template");
        }
        LOG.info("Blog post edu.wk.blog.servlet initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Login GET received");

        showLog(resp, "Please login", "kisjoker", "123qweasd");
    }

    private void showLog(HttpServletResponse resp, String login, String userName, String password) throws IOException {
        final  Map<String, String> model = new HashMap<>();
        model.put("login", login);
        model.put("userName", userName);
        model.put("password", password);

        try {
            freemarkerTemplate.process(model, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error("Could not render template");
            resp.getWriter().println("Could not render template");
            resp.setStatus(500);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Login POST received");

        final String button = req.getParameter("button");
        final String userName = req.getParameter("userName");
        final String password = req.getParameter("password");

        final HttpSession session = req.getSession(true);
        final String sessionId = session.getId();

        if (button.equals("login")) {
            login(resp, sessionId, userName, password);
        } else {
            logout(resp, sessionId, userName, password);
        }
    }

    private void login(HttpServletResponse resp, String sessionId, String userName, String password) throws IOException {
        final ClientConfig config = new DefaultClientConfig();
        final Client client = Client.create(config);
        final WebResource service = client.resource(UriBuilder.fromUri("http://localhost:8080/car-dealer-api/login").build());

        final LoginDto loginDto = new LoginDto();
        loginDto.setUsername(userName);
        loginDto.setPassword(password);

        final NewCookie cookie = SessionManager.getCookie(sessionId);
        final ClientResponse response = service.cookie(cookie).type(MediaType.APPLICATION_JSON).post(ClientResponse.class, loginDto);

        final List<NewCookie> newCookies = response.getCookies();
        if (newCookies != null && newCookies.size() > 0 ) {
            SessionManager.putCookie(sessionId, newCookies.get(0));
        }

        showLog(resp, response.getEntity(String.class), loginDto.getUsername(), loginDto.getPassword());
    }

    private void logout(HttpServletResponse resp, String sessionId, String userName, String password) throws IOException {
        final ClientConfig config = new DefaultClientConfig();
        final Client client = Client.create(config);
        WebResource service = client.resource(UriBuilder.fromUri("http://localhost:8080/car-dealer-api/logout").build());

        final NewCookie cookie = SessionManager.getCookie(sessionId);
        final ClientResponse response = service.cookie(cookie).type(MediaType.APPLICATION_JSON).post(ClientResponse.class);

        final List<NewCookie> newCookies = response.getCookies();
        if (newCookies != null && newCookies.size() > 0) {
            SessionManager.putCookie(sessionId, newCookies.get(0));
        }

        showLog(resp, response.getEntity(String.class), userName, password);
    }
}

