package edu.home.car.dealer;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class PersonDto implements Serializable {

    private Long id;
    private String profileName;
    private String firstName;
    private String secondName;
    private String idCardNumber;
    private String email;
    private String phoneNumber;
    private String city;
    private String password;
    private List<CarDto> cars;

    public PersonDto() {
    }

    public PersonDto(String profileName, String firstName, String secondName, String idCardNumber, String email, String phoneNumber, String city, String password) {
        this.profileName = profileName;
        this.firstName = firstName;
        this.secondName = secondName;
        this.idCardNumber = idCardNumber;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<CarDto> getCars() {
        return cars;
    }

    public void setCars(List<CarDto> cars) {
        this.cars = cars;
    }

    public static class PersonDtoBuilder {
        private String profileName;
        private String firstName;
        private String secondName;
        private String idCardNumber;
        private String email;
        private String phoneNumber;
        private String city;
        private String password;

        public PersonDtoBuilder profileName(String profileName) {
            this.profileName = profileName;
            return this;
        }

        public PersonDtoBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public PersonDtoBuilder secondName(String secondName) {
            this.secondName = secondName;
            return this;
        }

        public PersonDtoBuilder idCardNumber(String idCardNumber) {
            this.idCardNumber = idCardNumber;
            return this;
        }

        public PersonDtoBuilder email(String email) {
            this.email = email;
            return this;
        }

        public PersonDtoBuilder phoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public PersonDtoBuilder city(String city) {
            this.city = city;
            return this;
        }

        public PersonDtoBuilder password(String password) {
            this.password = password;
            return this;
        }

        public PersonDto createPersonDto() {

            if (isNotValid()) {
                throw new IllegalStateException("Every filed must be filled.");
            }

            return new PersonDto(profileName, firstName, secondName, idCardNumber, email, phoneNumber, city, password);
        }

        private boolean isNotValid() {
            return Objects.isNull(firstName) ||
                    Objects.isNull(secondName) ||
                    Objects.isNull(idCardNumber) ||
                    Objects.isNull(email) ||
                    Objects.isNull(phoneNumber) ||
                    Objects.isNull(city) ||
                    Objects.isNull(profileName) ||
                    Objects.isNull(password);
        }
    }
}

