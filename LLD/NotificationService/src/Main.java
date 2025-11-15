import service.Notification;
import service.NotificationService;
import service.Subscriber;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        NotificationService svc = new NotificationService();

        Subscriber alice = new Subscriber("alice@example.com", Arrays.asList("EMAIL","PUSH"));
        Subscriber bob = new Subscriber("+911234567890", Arrays.asList("SMS"));
        Subscriber carol = new Subscriber("carol@example.com", Arrays.asList("EMAIL"));

        svc.subscribe("orders", alice);
        svc.subscribe("orders", bob);
        svc.subscribe("marketing", carol);
        svc.subscribe("orders", carol);

        Notification n1 = new Notification("Order Shipped", "Order #123 shipped", Notification.Priority.MEDIUM);
        svc.publish("orders", n1);

        System.out.println("---- unsubscribe carol from orders ----");
        svc.unsubscribe("orders", "carol@example.com");

        Notification n2 = new Notification("Order Delivered", "Order #123 delivered", Notification.Priority.LOW);
        svc.publish("orders", n2);
    }
}