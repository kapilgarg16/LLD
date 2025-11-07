package service;

// RateLimiter.java
import java.util.HashMap;
import java.util.Map;

public class RateLimiter {
    private final double defaultCapacity;
    private final double defaultRefillPerSecond;
    private final Map<String, TokenBucket> buckets = new HashMap<>();

    public RateLimiter(double defaultCapacity, double defaultRefillPerSecond) {
        this.defaultCapacity = defaultCapacity;
        this.defaultRefillPerSecond = defaultRefillPerSecond;
    }

    // Allow one request for clientId
    public boolean allow(String clientId) {
        TokenBucket bucket = buckets.get(clientId);
        if (bucket == null) {
            bucket = new TokenBucket(defaultCapacity, defaultRefillPerSecond);
            buckets.put(clientId, bucket);
        }
        return bucket.tryConsumeOne();
    }

    // debug helper
    public Double tokensLeft(String clientId) {
        TokenBucket b = buckets.get(clientId);
        return b == null ? null : b.getTokens();
    }
}
