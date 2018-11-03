package edu.home.car.dealer.dao.jpa;

import edu.home.car.dealer.dao.RepositoryException;
import edu.home.car.dealer.dao.Dao;
import edu.home.car.dealer.model.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

public abstract class AbstractJpaDao<T extends BaseEntity> implements Dao<T> {
    private final Logger LOG = LoggerFactory.getLogger(AbstractJpaDao.class);
    private final Class<T> clazz;

    @PersistenceContext(unitName = "carDealPu")
    protected EntityManager entityManager;

    AbstractJpaDao(final Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T findById(Long id) throws RepositoryException {
        try {
            return entityManager.find(clazz, id);
        } catch (IllegalArgumentException e) {
            LOG.error("findById failed", e);
            throw new RepositoryException("findById failed", e);
        }
    }

    @Override
    public List<T> findAll() throws RepositoryException {
        try {
            final TypedQuery<T> query = entityManager.createQuery("from " + clazz.getSimpleName(), clazz);
            final List<T> ret = query.getResultList();
            LOG.info("Found {} instances of {}", ret.size(), clazz.getSimpleName());
            return ret;
        } catch (IllegalStateException | IllegalArgumentException | PersistenceException e) {
            LOG.error("findAll failed", e);
            throw new RepositoryException("findAll failed", e);
        }
    }

    @Override
    @Transactional
    public void create(T obj) throws RepositoryException {
        LOG.info("Creating {} {}", clazz.getSimpleName(), obj);
        try {
            entityManager.persist(obj);
            entityManager.flush();
        } catch (PersistenceException | IllegalArgumentException e) {
            LOG.error("create failed", e);
            throw new RepositoryException("create failed", e);
        }
    }

    @Override
    @Transactional
    public void save(T obj) throws RepositoryException {
        LOG.info("Saving {} {}", clazz.getSimpleName(), obj);
        try {
            entityManager.merge(obj);
            entityManager.flush();
        } catch (PersistenceException | IllegalArgumentException e) {
            LOG.error("save failed", e);
            throw new RepositoryException("save failed", e);
        }
    }

}
