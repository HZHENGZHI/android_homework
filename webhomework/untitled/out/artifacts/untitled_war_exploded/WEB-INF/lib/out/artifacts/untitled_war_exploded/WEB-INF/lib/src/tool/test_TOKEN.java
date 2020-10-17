package tool;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class test_TOKEN {
    private test_TOKEN() {}
    private static final test_TOKEN instance=new test_TOKEN();

    public static test_TOKEN getInstance()
    {
        return instance;
    }
    public String makeToken() throws NoSuchAlgorithmException {
        String token=(System.currentTimeMillis()+new Random().nextInt(999999999)+"");
        MessageDigest messageDigest = MessageDigest.getInstance("md5");
        byte md5[]=messageDigest.digest(token.getBytes())
    }
}
