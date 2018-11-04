package edu.home.car.dealer;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class CarDto implements Serializable {

    private Long id;
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
    private boolean sold;
    private PersonDto person;
    private OptionsDto options;

    public CarDto() {
    }

    public CarDto(String title, int price, String make, String model, String trim, int km, int year, String fuelType, String bodyType, String color, String city, int power, String transmission, OptionsDto options) {
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
        this.options = options;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public PersonDto getPerson() {
        return person;
    }

    public void setPerson(PersonDto person) {
        this.person = person;
    }

    public OptionsDto getOptions() {
        return options;
    }

    public void setOptions(OptionsDto options) {
        this.options = options;
    }

    public static class CarDtoBuilder {
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
        private OptionsDto optionsDto;

        public CarDtoBuilder price(int price) {
            this.price = price;
            return this;
        }

        public CarDtoBuilder make(String make) {
            this.make = make;
            return this;
        }

        public CarDtoBuilder model(String model) {
            this.model = model;
            return this;
        }

        public CarDtoBuilder trim(String trim) {
            this.trim = trim;
            return this;
        }

        public CarDtoBuilder km(int km) {
            this.km = km;
            return this;
        }

        public CarDtoBuilder year(int year) {
            this.year = year;
            return this;
        }

        public CarDtoBuilder fuelType(String fuelType) {
            this.fuelType = fuelType;
            return this;
        }

        public CarDtoBuilder bodyType(String bodyType) {
            this.bodyType = bodyType;
            return this;
        }

        public CarDtoBuilder color(String color) {
            this.color = color;
            return this;
        }

        public CarDtoBuilder city(String city) {
            this.city = city;
            return this;
        }

        public CarDtoBuilder power(int power) {
            this.power = power;
            return this;
        }

        public CarDtoBuilder transmission(String transmission) {
            this.transmission = transmission;
            return this;
        }

        public CarDtoBuilder optionsDto(OptionsDto optionsDto) {
            this.optionsDto = optionsDto;
            return this;
        }

        public CarDto createCarDto() {

            title = year + " " + make + " " + model + " " + trim;

            if (isNotValid()) {
                throw new IllegalStateException("Every filed must be filled.");
            }

            return new CarDto(title, price, make, model, trim, km, year, fuelType,
                    bodyType, color, city, power, transmission, optionsDto);
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
                    Objects.isNull(optionsDto);
        }
    }
}