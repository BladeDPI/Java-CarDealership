package edu.home.car.dealer.dao;

import edu.home.car.dealer.model.Car;

import java.util.Collection;

public interface CarDao extends  Dao<Car> {

    Collection<Car> findByTitle(String title);
}
