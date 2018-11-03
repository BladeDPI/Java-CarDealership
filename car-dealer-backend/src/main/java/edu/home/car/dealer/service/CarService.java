package edu.home.car.dealer.service;

import edu.home.car.dealer.model.Car;

import java.util.Collection;

public interface CarService {

    Collection<Car> findAllAvailable();

    Car findCarDealById(Long id);

    void createCarDeal(Car carDeal);

    Car sellCar(Car car, String profileName);
}
