package edu.wk.blog.dao;

import edu.wk.blog.model.BaseEntity;

import java.util.Collection;

/**
 * General "data access object" interface.
 * Provides common CRUD methods for entities.
 */
public interface Dao<T extends BaseEntity> {

    void create(T obj) throws RepositoryException;

    Collection<T> findAll() throws RepositoryException;

    T findById(Long id) throws RepositoryException;

    // ...
}
