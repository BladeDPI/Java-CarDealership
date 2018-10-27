package edu.home.car.dealer.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "carDeal")
@NamedQueries({
        @NamedQuery(name = CarDeal.FIND_BY_TITLE, query = "from CarDeal bp where bp.title like :title")
})

public class CarDeal extends BaseEntity {

    public static final String FIND_BY_TITLE = "CarDeal.findByTitle";

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
    private String writer;

    public CarDeal(){
    }

    private CarDeal(String title, int price, String make, String model, String trim, int km, int year, String fuelType, String bodyType, String color, String city, int power, String transmission, Date uploadDate, String writer) {
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
        this.writer = writer;
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

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    @Override
    public String toString() {
        return "CarDeal{" +
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
                ", writer='" + writer + '\'' +
                '}';
    }

    public static class CarDealBuilder {
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
        private String writer;

        public CarDealBuilder() {

        }

        public CarDealBuilder price(int price) {
            this.price = price;
            return this;
        }

        public CarDealBuilder make(String make) {
            this.make = make;
            return this;
        }

        public CarDealBuilder model(String model) {
            this.model = model;
            return this;
        }

        public CarDealBuilder trim(String trim) {
            this.trim = trim;
            return this;
        }

        public CarDealBuilder km(int km) {
            this.km = km;
            return this;
        }

        public CarDealBuilder year(int year) {
            this.year = year;
            return this;
        }

        public CarDealBuilder fuelType(String fuelType) {
            this.fuelType = fuelType;
            return this;
        }

        public CarDealBuilder bodyType(String bodyType) {
            this.bodyType = bodyType;
            return this;
        }

        public CarDealBuilder color(String color) {
            this.color = color;
            return this;
        }

        public CarDealBuilder city(String city) {
            this.city = city;
            return this;
        }

        public CarDealBuilder power(int power) {
            this.power = power;
            return this;
        }

        public CarDealBuilder transmission(String transmission) {
            this.transmission = transmission;
            return this;
        }

        public CarDealBuilder uploadDate(Date uploadDate) {
            this.uploadDate = uploadDate;
            return this;
        }

        public CarDealBuilder writer(String writer) {
            this.writer = writer;
            return this;
        }

        public CarDeal createCarDeal() {

            title = year + " " + make + " " + model + " " + trim;

            if(isNotValie()){
                throw new IllegalStateException("Every filed must be filled.");
            }

            return new CarDeal(
                    title, price, make, model, trim, km, year, fuelType, bodyType,
                    color, city, power, transmission, uploadDate, writer);
        }

        private boolean isNotValie(){
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
                    Objects.isNull(writer);
        }
    }
}
