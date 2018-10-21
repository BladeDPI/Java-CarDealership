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
package edu.home.car.dealer.util;

import edu.home.car.dealer.dao.CarDealerDao;
import edu.home.car.dealer.model.CarDeal;

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
    private CarDealerDao blogPost;

    @PostConstruct
    private void init() {

        blogPost.create(createBlogPost("semmi", "senki", "jrklegfergfykgw"));
        blogPost.create(createBlogPost("123123", "24323", "234232"));
    }

    private CarDeal createBlogPost(String semmi, String senki, String jrklegfergfykgw) {
        final CarDeal carDeal = new CarDeal();
        carDeal.setTitle(semmi);
        carDeal.setWriter(senki);
        carDeal.setContent(jrklegfergfykgw);
        carDeal.setUploadDate(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)));
        return carDeal;
    }
}