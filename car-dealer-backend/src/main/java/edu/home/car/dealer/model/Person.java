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
    private String cnp;
    @Column
    private String city;

    @JsonBackReference
    @OneToMany(mappedBy="person",cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Car> cars = new ArrayList<>();

    public Person(){
    }

    public Person(String profileName, String firstName, String secondName, String cnp, String city) {
        this.profileName = profileName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.cnp = cnp;
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

    public String getCnp() {
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
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
                "cnp=" + cnp +
                "city=" + city +
                "cars=" + cars +
                '}';
    }

    public static class PersonBuilder {
        private String profileName;
        private String firstName;
        private String secondName;
        private String cnp;
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

        public PersonBuilder cnp(String cnp) {
            this.cnp = cnp;
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

            return new Person(firstName, secondName, cnp, city, profileName);
        }

        private boolean isNotValid() {
            return Objects.isNull(firstName) ||
                    Objects.isNull(secondName) ||
                    Objects.isNull(cnp) ||
                    Objects.isNull(city) ||
                    Objects.isNull(profileName);
        }
    }
}

