package service;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Subscriber {
    private final String id;          // e.g. email or phone
    private final Set<String> channels;

    public Subscriber(String id, Collection<String> channels) {
        this.id = id;
        this.channels = new HashSet<>(channels == null ? Collections.emptySet() : channels);
    }
    public String getId() { return id; }
    public Set<String> getChannels() { return channels; }

}