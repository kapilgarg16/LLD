package entity;

import java.time.LocalDateTime;

public class Comment {
    private final String id;
    private String issueId;
    private String userId;
    private String text;
    private LocalDateTime createdAt;

    public Comment(String id, String issueId, String userId, String text) {
        this.id = id;
        this.issueId = issueId;
        this.userId = userId;
        this.text = text;
        createdAt = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public String getIssueId() {
        return issueId;
    }

    public String getUserId() {
        return userId;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "id='" + id + '\'' +
                ", issueId='" + issueId + '\'' +
                ", userId='" + userId + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
