package edu.home.car.dealer.freemarker;

import edu.home.car.dealer.OptionsDto;
import edu.home.car.dealer.PersonDto;

import javax.persistence.Column;
import java.util.Date;

public class OptionDtoFreemarker {

    private String abs;
    private String airbag;
    private String alarm;
    private String alloyWheels;
    private String centralLocking;
    private String cruiseControl;
    private String electricMirrors;
    private String electricWindows;
    private String tripComputer;
    private String leather;
    private String powerSteering;

    OptionDtoFreemarker(OptionsDto optionsDTO){
        this.abs = optionsDTO.isAbs() ? "Abs" : "";
        this.airbag = optionsDTO.isAirbag() ? "Airbag" : "";
        this.alarm = optionsDTO.isAlarm() ? "Xenon Headlights" : "";
        this.alloyWheels = optionsDTO.isAlloyWheels() ? "Alloy Wheels" : "";
        this.centralLocking = optionsDTO.isCentralLocking() ? "Central Locking" : "";
        this.cruiseControl = optionsDTO.isCruiseControl() ? "Cruise Control" : "";
        this.electricMirrors = optionsDTO.isElectricMirrors() ? "Electric Mirrors" : "";
        this.electricWindows = optionsDTO.isElectricWindows() ? "Electric Windows" : "";
        this.tripComputer = optionsDTO.isTripComputer() ? "Trip Computer" : "";
        this.leather = optionsDTO.isLeather() ? "Leather" : "";
        this.powerSteering = optionsDTO.isPowerSteering() ? "Power Steering" : "";
    }

    public String getAbs() {
        return abs;
    }

    public void setAbs(String abs) {
        this.abs = abs;
    }

    public String getAirbag() {
        return airbag;
    }

    public void setAirbag(String airbag) {
        this.airbag = airbag;
    }

    public String getAlarm() {
        return alarm;
    }

    public void setAlarm(String alarm) {
        this.alarm = alarm;
    }

    public String getAlloyWheels() {
        return alloyWheels;
    }

    public void setAlloyWheels(String alloyWheels) {
        this.alloyWheels = alloyWheels;
    }

    public String getCentralLocking() {
        return centralLocking;
    }

    public void setCentralLocking(String centralLocking) {
        this.centralLocking = centralLocking;
    }

    public String getCruiseControl() {
        return cruiseControl;
    }

    public void setCruiseControl(String cruiseControl) {
        this.cruiseControl = cruiseControl;
    }

    public String getElectricMirrors() {
        return electricMirrors;
    }

    public void setElectricMirrors(String electricMirrors) {
        this.electricMirrors = electricMirrors;
    }

    public String getElectricWindows() {
        return electricWindows;
    }

    public void setElectricWindows(String electricWindows) {
        this.electricWindows = electricWindows;
    }

    public String getTripComputer() {
        return tripComputer;
    }

    public void setTripComputer(String tripComputer) {
        this.tripComputer = tripComputer;
    }

    public String getLeather() {
        return leather;
    }

    public void setLeather(String leather) {
        this.leather = leather;
    }

    public String getPowerSteering() {
        return powerSteering;
    }

    public void setPowerSteering(String powerSteering) {
        this.powerSteering = powerSteering;
    }
}
