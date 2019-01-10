package by.htp.carservice.entity.impl;

import by.htp.carservice.entity.Entity;

/**
 * The Class Department.
 */
public class Department extends Entity {
    
    /** The id department. */
    private long idDepartment;
    
    /** The name department. */
    private String nameDepartment;

    /**
     * Instantiates a new department.
     */
    public Department() {
    }

    /**
     * Instantiates a new department.
     *
     * @param idDepartment the id department
     * @param nameDepartment the name department
     */
    public Department(long idDepartment, String nameDepartment) {
        this.idDepartment = idDepartment;
        this.nameDepartment = nameDepartment;
    }

    /**
     * Gets the id department.
     *
     * @return the id department
     */
    public long getIdDepartment() {
        return idDepartment;
    }

    /**
     * Sets the id department.
     *
     * @param idDepartment the new id department
     */
    public void setIdDepartment(long idDepartment) {
        this.idDepartment = idDepartment;
    }

    /**
     * Gets the name department.
     *
     * @return the name department
     */
    public String getNameDepartment() {
        return nameDepartment;
    }

    /**
     * Sets the name department.
     *
     * @param nameDepartment the new name department
     */
    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Department that = (Department) o;

        if (idDepartment != that.idDepartment) return false;
        return nameDepartment != null ? nameDepartment.equals(that.nameDepartment) : that.nameDepartment == null;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = (int) (idDepartment ^ (idDepartment >>> 32));
        result = 31 * result + (nameDepartment != null ? nameDepartment.hashCode() : 0);
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Department{" +
                "idDepartment=" + idDepartment +
                ", nameDepartment='" + nameDepartment + '\'' +
                '}';
    }
}
