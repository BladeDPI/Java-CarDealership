package edu.home.car.dealer.util;

import edu.home.car.dealer.dao.CarDao;
import edu.home.car.dealer.dao.Dao;
import edu.home.car.dealer.dao.PersonDao;
import edu.home.car.dealer.model.Car;
import edu.home.car.dealer.model.Person;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Singleton
@Startup
public class DataInitialization {

    @Inject
    private PersonDao personDao;

    @Inject
    private CarDao carDao;


    @PostConstruct
    private void init() {

        Person sellerOne = new Person("DokaIstvan", "Doka", "Istvan", "5678", "Kolozsvar");
        Car carDealOne = createCarDeals(5_400, "Mercedes Benz", "Ml-Class", "320 CDI", 240_000, 2006, "Diesel", "Suv", "Silver", "Arad", 165, "Automatic", sellerOne);
        sellerOne.getCars().add(carDealOne);
        carDao.create(carDealOne);
        personDao.create(sellerOne);
        

        Person sellerTwo = new Person("PeterParker", "Peter", "Parker", "7821", "New York");
        Car carDealTwo = createCarDeals(19_300, "Audi", "A6", "2.0 TDI", 86_500, 2013, "Diesel", "Sedan", "Gold", "Cluj Napoca", 131, "Automatic", sellerTwo);
        sellerTwo.getCars().add(carDealTwo);
        carDao.create(carDealTwo);
        personDao.create(sellerTwo);
    }

    private Car createCarDeals(int price, String make, String model, String trim, int km, int year, String fuelType, String bodyType, String color, String city, int power, String transmission, Person seller) {
        final Car.CarBuilder carDealBuilder=  new Car.CarBuilder();
        carDealBuilder.price(price).make(make).model(model).trim(trim).km(km)
                .year(year).fuelType(fuelType).bodyType(bodyType).color(color).city(city)
                .power(power).transmission(transmission).uploadDate(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)))
                .seller(seller);
        return carDealBuilder.createCar();
    }
}