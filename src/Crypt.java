import java.util.Arrays;

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



}
