package edu.home.car.dealer.utils;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.slf4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@ApplicationScoped
public class Freemarker {
    private static final String VIEWS_PACKAGE = "views";

    private static Configuration freemarkerConfiguration;

    @Produces
    public static Configuration getFreemarkerConfiguration() {
        if (freemarkerConfiguration == null) {
            freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
            final ClassLoader classLoader = Freemarker.class.getClassLoader();
            freemarkerConfiguration.setClassLoaderForTemplateLoading(classLoader, VIEWS_PACKAGE);
        }
        return freemarkerConfiguration;
    }

    public static void loadFreeMarkerTemplate(Logger LOG , Template freemarkerTemplate, HttpServletResponse resp, Map<String, Object> model) throws IOException {
        try {
            freemarkerTemplate.process(model, resp.getWriter());
        } catch (TemplateException e) {
            LOG.error("Could not render template");
            resp.getWriter().println("Could not render template");
            resp.setStatus(500);
        }
    }
}
