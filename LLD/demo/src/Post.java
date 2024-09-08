import java.util.Date;


public class Post {
    private int id;
    private int userId;
    private String content;
    private Date date;

    public Post(int id, int userId, String content) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.date = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
