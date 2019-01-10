package by.htp.carservice.entity.impl;

import by.htp.carservice.entity.Entity;

/**
 * The Class User.
 */
public class User extends Entity {
    
    /** The id user. */
    private long idUser;
    
    /** The login. */
    private String login;
    
    /** The password. */
    private String password;
    
    /** The role id. */
    private long roleId;

    /**
     * Instantiates a new user.
     */
    public User() {
    }

    /**
     * Instantiates a new user.
     *
     * @param idUser the id user
     * @param login the login
     * @param password the password
     * @param roleId the role id
     */
    public User(long idUser, String login, String password, long roleId) {
        this.idUser = idUser;
        this.login = login;
        this.password = password;
        this.roleId = roleId;
    }

    /**
     * Gets the id user.
     *
     * @return the id user
     */
    public long getIdUser() {
        return idUser;
    }

    /**
     * Sets the id user.
     *
     * @param idUser the new id user
     */
    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    /**
     * Gets the login.
     *
     * @return the login
     */
    public String getLogin() {
        return login;
    }

    /**
     * Sets the login.
     *
     * @param login the new login
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the role id.
     *
     * @return the role id
     */
    public long getRoleId() {
        return roleId;
    }

    /**
     * Sets the role id.
     *
     * @param roleId the new role id
     */
    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (idUser != user.idUser) return false;
        if (roleId != user.roleId) return false;
        if (login != null ? !login.equals(user.login) : user.login != null) return false;
        return password != null ? password.equals(user.password) : user.password == null;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = (int) (idUser ^ (idUser >>> 32));
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (int) (roleId ^ (roleId >>> 32));
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "User{" +
                "idUser=" + idUser +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                '}';
    }
}
