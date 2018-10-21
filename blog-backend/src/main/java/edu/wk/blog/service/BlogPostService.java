package edu.wk.blog.service;

import edu.wk.blog.model.BlogPost;

import java.util.Collection;

public interface BlogPostService {

    Collection<BlogPost> findAllBlogPosts() throws ServiceException;

    BlogPost findBlogPostById(Long id) throws ServiceException;

    void createBlogPost(BlogPost blogPost) throws ServiceException;

    Collection<BlogPost> findBlogPostByTitle(String title) throws ServiceException;
}
