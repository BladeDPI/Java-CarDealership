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

        final Person isti = new Person("DokaIstvan", "Doka", "Istvan", "5678", "istvan_doka@yahoo.com", "0741085087", "Kolozsvar", "isti");
        final Options merciOption = createOptions(true, false, true, true, true, false, true, true, false, true, true);
        final Car merci = createCarDeals(5_400, "Mercedes Benz", "Ml-Class", "320 CDI", 240_000, 2006, "Diesel", "Suv", "Silver", "Arad", 165, "Automatic", isti, merciOption);
        isti.getCars().add(merci);
        merciOption.setCar(merci);

        carDao.create(merci);
        optionsDao.create(merciOption);
        personDao.create(isti);

        final Person parker = new Person("PeterParker", "Peter", "Parker", "siderman@gmail.com", "532", "7821", "New York", "web");
        final Options audiOption= createOptions(false, true, false, true, false, false, true, true, true, true, true);
        final Car audi = createCarDeals(19_300, "Audi", "A6", "2.0 TDI", 86_500, 2013, "Diesel", "Sedan", "Gold", "Cluj Napoca", 131, "Automatic", parker, audiOption);
        parker.getCars().add(audi);
        audiOption.setCar(audi);

        carDao.create(audi);
        optionsDao.create(audiOption);
        personDao.create(parker);


        final Person wayne = new Person("BruceWayne", "Bruce", "Wayne", "batman@gmail.com", "652" , "3652", "Gotham", "bat");
        final Options batMobilOption = createOptions(true, true, true, true, true, true, true, true, true, true, true);
        final Car batMobil = createCarDeals(1_000_000, "Wayne Industry", "BatMobil", "Tank", 100_500, 2018, "Diesel", "Tank", "Black", "Gotham", 1_000, "Automatic", wayne, batMobilOption);
        wayne.getCars().add(batMobil);
        batMobilOption.setCar(batMobil);
        batMobil.setSold(true);

        carDao.create(batMobil);
        optionsDao.create(batMobilOption);
        personDao.create(wayne);
    }

    private Options createOptions(boolean abs, boolean airbag, boolean alarm, boolean alloyWheels, boolean centralLocking, boolean cruiseControl, boolean electricMirrors, boolean electricWindows, boolean tripComputer, boolean leather, boolean powerSteering) {
        final Options.OptionBuilder optionBuilder =  new Options.OptionBuilder();
        optionBuilder.abs(abs).airbag(airbag).alarm(alarm).alloyWheels(alloyWheels).centralLocking(centralLocking)
                .cruiseControl(cruiseControl).electricMirrors(electricMirrors).electricWindows(electricWindows).
                tripComputer(tripComputer).leather(leather).powerSteering(powerSteering);
        return optionBuilder.createOption();
    }

    private Car createCarDeals(int price, String make, String model, String trim, int km, int year, String fuelType, String bodyType, String color, String city, int power, String transmission, Person person, Options options) {
        final Car.CarBuilder carDealBuilder=  new Car.CarBuilder();
        carDealBuilder.price(price).make(make).model(model).trim(trim).km(km)
                .year(year).fuelType(fuelType).bodyType(bodyType).color(color).city(city)
                .power(power).transmission(transmission).uploadDate(Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC)))
                .person(person).options(options);
        return carDealBuilder.createCar();
    }
}