import Entity.*;

import java.util.*;
import java.util.stream.Collectors;

public class TicketService {
    private Map<Integer, Ticket> tickets = new HashMap<>();
    private Map<Integer, User> users = new HashMap<>();
    private Map<Integer, Project> projects = new HashMap<>();

    public Project createProject(String name) {
        Project project = new Project(name);
        projects.put(project.getId(), project);
        return project;
    }

    public User createUser(String name) {
        User user = new User(name);
        users.put(user.getId(), user);
        return user;
    }

    public Ticket createTicket(String title, String description, TicketType type, int projectId) {
        Project project = projects.get(projectId);
        if (project == null) throw new IllegalArgumentException("Project does not exist!");
        Ticket ticket = new Ticket(title, description, type, project);
        tickets.put(ticket.getId(), ticket);
        return ticket;
    }

    public void assignTicket(int ticketId, int userId) {
        Ticket ticket = tickets.get(ticketId);
        User user = users.get(userId);
        if (ticket != null && user != null) {
            ticket.assignUser(user);
        }
    }

    public void updateTicketStatus(int ticketId, TicketStatus status) {
        Ticket ticket = tickets.get(ticketId);
        if (ticket != null) {
            ticket.setStatus(status);
        }
    }

    public List<Ticket> getTicketsByUser(User user) {
        return tickets.values().stream()
                .filter(ticket -> ticket.getAssignee() != null && ticket.getAssignee().getId() == user.getId())
                .collect(Collectors.toList());
    }

    public List<Ticket> getTicketsByStatus(TicketStatus status) {
        return tickets.values().stream()
                .filter(ticket -> ticket.getStatus() == status)
                .collect(Collectors.toList());
    }

    public List<Ticket> searchTicketsByKeyword(String keyword) {
        return tickets.values().stream()
                .filter(ticket -> ticket.getTitle().toLowerCase().contains(keyword.toLowerCase()) ||
                        ticket.getDescription().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void printAllTickets() {
        for (Ticket ticket : tickets.values()) {
            System.out.println(ticket);
        }
    }
}
