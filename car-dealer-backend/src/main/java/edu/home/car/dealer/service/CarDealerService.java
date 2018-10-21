package edu.home.car.dealer.service;

import edu.home.car.dealer.model.CarDeal;

import java.util.Collection;

public interface CarDealerService {

    Collection<CarDeal> findAllCarDeals() throws ServiceException;

    CarDeal findCarDealById(Long id) throws ServiceException;

    void createCarDeal(CarDeal carDeal) throws ServiceException;

    Collection<CarDeal> findCarDealByTitle(String title) throws ServiceException;
}
