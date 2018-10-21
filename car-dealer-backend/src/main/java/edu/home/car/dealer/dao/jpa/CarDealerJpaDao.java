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
package edu.home.car.dealer.dao.jpa;

import edu.home.car.dealer.dao.CarDealerDao;
import edu.home.car.dealer.dao.RepositoryException;
import edu.home.car.dealer.model.CarDeal;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.TypedQuery;
import java.util.Collection;

@ApplicationScoped
public class CarDealerJpaDao extends AbstractJpaDao<CarDeal> implements CarDealerDao {

    public CarDealerJpaDao() {
        super(CarDeal.class);
    }

    @Override
    public Collection<CarDeal> findByTitle(String title) throws RepositoryException {
        TypedQuery<CarDeal> query = entityManager.createNamedQuery(CarDeal.FIND_BY_TITLE, CarDeal.class);
        query.setParameter("title", title);
        return query.getResultList();
    }

}
