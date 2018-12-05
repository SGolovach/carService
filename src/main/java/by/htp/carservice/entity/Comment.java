package by.htp.carservice.entity;

public class Comment {
    private long idComment;
    private String description;
    private long user_id;

    public Comment() {
    }

    public Comment(long idComment, String description, long user_id) {
        this.idComment = idComment;
        this.description = description;
        this.user_id = user_id;
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

        Comment comment = (Comment) o;

        if (idComment != comment.idComment) return false;
        if (user_id != comment.user_id) return false;
        return description != null ? description.equals(comment.description) : comment.description == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (idComment ^ (idComment >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        result = 31 * result + (int) (user_id ^ (user_id >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "idComment=" + idComment +
                ", description='" + description + '\'' +
                ", user_id=" + user_id +
                '}';
    }
}
