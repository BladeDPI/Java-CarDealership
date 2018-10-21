package edu.wk.blog.servlet;

import edu.wk.blog.model.BlogPost;
import edu.wk.blog.service.BlogPostService;
import edu.wk.blog.service.impl.BlogPostServiceImpl;
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
import javax.xml.ws.WebEndpoint;
import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/")
public class BlogPostServlet extends HttpServlet {
    private static final Logger LOG = LoggerFactory.getLogger(BlogPostServlet.class);

    private Template freemarkerTemplate;

    // sure is ugly to initialize a dependency here
    // I wonder if there is a more elegant way...
    @Inject
    private BlogPostService blogPostService;

    @Inject
    private Configuration configuration;

    @Override
    public void init() throws ServletException {
        super.init();

        try {
            freemarkerTemplate = configuration.getTemplate("blogPosts.ftl");
        }
        catch (IOException e) {
            LOG.error("Failed to read template");
        }
        LOG.info("Blog post edu.wk.blog.servlet initialized");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LOG.info("GET received");
        Collection<BlogPost> blogPosts = blogPostService.findAllBlogPosts();

        Map<String, Object> model = new HashMap<>();
        model.put("blogPosts", blogPosts);
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
        LOG.info("POST received");

        BlogPost blogPost = new BlogPost();
        blogPost.setTitle(req.getParameter("title"));
        blogPost.setWriter(req.getParameter("writer"));
        blogPost.setContent(req.getParameter("content"));
        blogPost.setUploadDate(new Date());
        blogPostService.createBlogPost(blogPost);

        doGet(req, resp);
    }
}

