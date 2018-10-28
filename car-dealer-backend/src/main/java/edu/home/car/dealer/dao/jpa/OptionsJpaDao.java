package edu.home.car.dealer.dao.jpa;

import edu.home.car.dealer.dao.OptionsDao;
import edu.home.car.dealer.dao.PersonDao;
import edu.home.car.dealer.model.Options;
import edu.home.car.dealer.model.Person;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OptionsJpaDao extends AbstractJpaDao<Options> implements OptionsDao {

    public OptionsJpaDao() {
        super(Options.class);
    }
}
