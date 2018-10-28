package edu.home.car.dealer.util;

import edu.home.car.dealer.dao.CarDao;
import edu.home.car.dealer.dao.OptionsDao;
import edu.home.car.dealer.dao.PersonDao;
import edu.home.car.dealer.model.Car;
import edu.home.car.dealer.model.Options;
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

    @Inject
    private OptionsDao optionsDao;


    @PostConstruct
    private void init() {

        final Person sellerOne = new Person("DokaIstvan", "Doka", "Istvan", "5678", "Kolozsvar");
        final Options optionsOne = createOptions(true, false, true, true, true, false, true, true, false, true, true);
        final Car carDealOne = createCarDeals(5_400, "Mercedes Benz", "Ml-Class", "320 CDI", 240_000, 2006, "Diesel", "Suv", "Silver", "Arad", 165, "Automatic", sellerOne, optionsOne);
        sellerOne.getCars().add(carDealOne);
        optionsOne.setCar(carDealOne);

        carDao.create(carDealOne);
        optionsDao.create(optionsOne);
        personDao.create(sellerOne);

        final Person sellerTwo = new Person("PeterParker", "Peter", "Parker", "7821", "New York");
        final Options optionsTwo= createOptions(false, true, false, true, false, false, true, true, true, true, true);
        final Car carDealTwo = createCarDeals(19_300, "Audi", "A6", "2.0 TDI", 86_500, 2013, "Diesel", "Sedan", "Gold", "Cluj Napoca", 131, "Automatic", sellerTwo, optionsTwo);
        sellerTwo.getCars().add(carDealTwo);
        optionsTwo.setCar(carDealTwo);

        carDao.create(carDealTwo);
        optionsDao.create(optionsTwo);
        personDao.create(sellerTwo);
    }

    private Options createOptions(boolean abs, boolean airbag, boolean alarm, boolean alloyWheels, boolean centralLocking, boolean cruiseControl, boolean electricMirrors, boolean electricWindows, boolean tripComputer, boolean leather, boolean powerSteering) {
        final Options.OptionBuilder optionBuilder =  new Options.OptionBuilder();
        optionBuilder.abs(abs).airbag(airbag).alarm(alarm).alloyWheels(alloyWheels).centralLocking(centralLocking)
                .cruiseControl(cruiseControl).electricMirrors(electricMirrors).electricWindows(electricWindows).
                tripComputer(tripComputer).leather(leather).powerSteering(powerSteering);
        return optionBuilder.createOption();
    }

    private Car createCarDeals(int price, String make, String model, String trim, int km, int year, String fuelType, String bodyType, String color, String city, int power, String transmission, Person seller, Options options) {
        final Car.CarBuilder carDealBuilder=  new Car.CarBuilder();
        carDealBuilder.price(price).make(make).model(model).trim(trim).km(km)
                .year(year).fuelType(fuelType).bodyType(bodyType).color(color).city(city)
                .power(power).transmission(transmission).uploadDate(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)))
                .seller(seller).options(options);
        return carDealBuilder.createCar();
    }
}