package edu.home.car.dealer.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Options")
public class Options extends BaseEntity {

    @Column
    private boolean abs;
    @Column
    private boolean airbag;
    @Column
    private boolean alarm;
    @Column
    private boolean alloyWheels;
    @Column
    private boolean centralLocking;
    @Column
    private boolean cruiseControl;
    @Column
    private boolean electricMirrors;
    @Column
    private boolean electricWindows;
    @Column
    private boolean tripComputer;
    @Column
    private boolean leather;
    @Column
    private boolean powerSteering;

    @JsonBackReference
    @OneToOne(mappedBy="options",cascade=CascadeType.ALL, fetch = FetchType.EAGER)
    private Car car;

    public Options(){
    }

    public Options(boolean abs, boolean airbag, boolean alarm, boolean alloyWheels, boolean centralLocking, boolean cruiseControl, boolean electricMirrors, boolean electricWindows, boolean tripComputer, boolean leather, boolean powerSteering) {
        this.abs = abs;
        this.airbag = airbag;
        this.alarm = alarm;
        this.alloyWheels = alloyWheels;
        this.centralLocking = centralLocking;
        this.cruiseControl = cruiseControl;
        this.electricMirrors = electricMirrors;
        this.electricWindows = electricWindows;
        this.tripComputer = tripComputer;
        this.leather = leather;
        this.powerSteering = powerSteering;
    }

    public boolean isAbs() {
        return abs;
    }

    public void setAbs(boolean abs) {
        this.abs = abs;
    }

    public boolean isAirbag() {
        return airbag;
    }

    public void setAirbag(boolean airbag) {
        this.airbag = airbag;
    }

    public boolean isAlarm() {
        return alarm;
    }

    public void setAlarm(boolean alarm) {
        this.alarm = alarm;
    }

    public boolean isAlloyWheels() {
        return alloyWheels;
    }

    public void setAlloyWheels(boolean alloyWheels) {
        this.alloyWheels = alloyWheels;
    }

    public boolean isCentralLocking() {
        return centralLocking;
    }

    public void setCentralLocking(boolean centralLocking) {
        this.centralLocking = centralLocking;
    }

    public boolean isCruiseControl() {
        return cruiseControl;
    }

    public void setCruiseControl(boolean cruiseControl) {
        this.cruiseControl = cruiseControl;
    }

    public boolean isElectricMirrors() {
        return electricMirrors;
    }

    public void setElectricMirrors(boolean electricMirrors) {
        this.electricMirrors = electricMirrors;
    }

    public boolean isElectricWindows() {
        return electricWindows;
    }

    public void setElectricWindows(boolean electricWindows) {
        this.electricWindows = electricWindows;
    }

    public boolean isTripComputer() {
        return tripComputer;
    }

    public void setTripComputer(boolean tripComputer) {
        this.tripComputer = tripComputer;
    }

    public boolean isLeather() {
        return leather;
    }

    public void setLeather(boolean leather) {
        this.leather = leather;
    }

    public boolean isPowerSteering() {
        return powerSteering;
    }

    public void setPowerSteering(boolean powerSteering) {
        this.powerSteering = powerSteering;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                "abs=" + abs +
                "airbag=" + airbag +
                "alarm=" + alarm +
                "alloyWheels=" + alloyWheels +
                "centralLocking=" + centralLocking +
                "cruiseControl=" + cruiseControl +
                "electricMirrors=" + electricMirrors +
                "electricWindows=" + electricWindows +
                "tripComputer=" + tripComputer +
                "leather=" + leather +
                "powerSteering=" + powerSteering +
                "car=" + car +
                '}';
    }

    public static class OptionBuilder {
        private boolean abs;
        private boolean airbag;
        private boolean alarm;
        private boolean alloyWheels;
        private boolean centralLocking;
        private boolean cruiseControl;
        private boolean electricMirrors;
        private boolean electricWindows;
        private boolean tripComputer;
        private boolean leather;
        private boolean powerSteering;

        public OptionBuilder abs(boolean abs) {
            this.abs = abs;
            return this;
        }

        public OptionBuilder airbag(boolean airbag) {
            this.airbag = airbag;
            return this;
        }

        public OptionBuilder alarm(boolean alarm) {
            this.alarm = alarm;
            return this;
        }

        public OptionBuilder alloyWheels(boolean alloyWheels) {
            this.alloyWheels = alloyWheels;
            return this;
        }

        public OptionBuilder centralLocking(boolean centralLocking) {
            this.centralLocking = centralLocking;
            return this;
        }

        public OptionBuilder cruiseControl(boolean cruiseControl) {
            this.cruiseControl = cruiseControl;
            return this;
        }

        public OptionBuilder electricMirrors(boolean electricMirrors) {
            this.electricMirrors = electricMirrors;
            return this;
        }

        public OptionBuilder electricWindows(boolean electricWindows) {
            this.electricWindows = electricWindows;
            return this;
        }

        public OptionBuilder tripComputer(boolean tripComputer) {
            this.tripComputer = tripComputer;
            return this;
        }

        public OptionBuilder leather(boolean leather) {
            this.leather = leather;
            return this;
        }

        public OptionBuilder powerSteering(boolean powerSteering) {
            this.powerSteering = powerSteering;
            return this;
        }


        public Options createOption() {

            return new Options(abs, airbag, alarm, alloyWheels, centralLocking, cruiseControl,
                    electricMirrors, electricWindows, tripComputer, leather, powerSteering );
        }
    }
}

