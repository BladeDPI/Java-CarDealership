package edu.home.car.dealer.dao.jpa;

import edu.home.car.dealer.dao.PersonDao;
import edu.home.car.dealer.model.Person;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PersonJpaDao extends AbstractJpaDao<Person> implements PersonDao {

    public PersonJpaDao() {
        super(Person.class);
    }
}
