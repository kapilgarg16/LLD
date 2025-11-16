public class Main {
    public static void main(String[] args) throws Exception {
        // limit = 3 requests per 2000 ms (2 seconds)
        RateLimiterSlidingNoSync limiter = new RateLimiterSlidingNoSync(3, 2000);

        String client = "user-1";

        System.out.println("Send 5 quick requests (limit = 3 per 2000ms):");
        for (int i = 1; i <= 5; i++) {
            boolean ok = limiter.allow(client);
            System.out.printf("Request %d -> %s (tokens left = %d)%n",
                    i, ok ? "ALLOWED" : "REJECTED", limiter.tokensLeft(client));
            // tiny sleep to make timestamps slightly different (optional)
            Thread.sleep(100);
        }

        System.out.println("\nWait 2200 ms to allow window to slide...");
        Thread.sleep(2200);

        System.out.println("\nSend 3 more requests after sleep:");
        for (int i = 1; i <= 3; i++) {
            boolean ok = limiter.allow(client);
            System.out.printf("AfterSleep Request %d -> %s (tokens left = %d)%n",
                    i, ok ? "ALLOWED" : "REJECTED", limiter.tokensLeft(client));
        }

        // Show counts
        System.out.println("\nCurrent count in window: " + limiter.currentCount(client));
        System.out.println("Demo finished.");
    }
}
