package edu.home.car.dealer.freemarker;

import freemarker.template.Configuration;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class FreemarkerFactory {
    private static final String VIEWS_PACKAGE = "views";

    private static Configuration freemarkerConfiguration;

    @Produces
    public static Configuration getFreemarkerConfiguration() {
        if (freemarkerConfiguration == null) {
            freemarkerConfiguration = new Configuration(Configuration.VERSION_2_3_28);
            final ClassLoader classLoader = FreemarkerFactory.class.getClassLoader();
            freemarkerConfiguration.setClassLoaderForTemplateLoading(classLoader, VIEWS_PACKAGE);
        }
        return freemarkerConfiguration;
    }
}
