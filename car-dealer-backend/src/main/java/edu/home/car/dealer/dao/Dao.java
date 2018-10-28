package edu.home.car.dealer.dao;

import edu.home.car.dealer.model.BaseEntity;

import java.util.Collection;

public interface Dao<T extends BaseEntity> {

    void create(T obj) throws RepositoryException;

    Collection<T> findAll() throws RepositoryException;

    T findById(Long id) throws RepositoryException;
}
