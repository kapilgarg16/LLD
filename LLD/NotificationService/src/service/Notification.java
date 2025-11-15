package service;

public class Notification {
    public enum Priority {Low, high, MEDIUM, LOW, medium};
    private String message;
    private String title;
    private Priority priority;

    public Notification(String title, String message, Priority priority) {
        this.title = title;
        this.message = message;
        this.priority = priority;
    }
    public String getTitle() { return title; }
    public String getMessage() { return message; }
    public Priority getPriority() { return priority; }

    @Override
    public String toString() {
        return "[" + priority + "] " + title + " - " + message;
    }
}
