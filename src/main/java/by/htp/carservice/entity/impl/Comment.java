package by.htp.carservice.entity.impl;

import by.htp.carservice.entity.Entity;

public class Comment extends Entity {
    private long idComment;
    private String description;
    private long userId;

    public Comment() {
    }

    public Comment(long idComment, String description, long userId) {
        this.idComment = idComment;
        this.description = description;
        this.userId = userId;
    }

    public long getIdComment() {
        return idComment;
    }

    public void setIdComment(long idComment) {
        this.idComment = idComment;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

        Comment comment = (Comment) o;

        if (idComment != comment.idComment) return false;
        if (userId != comment.userId) return false;
        return description != null ? description.equals(comment.description) : comment.description == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idComment ^ (idComment >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (int) (userId ^ (userId >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "idComment=" + idComment +
                ", description='" + description + '\'' +
                ", userId=" + userId +
                '}';
    }
}
