//Notify Me : When the user(Observer) subscribes for some notification from some App(Subject).
/*Twitter Follow, Unfollow and Post Tweet feature :
Facebook News Feed 
Cricket Score Updater 
Youtube Subscription 
Group Chat Application 
Weather Forecasting
*/

public class ChatServer {

    private List<Client> clients = new ArrayList<>();

    public void addClient(Client client)
 
    {
        clients.add(client);
    }

    public void removeClient(Client client)
 
    {
        clients.remove(client);
    }

    public void broadcastMessage(String message) {
        for (Client client : clients) {
            client.receiveMessage(message);
        }
    }
}

public class Client {

    private ChatServer server;

    public Client(ChatServer server) {
        this.server = server;
        server.addClient(this);
    }

    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
    }
}


public class Main {

    public static void main(String[] args) {
        ChatServer server = new ChatServer();

        Client client1 = new Client(server);
        Client client2 = new Client(server);

        server.broadcastMessage("Hello from the server!");
    }
}
