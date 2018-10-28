package edu.home.car.dealer.freemarker;

import edu.home.car.dealer.CarDto;
import edu.home.car.dealer.PersonDto;

import java.util.Date;

public class CarDtoFreemarker {

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
    private PersonDto seller;
    private OptionDtoFreemarker options;

    public CarDtoFreemarker(CarDto carDto){
        this.id = carDto.getId();
        this.title = carDto.getTitle();
        this.price = carDto.getPrice();
        this.make = carDto.getMake();
        this.model = carDto.getModel();
        this.trim = carDto.getTrim();
        this.km = carDto.getKm();
        this.year = carDto.getYear();
        this.fuelType = carDto.getFuelType();
        this.bodyType = carDto.getBodyType();
        this.color = carDto.getColor();
        this.city = carDto.getCity();
        this.power = carDto.getPower();
        this.transmission = carDto.getTransmission();
        this.uploadDate = carDto.getUploadDate();
        this.seller = carDto.getSeller();
        this.options = new OptionDtoFreemarker((carDto.getOptions()));
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

    public PersonDto getSeller() {
        return seller;
    }

    public void setSeller(PersonDto seller) {
        this.seller = seller;
    }

    public OptionDtoFreemarker getOptions() {
        return options;
    }

    public void setOptions(OptionDtoFreemarker options) {
        this.options = options;
    }
}
