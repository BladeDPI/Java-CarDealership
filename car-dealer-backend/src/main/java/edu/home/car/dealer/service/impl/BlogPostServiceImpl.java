package edu.home.car.dealer.service.impl;

import edu.home.car.dealer.dao.BlogPostDao;
import edu.home.car.dealer.dao.RepositoryException;
import edu.home.car.dealer.model.BlogPost;
import edu.home.car.dealer.service.BlogPostService;
import edu.home.car.dealer.service.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.Collection;

@Stateless
@DeclareRoles({"test", "blogPost"})
//@ApplicationScoped
public class BlogPostServiceImpl implements BlogPostService {
    private static final Logger LOG = LoggerFactory.getLogger(BlogPostServiceImpl.class);

    @Inject
    private BlogPostDao blogPostDao;

    @Override
    @PermitAll
    public Collection<BlogPost> findAllBlogPosts() throws ServiceException {
        try {
            return blogPostDao.findAll();
        }
        catch (RepositoryException e) {
            LOG.error("findAllBlogPosts failed", e);
            throw new ServiceException("findAllBlogPosts failed", e);
        }
    }

    @Override
    @RolesAllowed("test")
    public BlogPost findBlogPostById(Long id) throws ServiceException {
        try {
            return blogPostDao.findById(id);
        }
        catch (RepositoryException e) {
            LOG.error("findBlogPostById failed", e);
            throw new ServiceException("findBlogPostById failed", e);
        }
    }

    @Override
    @RolesAllowed("test")
    public void createBlogPost(BlogPost blogPost) throws ServiceException {
        try {
            blogPostDao.create(blogPost);
        }
        catch (RepositoryException e) {
            LOG.error("createBlogPost failed", e);
            throw new ServiceException("createBlogPost failed", e);
        }
    }

    @Override
    public Collection<BlogPost> findBlogPostByTitle(String title) throws ServiceException {
        try {
            return blogPostDao.findByTitle(title);
        }
        catch (RepositoryException e) {
            LOG.error("findBlogPostByTitle failed", e);
            throw new ServiceException("findBlogPostByTitle failed", e);
        }
    }
}
