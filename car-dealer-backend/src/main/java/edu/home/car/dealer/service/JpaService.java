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
package edu.home.car.dealer.service;

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
    //        final CarDeal blogPost = new CarDeal();
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
    //        final CarDeal blogPost1 = entityManager.find(CarDeal.class, 1L);
    //        System.out.println(blogPost1.toString());
    //    }
    //
    //    public EntityManager getEntityManager() {
    //        return entityManagerFactory.createEntityManager();
    //    }

//    @Inject
//    CarDealerDao blogPostDao;
//
//    public CarDealerDao getBlogPostDao() {
//        return blogPostDao;
//    }
//
//    public static void main(String[] args) {
//        final CarDeal blogPost = new CarDeal();
//        blogPost.setTitle("semmi");
//        blogPost.setWriter("senki");
//        blogPost.setContent("jrklegfergfykgw");
//        blogPost.setUploadDate(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
//
//        final CarDealerDao blogPostDao = new JpaService().getBlogPostDao();
//        blogPostDao.create(blogPost);
//
//        System.out.println("kisjoker");
//        final CarDeal byId = blogPostDao.findById(1L);
//        System.out.println(byId.toString());
//    }
}