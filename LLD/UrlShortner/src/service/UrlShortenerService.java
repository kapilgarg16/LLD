package service;

import java.util.HashMap;
import java.util.Map;

public class UrlShortenerService {

    private final Map<String, String> longToShort = new HashMap<>();
    private final Map<String, String> shortToLong = new HashMap<>();
    private int counter = 1;  // unique ID generator

    private static final String DOMAIN = "http://short.ly/";

    public String shortenUrl(String longUrl) {
        // already exists → return same short URL
        if (longToShort.containsKey(longUrl)) {
            return DOMAIN + longToShort.get(longUrl);
        }

        String code = Base62Encoder.encode(counter++);
        longToShort.put(longUrl, code);
        shortToLong.put(code, longUrl);

        return DOMAIN + code;
    }

    public String expandUrl(String shortUrl) {
        // remove domain
        String code = shortUrl.replace(DOMAIN, "");
        return shortToLong.get(code);
    }
}
