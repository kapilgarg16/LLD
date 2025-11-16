import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Sliding-window-log rate limiter (single-threaded, no synchronization).
 *
 * - limit: max requests allowed per window
 * - windowMs: sliding window size in milliseconds
 *
 * NOTE: This class is NOT thread-safe. Use only from a single thread.
 */
public class RateLimiterSlidingNoSync {
    private final int limit;
    private final long windowMs;

    // clientId -> deque of timestamps (oldest at head)
    private final Map<String, Deque<Long>> logs = new HashMap<>();

    public RateLimiterSlidingNoSync(int limit, long windowMs) {
        if (limit <= 0) throw new IllegalArgumentException("limit must be > 0");
        if (windowMs <= 0) throw new IllegalArgumentException("windowMs must be > 0");
        this.limit = limit;
        this.windowMs = windowMs;
    }

    /** Allow one request for clientId. Single-threaded only. */
    public boolean allow(String clientId) {
        long now = System.currentTimeMillis();
        Deque<Long> dq = logs.get(clientId);
        if (dq == null) {
            dq = new ArrayDeque<>();
            logs.put(clientId, dq);
        }

        purgeOld(now, dq);

        if (dq.size() < limit) {
            dq.addLast(now);
            return true;
        }
        return false;
    }

    /** Return how many requests are still allowed right now (limit - recentCount). */
    public int tokensLeft(String clientId) {
        long now = System.currentTimeMillis();
        Deque<Long> dq = logs.get(clientId);
        if (dq == null) return limit;
        purgeOld(now, dq);
        int left = limit - dq.size();
        return Math.max(left, 0);
    }

    /** Helper: remove timestamps older than (now - windowMs). */
    private void purgeOld(long now, Deque<Long> dq) {
        long cutoff = now - windowMs;
        while (!dq.isEmpty() && dq.peekFirst() < cutoff) {
            dq.removeFirst();
        }
    }

    /** Debug: current count in window for a client. */
    public int currentCount(String clientId) {
        Deque<Long> dq = logs.get(clientId);
        if (dq == null) return 0;
        purgeOld(System.currentTimeMillis(), dq);
        return dq.size();
    }
}
