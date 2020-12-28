import com.google.gson.Gson;

public class kk {
    public static void main(String[] args) {
        Gson gson=new Gson();
        String k=gson.toJson("123");
        System.out.println(k);
    }
}
