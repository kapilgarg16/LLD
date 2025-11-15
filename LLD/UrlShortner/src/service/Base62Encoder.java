package service;

public class Base62Encoder {
    private static final String CHAR_SET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";

    public static String encode(int num) {
        StringBuilder sb = new StringBuilder();
        if (num == 0) return "a"; // first code
        while (num > 0) {
            sb.append(CHAR_SET.charAt(num % 62));
            num /= 62;
        }
        String code =  sb.reverse().toString();
        return padToFive(code);
    }

    private static String padToFive(String s) {
        StringBuilder sb = new StringBuilder(s);
        while (sb.length() < 5) {
            sb.insert(0, '0'); // left pad with zero
        }
        return sb.toString();
    }

}
