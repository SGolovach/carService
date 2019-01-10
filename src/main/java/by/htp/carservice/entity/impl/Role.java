package by.htp.carservice.entity.impl;

import by.htp.carservice.entity.Entity;

/**
 * The Class Role.
 */
public class Role extends Entity {
    
    /** The id role. */
    private long idRole;
    
    /** The role. */
    private String role;

    /**
     * Instantiates a new role.
     */
    public Role() {
    }

    /**
     * Instantiates a new role.
     *
     * @param idRole the id role
     * @param role the role
     */
    public Role(long idRole, String role) {
        this.idRole = idRole;
        this.role = role;
    }

    /**
     * Gets the id role.
     *
     * @return the id role
     */
    public long getIdRole() {
        return idRole;
    }

    /**
     * Sets the id role.
     *
     * @param idRole the new id role
     */
    public void setIdRole(long idRole) {
        this.idRole = idRole;
    }

    /**
     * Gets the role.
     *
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * Sets the role.
     *
     * @param role the new role
     */
    public void setRole(String role) {
        this.role = role;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role1 = (Role) o;

        if (idRole != role1.idRole) return false;
        return role != null ? role.equals(role1.role) : role1.role == null;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = (int) (idRole ^ (idRole >>> 32));
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Role{" +
                "idRole=" + idRole +
                ", role='" + role + '\'' +
                '}';
    }
}
