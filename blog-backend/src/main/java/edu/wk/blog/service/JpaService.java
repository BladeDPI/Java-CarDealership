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
package edu.wk.blog.service;

import edu.wk.blog.dao.BlogPostDao;
import edu.wk.blog.model.BlogPost;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

public class JpaService {

    //    EntityManagerFactory entityManagerFactory;
    //
    //    public JpaService() {
    //        this.entityManagerFactory = Persistence.createEntityManagerFactory("blogPuLocal");
    //    }
    //
    //    public static void main(String[] args) {
    //        final JpaService jpaService = new JpaService();
    //        final EntityManager entityManager = jpaService.getEntityManager();
    //
    //        final BlogPost blogPost = new BlogPost();
    //        blogPost.setTitle("semmi");
    //        blogPost.setWriter("senki");
    //        blogPost.setContent("jrklegfergfykgw");
    //        blogPost.setUploadDate(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
    //
    //        entityManager.getTransaction().begin();
    //        entityManager.persist(blogPost);
    //        entityManager.getTransaction().commit();
    //
    //        System.out.println("kisjoker");
    //        final BlogPost blogPost1 = entityManager.find(BlogPost.class, 1L);
    //        System.out.println(blogPost1.toString());
    //    }
    //
    //    public EntityManager getEntityManager() {
    //        return entityManagerFactory.createEntityManager();
    //    }

//    @Inject
//    BlogPostDao blogPostDao;
//
//    public BlogPostDao getBlogPostDao() {
//        return blogPostDao;
//    }
//
//    public static void main(String[] args) {
//        final BlogPost blogPost = new BlogPost();
//        blogPost.setTitle("semmi");
//        blogPost.setWriter("senki");
//        blogPost.setContent("jrklegfergfykgw");
//        blogPost.setUploadDate(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
//
//        final BlogPostDao blogPostDao = new JpaService().getBlogPostDao();
//        blogPostDao.create(blogPost);
//
//        System.out.println("kisjoker");
//        final BlogPost byId = blogPostDao.findById(1L);
//        System.out.println(byId.toString());
//    }
}