import Entity.*;

public class Main {
    public static void main(String[] args) {
        TicketService ts = new TicketService();
        Project p1 = ts.createProject("Jira Backend");
        Project p2 = ts.createProject("Jira Frontend");
        User alice = ts.createUser("Alice");
        User bob = ts.createUser("Bob");

        Ticket t1 = ts.createTicket("API bug", "Error in auth module", TicketType.BUG, p1.getId());
        Ticket t2 = ts.createTicket("UI refresh", "Update dashboard UI", TicketType.FEATURE, p2.getId());

        ts.assignTicket(t1.getId(), alice.getId());
        ts.assignTicket(t2.getId(), bob.getId());

        ts.updateTicketStatus(t1.getId(), TicketStatus.IN_PROGRESS);

        // Show tickets assigned to Alice
        System.out.println("Tickets assigned to Alice:");
        ts.getTicketsByUser(alice).forEach(System.out::println);

        // Show all tickets with status IN_PROGRESS
        System.out.println("\nTickets with status IN_PROGRESS:");
        ts.getTicketsByStatus(TicketStatus.IN_PROGRESS).forEach(System.out::println);

        // Search tickets by keyword
        System.out.println("\nTickets with keyword 'bug':");
        ts.searchTicketsByKeyword("bug").forEach(System.out::println);
    }
}
