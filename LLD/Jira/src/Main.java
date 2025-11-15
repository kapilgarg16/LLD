import entity.Comment;
import entity.Issue;
import entity.Project;
import entity.User;
import service.ProjectService;

public class Main {
    public static void main(String[] args) {
        ProjectService svc = new ProjectService();

        // create users
        User alice = svc.createUser("Alice");
        User bob = svc.createUser("Bob");

        // create project
        Project proj = svc.createProject("Website", "Website revamp");

        // create issues
        Issue i1 = svc.createIssue(proj.getId(), "Landing page design", "Create new landing page");
        Issue i2 = svc.createIssue(proj.getId(), "Signup flow", "Improve signup UX");

        // assign and comment
        svc.assignIssue(i1.getId(), alice.getId());
        svc.addComment(i1.getId(), alice.getId(), "Started working on wireframes");
//        svc.changeIssueStatus(i1.getId(), Issue.Status.IN_PROGRESS);

        svc.assignIssue(i2.getId(), bob.getId());
        svc.addComment(i2.getId(), bob.getId(), "Need clarification on fields");

        // list issues in project
        System.out.println("Issues for project " + proj.getName() + ":");
        for (Issue iss : svc.listIssuesByProject(proj.getId())) {
            System.out.println("  " + iss);
            for (Comment c : iss.getComments()) {
                System.out.println("     - " + c);
            }
        }

        // list issues by user
        System.out.println("\nIssues assigned to Alice:");
        for (Issue iss : svc.listIssuesByUser(alice.getId())) {
            System.out.println("  " + iss);
        }

//        // list issues by status
//        System.out.println("\nIssues IN_PROGRESS:");
//        for (Issue iss : svc.listIssuesByStatus(Issue.Status.IN_PROGRESS)) {
//            System.out.println("  " + iss);
//        }

        // quick updates
//        svc.changeIssueStatus(i1.getId(), Issue.Status.DONE);
//        System.out.println("\nAfter updates:");
//        for (Issue iss : svc.listIssuesByProject(proj.getId())) {
//            System.out.println("  " + iss + " updatedAt=" + iss.getUpdatedAt());
//        }
    }
}