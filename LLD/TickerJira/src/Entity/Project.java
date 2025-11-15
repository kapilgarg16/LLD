package Entity;

public class Project {
    private static int projectCounter = 1;
    private int id;
    private String name;

    public Project(String name) {
        this.id = projectCounter++;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
}
