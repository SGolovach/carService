package by.htp.carservice.entity.impl;

import by.htp.carservice.entity.Entity;

/**
 * The Class UserDetail.
 */
public class UserDetail extends Entity {
    
    /** The id user detail. */
    private long idUserDetail;
    
    /** The name. */
    private String name;
    
    /** The phone. */
    private String phone;
    
    /** The email. */
    private String email;
    
    /** The user id. */
    private long userId;

    /**
     * Instantiates a new user detail.
     */
    public UserDetail() {
    }

    /**
     * Instantiates a new user detail.
     *
     * @param idUserDetail the id user detail
     * @param name the name
     * @param phone the phone
     * @param email the email
     * @param userId the user id
     */
    public UserDetail(long idUserDetail, String name, String phone, String email, long userId) {
        this.idUserDetail = idUserDetail;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.userId = userId;
    }

    /**
     * Gets the id user detail.
     *
     * @return the id user detail
     */
    public long getIdUserDetail() {
        return idUserDetail;
    }

    /**
     * Sets the id user detail.
     *
     * @param idUserDetail the new id user detail
     */
    public void setIdUserDetail(long idUserDetail) {
        this.idUserDetail = idUserDetail;
    }

    /**
     * Gets the name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the phone.
     *
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * Sets the phone.
     *
     * @param phone the new phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * Gets the email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email.
     *
     * @param email the new email
     */
    public void setEmail(String email) {
        this.email = email;
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

        UserDetail that = (UserDetail) o;

        if (idUserDetail != that.idUserDetail) return false;
        if (userId != that.userId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (phone != null ? !phone.equals(that.phone) : that.phone != null) return false;
        return email != null ? email.equals(that.email) : that.email == null;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = (int) (idUserDetail ^ (idUserDetail >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "UserDetail{" +
                "idUserDetail=" + idUserDetail +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", userId=" + userId +
                '}';
    }
}
