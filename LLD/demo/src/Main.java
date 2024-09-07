public class Main {
    public static void main(String[] args) {
      TwitterSystem twitter = new TwitterSystem();
        twitter.registerUser(1, "kapil");
        twitter.registerUser(2, "chirag");
        twitter.registerUser(3, "Ankit");

        twitter.post(1, "my name is kapil garg");
        twitter.post(2, "my name is Chirag ");
        twitter.post(3, "my name is Ankit ");

        twitter.follow(1, 2);
        twitter.follow(1, 3);

        twitter.viewTimeline(1);



    }
}