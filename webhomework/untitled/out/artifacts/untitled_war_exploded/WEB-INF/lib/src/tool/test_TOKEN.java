package tool;

import java.util.Random;

public class test_TOKEN {
    private test_TOKEN() {}
    private static final test_TOKEN instance=new test_TOKEN();

    public static test_TOKEN getInstance()
    {
        return instance;
    }
    public String makeToken()
    {
        String token=(System.currentTimeMillis()+new Random().nextInt())
    }
}
