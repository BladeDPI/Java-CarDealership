package edu.home.car.dealer.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "Person")
@NamedQueries({
        @NamedQuery(name = Person.FIND_BY_PROFILE_NAME, query = "from Person p where p.profileName like :profileName")
})
public class Person extends BaseEntity {

    public static final String FIND_BY_PROFILE_NAME = "Person.findByProfileName";

    @Column
    private String profileName;
    @Column
    private String firstName;
    @Column
    private String secondName;
    @Column
    private String idCardNumber;
    @Column
    private String email;
    @Column
    private String phoneNumber;
    @Column
    private String city;

    @JsonBackReference
    @OneToMany(mappedBy="person",cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Car> cars = new ArrayList<>();

    public Person(){
    }

    public Person(String profileName, String firstName, String secondName, String idCardNumber, String email, String phoneNumber, String city) {
        this.profileName = profileName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.idCardNumber = idCardNumber;
        this.idCardNumber = email;
        this.idCardNumber = phoneNumber;
        this.city = city;
    }

    public String getProfileName() {
        return profileName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getIdCardNumber() {
        return idCardNumber;
    }

    public void setIdCardNumber(String idCardNumber) {
        this.idCardNumber = idCardNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                "profileName=" + profileName +
                "firstName=" + firstName +
                "secondName=" + secondName +
                "idCardNumber=" + idCardNumber +
                "email=" + email +
                "phoneNumber=" + phoneNumber +
                "city=" + city +
                "cars=" + cars +
                '}';
    }

    public static class PersonBuilder {
        private String profileName;
        private String firstName;
        private String secondName;
        private String idCardNumber;
        private String email;
        private String phoneNumber;
        private String city;

        public PersonBuilder profileName(String profileName) {
            this.profileName = profileName;
            return this;
        }

        public PersonBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonBuilder secondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public PersonBuilder idCardNumber(String cnp) {
            this.idCardNumber = cnp;
            return this;
        }

        public PersonBuilder email(String email) {
            this.email = email;
            return this;
        }

        public PersonBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public PersonBuilder city(String city) {
            this.city = city;
            return this;
        }

        public Person createPerson() {

            if (isNotValid()) {
                throw new IllegalStateException("Every filed must be filled.");
            }

            return new Person(firstName, secondName, idCardNumber, email, phoneNumber, city, profileName);
        }

        private boolean isNotValid() {
            return Objects.isNull(firstName) ||
                    Objects.isNull(secondName) ||
                    Objects.isNull(idCardNumber) ||
                    Objects.isNull(email) ||
                    Objects.isNull(phoneNumber) ||
                    Objects.isNull(city) ||
                    Objects.isNull(profileName);
        }
    }
}

