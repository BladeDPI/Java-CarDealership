package edu.home.car.dealer.service.impl;

import edu.home.car.dealer.dao.PersonDao;
import edu.home.car.dealer.dao.RepositoryException;
import edu.home.car.dealer.model.Person;
import edu.home.car.dealer.service.PersonService;
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
@DeclareRoles("carDealer")
public class PersonServiceImpl implements PersonService {
    private final Logger LOG = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Inject
    private PersonDao personDao;

    @Override
    @PermitAll
    public Collection<Person> findAllPersons() throws ServiceException {
        try {
            return personDao.findAll();
        } catch (RepositoryException e) {
            LOG.error("findAllPersons failed", e);
            throw new ServiceException("findAllPersons failed", e);
        }
    }

    @Override
    @RolesAllowed("carDealer")
    public Person findPersonByProfileName(String profileName) throws ServiceException {
        try {
            return personDao.findPersonByProfileName(profileName);
        } catch (RepositoryException e) {
            LOG.error("findPersonByProfileName failed", e);
            throw new ServiceException("findPersonByProfileName failed", e);
        }
    }

    @Override
    @RolesAllowed("carDealer")
    public void createPerson(Person person) throws ServiceException {
        try {
            personDao.create(person);
        } catch (RepositoryException e) {
            LOG.error("create Person failed", e);
            throw new ServiceException("create Person failed", e);
        }
    }
}
