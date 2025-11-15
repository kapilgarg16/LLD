package Entity;

public class Ticket {
    private static int idCounter = 1;
    private int id;
    private String title;
    private String description;
    private TicketStatus status;
    private TicketType type;
    private User assignee;
    private Project project;

    public Ticket(String title, String description, TicketType type, Project project) {
        this.id = idCounter++;
        this.title = title;
        this.description = description;
        this.type = type;
        this.status = TicketStatus.OPEN;
        this.project = project;
    }

    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public TicketStatus getStatus() { return status; }
    public TicketType getType() { return type; }
    public User getAssignee() { return assignee; }
    public Project getProject() { return project; }

    public void setStatus(TicketStatus status) { this.status = status; }
    public void assignUser(User user) { this.assignee = user; }

    @Override
    public String toString() {
        return "Ticket{id=" + id + ", title=" + title + ", status=" + status +
                ", type=" + type + ", project=" + (project != null ? project.getName() : "Unassigned") +
                ", assignee=" + (assignee != null ? assignee.getName() : "Unassigned") + "}";
    }
}
