package by.htp.carservice.entity.impl;

import by.htp.carservice.entity.Entity;

import java.sql.Timestamp;

public class Order extends Entity {
    private long idOrder;
    private Timestamp timeRegister;
    private long description;
    private String status;
    private long user_id;
    private long department;
    private long car_id;

    public Order() {
    }

    public Order(long idOrder, Timestamp timeRegister,
                 long description, String status, long user_id, long department, long car_id) {
        this.idOrder = idOrder;
        this.timeRegister = timeRegister;
        this.description = description;
        this.status = status;
        this.user_id = user_id;
        this.department = department;
        this.car_id = car_id;
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

    public long getDescription() {
        return description;
    }

    public void setDescription(long description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getDepartment() {
        return department;
    }

    public void setDepartment(long department) {
        this.department = department;
    }

    public long getCar_id() {
        return car_id;
    }

    public void setCar_id(long car_id) {
        this.car_id = car_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Order order = (Order) o;

        if (idOrder != order.idOrder) return false;
        if (description != order.description) return false;
        if (user_id != order.user_id) return false;
        if (department != order.department) return false;
        if (car_id != order.car_id) return false;
        if (timeRegister != null ? !timeRegister.equals(order.timeRegister) : order.timeRegister != null) return false;
        return status != null ? status.equals(order.status) : order.status == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idOrder ^ (idOrder >>> 32));
        result = 31 * result + (timeRegister != null ? timeRegister.hashCode() : 0);
        result = 31 * result + (int) (description ^ (description >>> 32));
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (int) (user_id ^ (user_id >>> 32));
        result = 31 * result + (int) (department ^ (department >>> 32));
        result = 31 * result + (int) (car_id ^ (car_id >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "idOrder=" + idOrder +
                ", timeRegister=" + timeRegister +
                ", description=" + description +
                ", status='" + status + '\'' +
                ", user_id=" + user_id +
                ", department=" + department +
                ", car_id=" + car_id +
                '}';
    }
}
