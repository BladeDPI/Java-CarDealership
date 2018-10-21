package edu.home.car.dealer.servlet;

import edu.home.car.dealer.model.CarDeal;
import edu.home.car.dealer.service.CarDealerService;
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
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(LoginServlet.class);

    private Template freemarkerTemplate;

    // sure is ugly to initialize a dependency here
    // I wonder if there is a more elegant way...
    @Inject
    private CarDealerService carDealerService;

    @Inject
    private Configuration configuration;

    @Override
    public void init() throws ServletException {
        super.init();

        try {
            freemarkerTemplate = configuration.getTemplate("login.ftl");
        }
        catch (IOException e) {
            LOG.error("Failed to read template");
        }
        LOG.info("Blog post edu.wk.blog.servlet initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Login GET received");

        try {
            freemarkerTemplate.process(null, resp.getWriter());
        }
        catch (TemplateException e) {
            LOG.error("Could not render template");
            resp.getWriter().println("Could not render template");
            resp.setStatus(500);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("Login POST received");

        final String userName = req.getParameter("userName");
        final String password = req.getParameter("password");
    }
}
