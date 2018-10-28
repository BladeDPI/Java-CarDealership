package edu.home.car.dealer.util;

import edu.home.car.dealer.dao.CarDealerDao;
import edu.home.car.dealer.model.CarDeal;

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
    private CarDealerDao carDealerDao;

    @PostConstruct
    private void init() {

        carDealerDao.create(createCarDeals(5_400, "Mercedes Benz", "Ml-Class", "320 CDI", 240_000, 2006, "Diesel", "Suv", "Silver", "Arad", 165, "Automatic", "GiGi"));
        carDealerDao.create(createCarDeals(19_300, "Audi", "A6", "2.0 TDI", 86_500, 2013, "Diesel", "Sedan", "Gold", "Cluj Napoca", 131, "Automatic", "JoJo"));
    }

    private CarDeal createCarDeals(int price, String make, String model, String trim, int km, int year, String fuelType, String bodyType, String color, String city, int power, String transmission, String writer) {
        final CarDeal.CarDealBuilder carDealBuilder=  new CarDeal.CarDealBuilder();
        carDealBuilder.price(price).make(make).model(model).trim(trim).km(km)
                .year(year).fuelType(fuelType).bodyType(bodyType).color(color).city(city)
                .power(power).transmission(transmission).uploadDate(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)))
                .writer(writer);
        return carDealBuilder.createCarDeal();
    }
}