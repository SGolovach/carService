package by.htp.carservice.entity.impl;

import by.htp.carservice.entity.Entity;

public class UserDetail extends Entity {
    private long idUserDetail;
    private String name;
    private String phone;
    private String email;
    private long userId;

    public UserDetail() {
    }

    public UserDetail(long idUserDetail, String name, String phone, String email, long userId) {
        this.idUserDetail = idUserDetail;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.userId = userId;
    }

    public long getIdUserDetail() {
        return idUserDetail;
    }

    public void setIdUserDetail(long idUserDetail) {
        this.idUserDetail = idUserDetail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

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

    @Override
    public int hashCode() {
        int result = (int) (idUserDetail ^ (idUserDetail >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        return result;
    }

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
