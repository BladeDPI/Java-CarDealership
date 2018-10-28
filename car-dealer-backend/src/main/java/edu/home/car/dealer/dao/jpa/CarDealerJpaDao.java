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
        final TypedQuery<CarDeal> query = entityManager.createNamedQuery(CarDeal.FIND_BY_TITLE, CarDeal.class);
        query.setParameter("title", title);
        return query.getResultList();
    }

}
