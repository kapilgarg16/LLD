package service;

import java.util.*;

public class NotificationService {
    private final Map<String, List<Subscriber>> subscribersByTopic = new HashMap<>();

    // subscribe user to topic
    public void subscribe(String topic, Subscriber s) {
        subscribersByTopic.computeIfAbsent(topic, t -> new ArrayList<>()).add(s);
    }

    public void unsubscribe(String topic, String userId) {
        List<Subscriber> list = subscribersByTopic.get(topic);
        if (list != null) list.removeIf(s -> s.getId().equals(userId));
    }

    // publish synchronously (simple send simulation)
    public void publish(String topic, Notification notification) {
        List<Subscriber> list = subscribersByTopic.getOrDefault(topic, Collections.emptyList());
        for (Subscriber s : list) {
            for (String ch : s.getChannels()) {
                // simple channel handling inline (no factory)
                if ("EMAIL".equalsIgnoreCase(ch)) {
                    System.out.println("[EMAIL] to=" + s.getId() + " : " + notification);
                } else if ("SMS".equalsIgnoreCase(ch)) {
                    System.out.println("[SMS] to=" + s.getId() + " : " + notification.getMessage());
                } else if ("PUSH".equalsIgnoreCase(ch)) {
                    System.out.println("[PUSH] to=" + s.getId() + " : " + notification.getTitle());
                } else {
                    System.out.println("[UNKNOWN CHANNEL] " + ch + " for " + s.getId());
                }
            }
        }
    }

    public List<Subscriber> getSubscribers(String topic) {
        return subscribersByTopic.getOrDefault(topic, Collections.emptyList());
    }
}
