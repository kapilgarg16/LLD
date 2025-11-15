package service;

import entity.Comment;
import entity.Issue;
import entity.Project;
import entity.User;

import java.util.*;

public class ProjectService {
    private  Map<String, User> users = new HashMap<>();
    private  Map<String, Project> projects = new HashMap<>();
    private  Map<String, Issue> issues = new HashMap<>();

    //list of all the issues for project
    private  Map<String, List<String>> projectIssues = new HashMap<>();
    //list of all the addigned usse of a project
    private Map<String, List<String>>userAssignedIssues = new HashMap<>();

    private int userCounter = 1;
    private int projectCounter = 1;
    private int issueCounter1 = 1;
    private int commentCounter = 1;

    public User createUser(String name){
        String id = "u" + (userCounter++);
        User user = new User(id, name);
        users.put(id, user);
        userAssignedIssues.put(id, new ArrayList<>());
        return user;
    }

    public User getUser(String userId){
        return users.get(userId);
    }

    public Project createProject(String name, String description){
        String id = "p"+ (projectCounter++);
        Project p = new Project(id, name, description);
        projects.put(id, p);
        projectIssues.put(id, new ArrayList<>());
        return p;
    }

    public Project getProject(String id){
        return projects.get(id);
    }

    public Issue createIssue(String projectId, String title, String desc){
        if(!projects.containsKey(projectId)){
            throw new RuntimeException("Project does not exist: " + projectId);
        }
        String id = "I-" + (issueCounter1++);
        Issue is = new Issue(id, title, projectId, desc);
        issues.put(id, is);
        projectIssues.get(projectId).add(id);
        return is;
    }

    public Issue getIssue(String id){
        return issues.get(id);
    }

//    public void changeIssueStatus(String issueId, Issue.Status status) {
//        Issue iss = requireIssue(issueId);
//        iss.setStatus(status);
//    }

    public void assignIssue(String issueId, String userId) {
        Issue iss = requireIssue(issueId);
        if (!users.containsKey(userId)) throw new IllegalArgumentException("User not found: " + userId);
        // remove from previous assignee index if any
        String prev = iss.getAssigneeUserId();
        if (prev != null) {
            userAssignedIssues.get(prev).remove(issueId);
        }
        iss.setAssigneeUserId(userId);
        userAssignedIssues.get(userId).add(issueId);
    }

    public Comment addComment(String issueId, String userId, String text) {
        Issue iss = requireIssue(issueId);
        if (!users.containsKey(userId)) throw new IllegalArgumentException("User not found: " + userId);
        String cid = "c" + (commentCounter++);
        Comment c = new Comment(cid, issueId, userId, text);
        iss.setComments(c);
        return c;
    }

    public List<Issue> listIssuesByProject(String projectId) {
        List<String> ids = projectIssues.getOrDefault(projectId, Collections.emptyList());
        List<Issue> out = new ArrayList<>();
        for (String id : ids) out.add(issues.get(id));
        return out;
    }

    public List<Issue> listIssuesByUser(String userId) {
        List<String> ids = userAssignedIssues.getOrDefault(userId, Collections.emptyList());
        List<Issue> out = new ArrayList<>();
        for (String id : ids) out.add(issues.get(id));
        return out;
    }

//    public List<Issue> listIssuesByStatus(Issue.Status status) {
//        List<Issue> out = new ArrayList<>();
//        for (Issue iss : issues.values()) {
//            if (iss.getStatus() == status) out.add(iss);
//        }
//        return out;
//    }

    // helper
    private Issue requireIssue(String id) {
        Issue iss = issues.get(id);
        if (iss == null) throw new IllegalArgumentException("Issue not found: " + id);
        return iss;
    }

}
