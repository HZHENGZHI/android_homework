import com.google.gson.Gson;
import com.pojo.user;
import org.junit.Test;

public class kk {
    @Test
    public void vvvv()
    {
        Gson gson=new Gson();
        user user=new user("123","123");
       String k= gson.toJson(user);
        System.out.println(k);
    }
}
