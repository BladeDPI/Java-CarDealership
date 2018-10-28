package edu.home.car.dealer.dao;

import edu.home.car.dealer.model.CarDeal;

import java.util.Collection;

public interface CarDealerDao extends  Dao<CarDeal> {

    Collection<CarDeal> findByTitle(String title);
}
