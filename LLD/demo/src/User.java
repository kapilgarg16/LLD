import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User {
    private int id;
    private String name;
    private Set<Integer> followers;
    private Set<Integer> following;
    private List<Post> posts;

    public User(int id, String name){
        this.id = id;
        this.name = name;
        followers = new HashSet<>();
        following = new HashSet<>();
        posts = new ArrayList<>();
    }

    public void post(String content){
        posts.add(new Post(posts.size() + 1, id, content));
    }
    public void addFollowers(int userId){
        followers.add(userId);
    }

    public void follow(int userId){
        following.add(userId);
    }

    public List<Post> getPosts(){
        return posts;
    }

    public Set<Integer> getFollowing(){
        return following;
    }


}
