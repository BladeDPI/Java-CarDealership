package edu.home.car.dealer.dao.jpa;

import edu.home.car.dealer.dao.PersonDao;
import edu.home.car.dealer.model.Person;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.TypedQuery;
import java.util.List;

@ApplicationScoped
public class PersonJpaDao extends AbstractJpaDao<Person> implements PersonDao {

    public PersonJpaDao() {
        super(Person.class);
    }

    @Override
    public Person findPersonByProfileName(String profileName) {
        final TypedQuery<Person> query = entityManager.createNamedQuery(Person.FIND_BY_PROFILE_NAME, Person.class);
        query.setParameter("profileName", profileName);
        final List<Person> list = query.getResultList();
        return list.size() == 0 ? null : list.get(0);
    }
}
