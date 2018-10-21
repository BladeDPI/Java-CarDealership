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
package edu.wk.blog.util;

import edu.wk.blog.dao.BlogPostDao;
import edu.wk.blog.model.BlogPost;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Singleton
@Startup
public class DataInitilization {
    @Inject
    private BlogPostDao blogPost;

    @PostConstruct
    private void init() {

        blogPost.create(createBlogPost("semmi", "senki", "jrklegfergfykgw"));
        blogPost.create(createBlogPost("123123", "24323", "234232"));
    }

    private BlogPost createBlogPost(String semmi, String senki, String jrklegfergfykgw) {
        final BlogPost blogPost = new BlogPost();
        blogPost.setTitle(semmi);
        blogPost.setWriter(senki);
        blogPost.setContent(jrklegfergfykgw);
        blogPost.setUploadDate(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
        return blogPost;
    }
}