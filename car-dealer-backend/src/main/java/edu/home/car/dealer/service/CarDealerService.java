package edu.home.car.dealer.service;

import edu.home.car.dealer.model.CarDeal;

import java.util.Collection;

public interface CarDealerService {

    Collection<CarDeal> findAllCarDeals();

    CarDeal findCarDealById(Long id);

    void createCarDeal(CarDeal carDeal);

    Collection<CarDeal> findCarDealByTitle(String title);
}
