package by.htp.carservice.entity.impl;

import by.htp.carservice.entity.Entity;

import java.sql.Timestamp;


public class Order extends Entity {
    private long idOrder;
    private Timestamp timeRegister;
    private String description;
    private String status;
    private long userId;
    private long departmentId;
    private long carId;

    public Order() {
    }

    public Order(long idOrder, Timestamp timeRegister,
                 String description, String status, long userId, long departmentId, long carId) {
        this.idOrder = idOrder;
        this.timeRegister = timeRegister;
        this.description = description;
        this.status = status;
        this.userId = userId;
        this.departmentId = departmentId;
        this.carId = carId;
    }

    public long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(long idOrder) {
        this.idOrder = idOrder;
    }

    public Timestamp getTimeRegister() {
        return timeRegister;
    }

    public void setTimeRegister(Timestamp timeRegister) {
        this.timeRegister = timeRegister;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (idOrder != order.idOrder) return false;
        if (userId != order.userId) return false;
        if (departmentId != order.departmentId) return false;
        if (carId != order.carId) return false;
        if (timeRegister != null ? !timeRegister.equals(order.timeRegister) : order.timeRegister != null) return false;
        if (description != null ? !description.equals(order.description) : order.description != null) return false;
        return status != null ? status.equals(order.status) : order.status == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idOrder ^ (idOrder >>> 32));
        result = 31 * result + (timeRegister != null ? timeRegister.hashCode() : 0);
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        result = 31 * result + (int) (departmentId ^ (departmentId >>> 32));
        result = 31 * result + (int) (carId ^ (carId >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", timeRegister=" + timeRegister +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", userId=" + userId +
                ", departmentId=" + departmentId +
                ", carId=" + carId +
                '}';
    }
}
