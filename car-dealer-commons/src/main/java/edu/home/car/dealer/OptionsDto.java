package edu.home.car.dealer;

public class OptionsDto {

    private Long id;
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
    private CarDto car;

    public OptionsDto(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public CarDto getCar() {
        return car;
    }

    public void setCar(CarDto car) {
        this.car = car;
    }
}

