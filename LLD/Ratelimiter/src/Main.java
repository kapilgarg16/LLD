import service.RateLimiter;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        RateLimiter limiter = new RateLimiter(3, 1);
        String client = "user-1";

        System.out.println("Send 5 quick requests (capacity = 3):");
        for (int i = 1; i <= 5; i++) {
            boolean ok = limiter.allow(client);
            System.out.printf("Request %d -> %s (tokens left ~ %.2f)%n",
                    i, ok ? "ALLOWED" : "REJECTED", limiter.tokensLeft(client));
        }

        System.out.println("\nWait 2500 ms to refill...");
        Thread.sleep(2500);

        System.out.println("\nSend 3 more requests after sleep:");
        for (int i = 1; i <= 3; i++) {
            boolean ok = limiter.allow(client);
            System.out.printf("AfterSleep Request %d -> %s (tokens left ~ %.2f)%n",
                    i, ok ? "ALLOWED" : "REJECTED", limiter.tokensLeft(client));
        }
    }
    }