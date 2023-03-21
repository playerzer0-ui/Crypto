import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;

public class Crypt {

    private static final String[] letters = {
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l",
            "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
    };

    Crypt(){}

    public static String encrypt(String word, int key){
        String enc = "";
        String[] w = word.split("");
        for (String s : w) {
            if (s.equals(" ") || s.matches("[^\\w]")) {
                enc += " ";
            } else {
                int c = Arrays.asList(letters).indexOf(s) + key;
                if (c > 26) {
                    c = c % 26;
                }
                enc += letters[c];
            }
        }
        return enc;
    }

    public static String decrypt(String word, int key){
        String dec = "";
        String[] w = word.split("");
        for (String s : w) {
            if (s.equals(" ") || s.matches("[^\\w]")) {
                dec += " ";
            } else {
                int c = Arrays.asList(letters).indexOf(s) - key % 26;
                if (c < 0) {
                    c += 26;
                }
                dec += letters[c];
            }
        }
        return dec;
    }

    public static String password_hash(String word) throws NoSuchAlgorithmException {
        byte[] inputBytes = word.getBytes();
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        byte[] outputBytes = md.digest(inputBytes);
        return Base64.getEncoder().encodeToString(outputBytes);
    }

    public static String salt(){
        // Create an array of 32 bytes (256 bits) to store random bytes
        byte[] saltBytes = new byte[32];
        // The SecureRandom class provides CSPRNG functionality
        SecureRandom random = new SecureRandom();
        // Fill the byte array with random bytes
        random.nextBytes(saltBytes);
        // Encode the random bytes as a Base64 string
        return Base64.getEncoder().encodeToString(saltBytes);
    }

}
