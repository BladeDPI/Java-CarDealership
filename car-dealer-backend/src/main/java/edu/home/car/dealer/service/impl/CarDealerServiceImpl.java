package edu.home.car.dealer.service.impl;

import edu.home.car.dealer.dao.CarDealerDao;
import edu.home.car.dealer.dao.RepositoryException;
import edu.home.car.dealer.model.CarDeal;
import edu.home.car.dealer.service.CarDealerService;
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
public class CarDealerServiceImpl implements CarDealerService {
    private static final Logger LOG = LoggerFactory.getLogger(CarDealerServiceImpl.class);

    @Inject
    private CarDealerDao carDealerDao;

    @Override
    @PermitAll
    public Collection<CarDeal> findAllCarDeals() throws ServiceException {
        try {
            return carDealerDao.findAll();
        }
        catch (RepositoryException e) {
            LOG.error("findAllCarDeals failed", e);
            throw new ServiceException("findAllCarDeals failed", e);
        }
    }

    @Override
    @RolesAllowed("test")
    public CarDeal findCarDealById(Long id) throws ServiceException {
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
    public void createCarDeal(CarDeal carDeal) throws ServiceException {
        try {
            carDealerDao.create(carDeal);
        }
        catch (RepositoryException e) {
            LOG.error("createCarDeal failed", e);
            throw new ServiceException("createCarDeal failed", e);
        }
    }

    @Override
    public Collection<CarDeal> findCarDealByTitle(String title) throws ServiceException {
        try {
            return carDealerDao.findByTitle(title);
        }
        catch (RepositoryException e) {
            LOG.error("findCarDealByTitle failed", e);
            throw new ServiceException("findCarDealByTitle failed", e);
        }
    }
}
