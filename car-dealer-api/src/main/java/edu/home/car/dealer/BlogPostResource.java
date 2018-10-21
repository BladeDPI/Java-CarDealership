/*
 * *************************************************************************
 * Copyright (C) Wolters Kluwer Financial Services. All rights reserved.
 *
 * This computer program is protected by copyright law and international
 * treaties. Unauthorized reproduction or distribution of this program,
 * or any portion of it, may result in severe civil and criminal penalties,
 * and will be prosecuted to the maximum extent possible under the law.
 * *************************************************************************
 */
package edu.home.car.dealer;

import edu.home.car.dealer.model.BlogPost;
import edu.home.car.dealer.service.BlogPostService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;
import java.util.Collection;

@ApplicationScoped
@Path("/blogPosts")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
//@Produces("text/plain")
public class BlogPostResource {

    @Inject
    private BlogPostService blogPostService;

    @GET
    @Path("/")
    public Response findAll() {

        final Collection<BlogPost> allBlogPosts = blogPostService.findAllBlogPosts();
        ResponseBuilder builder = Response.ok(allBlogPosts);
        return builder.build();
    }

    @GET
    @Path("/{blogPostId}")
    public Response findBlogPostById(@PathParam("blogPostId") Long id) {
        final BlogPost blogPostById = blogPostService.findBlogPostById(id);
        ResponseBuilder builder = Response.ok(blogPostById);
        return builder.build();
    }

//    @POST
//    @Path("/")
//    public Response findBlogPostById(BlogPostDto blogPostDto) {

//        blogPostService.createBlogPost();
//        ResponseBuilder builder = Response.ok(blogPostById);
//        return builder.build();
//    }
}