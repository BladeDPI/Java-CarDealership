package edu.home.car.dealer.service.impl;

import edu.home.car.dealer.dao.CarDao;
import edu.home.car.dealer.dao.RepositoryException;
import edu.home.car.dealer.model.Car;
import edu.home.car.dealer.service.CarService;
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
@DeclareRoles({"test", "carDealer"})
public class CarServiceImpl implements CarService {
    private final Logger LOG = LoggerFactory.getLogger(CarServiceImpl.class);

    @Inject
    private CarDao carDealerDao;

    @Override
    @PermitAll
    public Collection<Car> findAllAvailable() throws ServiceException {
        try {
            return carDealerDao.findAllAvailable();
        }
        catch (RepositoryException e) {
            LOG.error("findAllCarDeals failed", e);
            throw new ServiceException("findAllCarDeals failed", e);
        }
    }

    @Override
    @RolesAllowed("test")
    public Car findCarDealById(Long id) throws ServiceException {
        try {
            return carDealerDao.findById(id);
        }
        catch (RepositoryException e) {
            LOG.error("findCarDealById failed", e);
            throw new ServiceException("findCarDealById failed", e);
        }
    }

    @Override
    @RolesAllowed("test")
    public void createCarDeal(Car carDeal) throws ServiceException {
        try {
            carDealerDao.create(carDeal);
        }
        catch (RepositoryException e) {
            LOG.error("createCar failed", e);
            throw new ServiceException("createCar failed", e);
        }
    }

    @Override
    public Collection<Car> findCarDealByTitle(String title) throws ServiceException {
        try {
            return carDealerDao.findByTitle(title);
        }
        catch (RepositoryException e) {
            LOG.error("findCarDealByTitle failed", e);
            throw new ServiceException("findCarDealByTitle failed", e);
        }
    }
}
