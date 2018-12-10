package by.htp.carservice.entity.impl;

import by.htp.carservice.entity.Entity;

public class UserDetail extends Entity {
    private long idUserDetail;
    private String name;
    private String phone;
    private String email;
    private long user_id;

    public UserDetail() {
    }

    public UserDetail(long idUserDetail, String name, String phone, String email, long user_id) {
        this.idUserDetail = idUserDetail;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.user_id = user_id;
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

        UserDetail userDetail = (UserDetail) o;

        if (idUserDetail != userDetail.idUserDetail) return false;
        if (user_id != userDetail.user_id) return false;
        if (name != null ? !name.equals(userDetail.name) : userDetail.name != null) return false;
        if (phone != null ? !phone.equals(userDetail.phone) : userDetail.phone != null) return false;
        return email != null ? email.equals(userDetail.email) : userDetail.email == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idUserDetail ^ (idUserDetail >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (int) (user_id ^ (user_id >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "UserDetail{" +
                "idUserdetail=" + idUserDetail +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
