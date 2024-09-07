import java.util.*;

public class TwitterSystem {
    private  Map<Integer, User> users;
    private List<Post> allPost;

    public TwitterSystem(){
        users = new HashMap<>();
        allPost = new ArrayList<>();
    }

    public void registerUser(int id, String name){
        users.putIfAbsent(id, new User(id, name));
    }

    public void post(int id, String content)
    {
        if(users.containsKey(id))
        {
            User user = users.get(id);
            user.post(content);
        }
        else{
            System.out.println("user not found");
        }
    }
    public void follow(int userId1, int userId2){
        if(users.containsKey(userId1) && users.containsKey(userId2)){
            User follower =  users.get(userId1);
            User follwee =  users.get(userId2);

            follower.follow(userId2);
            follwee.addFollowers(userId1);
        }
        else{
            System.out.println("user not found");
        }
    }

    public void viewTimeline(int id){
        if(users.containsKey(id)){
            User user = users.get(id);
            Set<Integer> following  = user.getFollowing();
            List<Post> timeLine = new ArrayList<>();

            for(Integer followeeId : following){
                timeLine.addAll(users.get(followeeId).getPosts());
            }

            System.out.println("Timeline is ");

            for(Post post : timeLine){
                System.out.println(post.getContent());
            }
        }
        else {
            System.out.println("user not found");
        }
    }

//    public List<Post> searchKey(int id, String key){
//        //List<Post>allPost;
//       //get all the viewTimeline
//        //I will iterate each post and will search the keywor
//        //I found keyword, then I will add those post in my list
//        //return the list
//    }

}
