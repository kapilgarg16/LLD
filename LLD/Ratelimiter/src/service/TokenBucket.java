package service;

public class TokenBucket {
    private final double capacity;
    private final double refillPerSecond;
    private double tokens;
    private long lastRefillMs;

    // start full
    public TokenBucket(double capacity, double refillPerSecond) {
        this.capacity = capacity;
        this.refillPerSecond = refillPerSecond;
        this.tokens = capacity;
        this.lastRefillMs = System.currentTimeMillis();
    }

    // update tokens based on elapsed time (simple)
    private void refill() {
        long now = System.currentTimeMillis();
        long elapsed = now - lastRefillMs;
        if (elapsed <= 0) return;
        double added = (elapsed / 1000.0) * refillPerSecond;
        tokens = Math.min(capacity, tokens + added);
        lastRefillMs = now;
    }

    // try to take 1 token
    public boolean tryConsumeOne() {
        refill();
        if (tokens >= 1.0) {
            tokens -= 1.0;
            return true;
        }
        return false;
    }

    // helper for testing / demo
    public double getTokens() {
        refill();
        return tokens;
    }
}
