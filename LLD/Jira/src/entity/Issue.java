package entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Issue {
    public enum Status {TODO, DONE, IN_PROGRESS, COMPLETED};
    private final String id;
    private final String title;
    private String projectId;
    private String description;
    private Status status;
    private String assigneeUserId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<Comment> comments = new ArrayList<>();

    public Issue(String id, String title, String projectId, String description){
        this.id = id;
        this.title = title;
        this.projectId = projectId;
        this.description = description;
        this.status = Status.DONE;
        this.createdAt = LocalDateTime.now();
        this.updatedAt = createdAt;
    }

    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getProjectId() {
        return projectId;
    }
    public String getDescription() {
        return description;
    }
    public Status getStatus() {
        return status;
    }
    public String getAssigneeUserId() {
        return assigneeUserId;
    }
    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
    public List<Comment> getComment(){
        return comments;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setAssigneeUserId(String assigneeUserId) {
        this.assigneeUserId = assigneeUserId;
    }

    public void setUpdatedAt() {
        this.updatedAt = LocalDateTime.now();
    }

    public void setComments(Comment comment) {
        setUpdatedAt();
        comments.add(comment);
    }

    public List<Comment> getComments() {
        return comments;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", projectId='" + projectId + '\'' +
                ", status=" + status +
                ", assigneeUserId='" + assigneeUserId + '\'' +
                '}';
    }
}
