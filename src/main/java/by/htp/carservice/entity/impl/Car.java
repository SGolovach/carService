package by.htp.carservice.entity.impl;

import by.htp.carservice.entity.Entity;

/**
 * The Class Car.
 */
public class Car extends Entity {
    
    /** The id car. */
    private long idCar;
    
    /** The brand. */
    private String brand;
    
    /** The model. */
    private String model;
    
    /** The year. */
    private int year;
    
    /** The code VIN. */
    private String codeVIN;
    
    /** The fuel. */
    private String fuel;
    
    /** The user id. */
    private long userId;

    /**
     * Instantiates a new car.
     */
    public Car() {
    }

    /**
     * Instantiates a new car.
     *
     * @param idCar the id car
     * @param brand the brand
     * @param model the model
     * @param year the year
     * @param codeVIN the code VIN
     * @param fuel the fuel
     * @param userId the user id
     */
    public Car(long idCar, String brand, String model, int year, String codeVIN, String fuel, long userId) {
        this.idCar = idCar;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.codeVIN = codeVIN;
        this.fuel = fuel;
        this.userId = userId;
    }

    /**
     * Gets the id car.
     *
     * @return the id car
     */
    public long getIdCar() {
        return idCar;
    }

    /**
     * Sets the id car.
     *
     * @param idCar the new id car
     */
    public void setIdCar(long idCar) {
        this.idCar = idCar;
    }

    /**
     * Gets the brand.
     *
     * @return the brand
     */
    public String getBrand() {
        return brand;
    }

    /**
     * Sets the brand.
     *
     * @param brand the new brand
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * Gets the model.
     *
     * @return the model
     */
    public String getModel() {
        return model;
    }

    /**
     * Sets the model.
     *
     * @param model the new model
     */
    public void setModel(String model) {
        this.model = model;
    }

    /**
     * Gets the year.
     *
     * @return the year
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the year.
     *
     * @param year the new year
     */
    public void setYear(int year) {
        this.year = year;
    }

    /**
     * Gets the code VIN.
     *
     * @return the code VIN
     */
    public String getCodeVIN() {
        return codeVIN;
    }

    /**
     * Sets the code VIN.
     *
     * @param codeVIN the new code VIN
     */
    public void setCodeVIN(String codeVIN) {
        this.codeVIN = codeVIN;
    }

    /**
     * Gets the fuel.
     *
     * @return the fuel
     */
    public String getFuel() {
        return fuel;
    }

    /**
     * Sets the fuel.
     *
     * @param fuel the new fuel
     */
    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    /**
     * Gets the user id.
     *
     * @return the user id
     */
    public long getUserId() {
        return userId;
    }

    /**
     * Sets the user id.
     *
     * @param userId the new user id
     */
    public void setUserId(long userId) {
        this.userId = userId;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (idCar != car.idCar) return false;
        if (year != car.year) return false;
        if (userId != car.userId) return false;
        if (brand != null ? !brand.equals(car.brand) : car.brand != null) return false;
        if (model != null ? !model.equals(car.model) : car.model != null) return false;
        if (codeVIN != null ? !codeVIN.equals(car.codeVIN) : car.codeVIN != null) return false;
        return fuel != null ? fuel.equals(car.fuel) : car.fuel == null;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = (int) (idCar ^ (idCar >>> 32));
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + year;
        result = 31 * result + (codeVIN != null ? codeVIN.hashCode() : 0);
        result = 31 * result + (fuel != null ? fuel.hashCode() : 0);
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Car{" +
                "idCar=" + idCar +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", codeVIN='" + codeVIN + '\'' +
                ", fuel='" + fuel + '\'' +
                ", userId=" + userId +
                '}';
    }
}
