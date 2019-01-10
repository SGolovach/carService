package by.htp.carservice.entity.impl;

import by.htp.carservice.entity.Entity;

import java.sql.Timestamp;


/**
 * The Class Order.
 */
public class Order extends Entity {
    
    /** The id order. */
    private long idOrder;
    
    /** The time register. */
    private Timestamp timeRegister;
    
    /** The description. */
    private String description;
    
    /** The status. */
    private String status;
    
    /** The user id. */
    private long userId;
    
    /** The department id. */
    private long departmentId;
    
    /** The car id. */
    private long carId;

    /**
     * Instantiates a new order.
     */
    public Order() {
    }

    /**
     * Instantiates a new order.
     *
     * @param idOrder the id order
     * @param timeRegister the time register
     * @param description the description
     * @param status the status
     * @param userId the user id
     * @param departmentId the department id
     * @param carId the car id
     */
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

    /**
     * Gets the id order.
     *
     * @return the id order
     */
    public long getIdOrder() {
        return idOrder;
    }

    /**
     * Sets the id order.
     *
     * @param idOrder the new id order
     */
    public void setIdOrder(long idOrder) {
        this.idOrder = idOrder;
    }

    /**
     * Gets the time register.
     *
     * @return the time register
     */
    public Timestamp getTimeRegister() {
        return timeRegister;
    }

    /**
     * Sets the time register.
     *
     * @param timeRegister the new time register
     */
    public void setTimeRegister(Timestamp timeRegister) {
        this.timeRegister = timeRegister;
    }

    /**
     * Gets the description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the description.
     *
     * @param description the new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public void setStatus(String status) {
        this.status = status;
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

    /**
     * Gets the department id.
     *
     * @return the department id
     */
    public long getDepartmentId() {
        return departmentId;
    }

    /**
     * Sets the department id.
     *
     * @param departmentId the new department id
     */
    public void setDepartmentId(long departmentId) {
        this.departmentId = departmentId;
    }

    /**
     * Gets the car id.
     *
     * @return the car id
     */
    public long getCarId() {
        return carId;
    }

    /**
     * Sets the car id.
     *
     * @param carId the new car id
     */
    public void setCarId(long carId) {
        this.carId = carId;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
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

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
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

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
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
