package edu.home.car.dealer.servlet;

import edu.home.car.dealer.LoginDto;
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
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.NewCookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import static edu.home.car.dealer.utils.Freemarker.loadFreeMarkerTemplate;


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
        LOG.info("Login edu.wk.car.dealer.servlet initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LOG.info("Login GET received");
        showLog(resp, "Please login", "DokaIstvan", "isti");
    }

    private void showLog(HttpServletResponse resp, String login, String userName, String password) throws IOException {
        final Map<String, Object> model = new HashMap<>();
        model.put("login", login);
        model.put("userName", userName);
        model.put("password", password);

        loadFreeMarkerTemplate(LOG, freemarkerTemplate, resp, model);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LOG.info("Login POST received");

        final String button = req.getParameter("button");
        final String userName = req.getParameter("userName");
        final String password = req.getParameter("password");

        switch (button) {
            case "login": {
                login(req, resp, userName, password);
                break;
            }
            case "logout": {
                logout(req, resp, userName, password);
                break;
            }
        }
    }

    private void login(HttpServletRequest req, HttpServletResponse resp, String userName, String password) throws IOException {
        final ClientConfig config = new DefaultClientConfig();
        final Client client = Client.create(config);
        final WebResource service = client.resource(UriBuilder.fromUri(ConstVariables.LOGIN_API_URL).build());

        final LoginDto loginDto = new LoginDto();
        loginDto.setUsername(userName);
        loginDto.setPassword(password);

        final NewCookie cookie = SessionManager.getCookie(req);
        final ClientResponse response = service.cookie(cookie).type(MediaType.APPLICATION_JSON).post(ClientResponse.class, loginDto);

        SessionManager.putCookie(req, response);

        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            final HttpSession session = req.getSession(true);
            session.setAttribute("nickName", userName);
        }

        showLog(resp, response.getEntity(String.class), loginDto.getUsername(), loginDto.getPassword());
    }

    private void logout(HttpServletRequest req, HttpServletResponse resp, String userName, String password) throws IOException {
        final ClientConfig config = new DefaultClientConfig();
        final Client client = Client.create(config);
        WebResource service = client.resource(UriBuilder.fromUri(ConstVariables.LOGOUT_API_URL).build());

        final NewCookie cookie = SessionManager.getCookie(req);
        final ClientResponse response = service.cookie(cookie).type(MediaType.APPLICATION_JSON).post(ClientResponse.class);

        SessionManager.putCookie(req, response);

        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            final HttpSession session = req.getSession(true);
            session.setAttribute("nickName", null);
        }

        showLog(resp, response.getEntity(String.class), userName, password);
    }
}

