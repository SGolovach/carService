package by.htp.carservice.entity;

public class Car{
    private long idCar;
    private String brand;
    private String model;
    private int year;
    private String codeVIN;
    private String fuel;
    private long user_id;

    public Car() {
    }

    public Car(long idCar, String brand, String model, int year, String codeVIN, String fuel, long user_id) {
        this.idCar = idCar;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.codeVIN = codeVIN;
        this.fuel = fuel;
        this.user_id = user_id;
    }

    public long getIdCar() {
        return idCar;
    }

    public void setIdCar(long idCar) {
        this.idCar = idCar;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCodeVIN() {
        return codeVIN;
    }

    public void setCodeVIN(String codeVIN) {
        this.codeVIN = codeVIN;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (idCar != car.idCar) return false;
        if (year != car.year) return false;
        if (user_id != car.user_id) return false;
        if (brand != null ? !brand.equals(car.brand) : car.brand != null) return false;
        if (model != null ? !model.equals(car.model) : car.model != null) return false;
        if (codeVIN != null ? !codeVIN.equals(car.codeVIN) : car.codeVIN != null) return false;
        return fuel != null ? fuel.equals(car.fuel) : car.fuel == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idCar ^ (idCar >>> 32));
        result = 31 * result + (brand != null ? brand.hashCode() : 0);
        result = 31 * result + (model != null ? model.hashCode() : 0);
        result = 31 * result + year;
        result = 31 * result + (codeVIN != null ? codeVIN.hashCode() : 0);
        result = 31 * result + (fuel != null ? fuel.hashCode() : 0);
        result = 31 * result + (int) (user_id ^ (user_id >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Car{" +
                "idCar=" + idCar +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", codeVIN='" + codeVIN + '\'' +
                ", fuel='" + fuel + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
