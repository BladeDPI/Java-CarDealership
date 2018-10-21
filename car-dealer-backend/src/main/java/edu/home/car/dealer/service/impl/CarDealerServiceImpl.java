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
@DeclareRoles({"test", "blogPost"})
//@ApplicationScoped
public class CarDealerServiceImpl implements CarDealerService {
    private static final Logger LOG = LoggerFactory.getLogger(CarDealerServiceImpl.class);

    @Inject
    private CarDealerDao carDealerDao;

    @Override
    @PermitAll
    public Collection<CarDeal> findAllBlogPosts() throws ServiceException {
        try {
            return carDealerDao.findAll();
        }
        catch (RepositoryException e) {
            LOG.error("findAllBlogPosts failed", e);
            throw new ServiceException("findAllBlogPosts failed", e);
        }
    }

    @Override
    @RolesAllowed("test")
    public CarDeal findBlogPostById(Long id) throws ServiceException {
        try {
            return carDealerDao.findById(id);
        }
        catch (RepositoryException e) {
            LOG.error("findBlogPostById failed", e);
            throw new ServiceException("findBlogPostById failed", e);
        }
    }

    @Override
    @RolesAllowed("test")
    public void createBlogPost(CarDeal carDeal) throws ServiceException {
        try {
            carDealerDao.create(carDeal);
        }
        catch (RepositoryException e) {
            LOG.error("createBlogPost failed", e);
            throw new ServiceException("createBlogPost failed", e);
        }
    }

    @Override
    public Collection<CarDeal> findBlogPostByTitle(String title) throws ServiceException {
        try {
            return carDealerDao.findByTitle(title);
        }
        catch (RepositoryException e) {
            LOG.error("findBlogPostByTitle failed", e);
            throw new ServiceException("findBlogPostByTitle failed", e);
        }
    }
}
