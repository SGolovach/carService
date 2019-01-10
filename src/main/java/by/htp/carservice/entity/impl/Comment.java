package by.htp.carservice.entity.impl;

import by.htp.carservice.entity.Entity;

/**
 * The Class Comment.
 */
public class Comment extends Entity {
    
    /** The id comment. */
    private long idComment;
    
    /** The description. */
    private String description;
    
    /** The user id. */
    private long userId;

    /**
     * Instantiates a new comment.
     */
    public Comment() {
    }

    /**
     * Instantiates a new comment.
     *
     * @param idComment the id comment
     * @param description the description
     * @param userId the user id
     */
    public Comment(long idComment, String description, long userId) {
        this.idComment = idComment;
        this.description = description;
        this.userId = userId;
    }

    /**
     * Gets the id comment.
     *
     * @return the id comment
     */
    public long getIdComment() {
        return idComment;
    }

    /**
     * Sets the id comment.
     *
     * @param idComment the new id comment
     */
    public void setIdComment(long idComment) {
        this.idComment = idComment;
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

        Comment comment = (Comment) o;

        if (idComment != comment.idComment) return false;
        if (userId != comment.userId) return false;
        return description != null ? description.equals(comment.description) : comment.description == null;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        int result = (int) (idComment ^ (idComment >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        return result;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Comment{" +
                "idComment=" + idComment +
                ", description='" + description + '\'' +
                ", userId=" + userId +
                '}';
    }
}
