import service.UrlShortenerService;

public class Main {
    public static void main(String[] args) {

        UrlShortenerService service = new UrlShortenerService();

        String longUrl = "https://www.youtube.com/watch?v=abcd1234xyz";
        String shortUrl = service.shortenUrl(longUrl);

        System.out.println("Shortened URL: " + shortUrl);
        System.out.println("Expanded URL: " + service.expandUrl(shortUrl));

        // shorten again (should give same short URL)
        System.out.println("Shortened again: " + service.shortenUrl(longUrl));
    }
}