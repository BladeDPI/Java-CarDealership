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
import java.io.IOException;
import java.util.Collection;

@Stateless
@DeclareRoles("carDealer")
public class PersonServiceImpl implements PersonService {
    private final Logger LOG = LoggerFactory.getLogger(PersonServiceImpl.class);

    @Inject
    private PersonDao personDao;

    @Override
    @RolesAllowed("carDealer")
    public Collection<Person> findAllPersons() throws ServiceException {
        try {
            return personDao.findAll();
        } catch (RepositoryException e) {
            LOG.error("findAllPersons failed", e);
            throw new ServiceException("findAllPersons failed", e);
        }
    }

    @Override
    @PermitAll
    public Person findPersonByProfileName(String profileName) throws ServiceException {
        try {
            return personDao.findPersonByProfileName(profileName);
        } catch (RepositoryException e) {
            LOG.error("findPersonByProfileName failed", e);
            throw new ServiceException("findPersonByProfileName failed", e);
        }
    }

    @Override
    @PermitAll
    public void createPerson(Person person) throws ServiceException {
        try {
            personDao.create(person);

            addToWebContainer(person);
        } catch (RepositoryException e) {
            LOG.error("create Person failed", e);
            throw new ServiceException("create Person failed", e);
        } catch (IOException e) {
            LOG.error("Command to add Person failed", e);
            throw new ServiceException("Command to add Person failed", e);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void addToWebContainer(Person person) throws IOException, InterruptedException {
        final ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c",  "start", "/b", "add-user.bat", "-a", person.getProfileName(), person.getPassword(), "-g", "carDealer");
        processBuilder.redirectErrorStream(true);
        final Process p = processBuilder.start();
        p.waitFor();
    }
}
