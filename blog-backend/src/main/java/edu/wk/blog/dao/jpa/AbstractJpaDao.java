/*
 * *************************************************************************
 * Copyright (C) Wolters Kluwer Financial Services. All rights reserved.
 *
 * This computer program is protected by copyright law and international
 * treaties. Unauthorized reproduction or distribution of this program,
 * or any portion of it, may result in severe civil and criminal penalties,
 * and will be prosecuted to the maximum extent possible under the law.
 * *************************************************************************
 */
package edu.wk.blog.dao.jpa;

import edu.wk.blog.dao.Dao;
import edu.wk.blog.dao.RepositoryException;
import edu.wk.blog.model.BaseEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

public abstract class AbstractJpaDao<T extends BaseEntity> implements Dao<T> {
    private static final Logger LOG = LoggerFactory.getLogger(AbstractJpaDao.class);
    private Class<T> clazz;

    @PersistenceContext(unitName = "blogPu")
    protected EntityManager entityManager;

    public AbstractJpaDao(final Class<T> clazz) {
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
            TypedQuery<T> query = entityManager.createQuery("from " + clazz.getSimpleName(), clazz);
            List<T> ret = query.getResultList();
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

}
