package Entity;

public class User {
    private static int userCounter = 1;
    private int id;
    private String name;

    public User(String name) {
        this.id = userCounter++;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }
}
