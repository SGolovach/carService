package by.htp.carservice.entity.impl;

import by.htp.carservice.entity.Entity;

public class Department extends Entity {
    private long idDepartment;
    private String nameDepartment;

    public Department() {
    }

    public Department(long idDepartment, String nameDepartment) {
        this.idDepartment = idDepartment;
        this.nameDepartment = nameDepartment;
    }

    public long getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(long idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (idDepartment != that.idDepartment) return false;
        return nameDepartment != null ? nameDepartment.equals(that.nameDepartment) : that.nameDepartment == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idDepartment ^ (idDepartment >>> 32));
        result = 31 * result + (nameDepartment != null ? nameDepartment.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Department{" +
                "idDepartment=" + idDepartment +
                ", nameDepartment='" + nameDepartment + '\'' +
                '}';
    }
}
