import java.security.NoSuchAlgorithmException;

public class Testing {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println(Crypt.encrypt("zzz", 3));
        System.out.println(Crypt.decrypt("aaa", 29));
        System.out.println(Crypt.password_hash("password123"));
        //vtTvodT9vZVL03Bdaip4Jw7JpS7Pv7AQxhhir1x2rxdh/+sa72rKG/XQKzeBqoVPq9K2nHkN504X7P7Dy2rEvw==
        System.out.println(Crypt.password_hash("password123" + Crypt.salt()));
        System.out.println(Crypt.password_hash("password123" + Crypt.salt()));
    }
}
