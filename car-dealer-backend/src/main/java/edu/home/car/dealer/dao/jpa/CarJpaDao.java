package edu.home.car.dealer.dao.jpa;

import edu.home.car.dealer.dao.CarDao;
import edu.home.car.dealer.dao.RepositoryException;
import edu.home.car.dealer.model.Car;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.TypedQuery;
import java.util.Collection;

@ApplicationScoped
public class CarJpaDao extends AbstractJpaDao<Car> implements CarDao {

    public CarJpaDao() {
        super(Car.class);
    }

    @Override
    public Collection<Car> findAllAvailable(){
        final TypedQuery<Car> query = entityManager.createNamedQuery(Car.FIND_ALL_AVAILABLE, Car.class);
        return query.getResultList();
    }


    @Override
    public Collection<Car> findByTitle(String title) throws RepositoryException {
        final TypedQuery<Car> query = entityManager.createNamedQuery(Car.FIND_BY_TITLE, Car.class);
        query.setParameter("title", title);
        return query.getResultList();
    }

}
