package edu.home.car.dealer.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Car")
@NamedQueries({
        @NamedQuery(name = Car.FIND_ALL_AVAILABLE, query = "from Car c where c.sold = false")
})
public class Car extends BaseEntity {

    public static final String FIND_ALL_AVAILABLE = "Car.findAllAvailable";

    @Column
    private String title;
    @Column
    private int price;
    @Column
    private String make;
    @Column
    private String model;
    @Column
    private String trim;
    @Column
    private int km;
    @Column
    private int year;
    @Column
    private String fuelType;
    @Column
    private String bodyType;
    @Column
    private String color;
    @Column
    private String city;
    @Column
    private int power;
    @Column
    private String transmission;
    @Column
    private Date uploadDate;
    @Column
    private boolean sold;

    @JsonManagedReference
    @ManyToOne (cascade=CascadeType.ALL)
    private Person person;

    @JsonManagedReference
    @OneToOne (cascade=CascadeType.ALL)
    private Options options;

    public Car() {
    }

    private Car(String title, int price, String make, String model, String trim, int km, int year, String fuelType, String bodyType, String color, String city, int power, String transmission, Date uploadDate, Person person, Options options) {
        this.title = title;
        this.price = price;
        this.make = make;
        this.model = model;
        this.trim = trim;
        this.km = km;
        this.year = year;
        this.fuelType = fuelType;
        this.bodyType = bodyType;
        this.color = color;
        this.city = city;
        this.power = power;
        this.transmission = transmission;
        this.uploadDate = uploadDate;
        this.person = person;
        this.options = options;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTrim() {
        return trim;
    }

    public void setTrim(String trim) {
        this.trim = trim;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getBodyType() {
        return bodyType;
    }

    public void setBodyType(String bodyType) {
        this.bodyType = bodyType;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public boolean isSold() {
        return sold;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Options getOptions() {
        return options;
    }

    public void setOptions(Options options) {
        this.options = options;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price='" + price + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", km='" + km + '\'' +
                ", year='" + year + '\'' +
                ", fuelType='" + fuelType + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", color='" + color + '\'' +
                ", city='" + city + '\'' +
                ", power='" + power + '\'' +
                ", transmission='" + transmission + '\'' +
                ", uploadDate=" + uploadDate +
                ", sold=" + sold +
                '}';
    }

    public static class CarBuilder {
        private String title;
        private int price;
        private String make;
        private String model;
        private String trim;
        private int km;
        private int year;
        private String fuelType;
        private String bodyType;
        private String color;
        private String city;
        private int power;
        private String transmission;
        private Date uploadDate;
        private Person person;
        private Options options;

        public CarBuilder price(int price) {
            this.price = price;
            return this;
        }

        public CarBuilder make(String make) {
            this.make = make;
            return this;
        }

        public CarBuilder model(String model) {
            this.model = model;
            return this;
        }

        public CarBuilder trim(String trim) {
            this.trim = trim;
            return this;
        }

        public CarBuilder km(int km) {
            this.km = km;
            return this;
        }

        public CarBuilder year(int year) {
            this.year = year;
            return this;
        }

        public CarBuilder fuelType(String fuelType) {
            this.fuelType = fuelType;
            return this;
        }

        public CarBuilder bodyType(String bodyType) {
            this.bodyType = bodyType;
            return this;
        }

        public CarBuilder color(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder city(String city) {
            this.city = city;
            return this;
        }

        public CarBuilder power(int power) {
            this.power = power;
            return this;
        }

        public CarBuilder transmission(String transmission) {
            this.transmission = transmission;
            return this;
        }

        public CarBuilder uploadDate(Date uploadDate) {
            this.uploadDate = uploadDate;
            return this;
        }

        public CarBuilder person(Person person) {
            this.person = person;
            return this;
        }

        public CarBuilder options(Options options) {
            this.options = options;
            return this;
        }

        public Car createCar() {

            title = year + " " + make + " " + model + " " + trim;

            if (isNotValid()) {
                throw new IllegalStateException("Every filed must be filled.");
            }

            return new Car(
                    title, price, make, model, trim, km, year, fuelType, bodyType,
                    color, city, power, transmission, uploadDate, person, options);
        }

        private boolean isNotValid() {
            return Objects.isNull(title) ||
                    Objects.isNull(price) ||
                    Objects.isNull(make) ||
                    Objects.isNull(model) ||
                    Objects.isNull(trim) ||
                    Objects.isNull(km) ||
                    Objects.isNull(year) ||
                    Objects.isNull(fuelType) ||
                    Objects.isNull(bodyType) ||
                    Objects.isNull(color) ||
                    Objects.isNull(city) ||
                    Objects.isNull(power) ||
                    Objects.isNull(transmission) ||
                    Objects.isNull(uploadDate) ||
                    Objects.isNull(options);
        }
    }
}
