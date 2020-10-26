package tool;

import Decoder.BASE64Encoder;

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

    public static String makeToken()  {
        String token=(System.currentTimeMillis()+new Random().nextInt(999999999)+"");
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("md5");
            byte md5[]=messageDigest.digest(token.getBytes());
            BASE64Encoder encoder= new BASE64Encoder();
            return encoder.encode(md5);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        String token=makeToken();
        System.out.println(token);
    }

}
