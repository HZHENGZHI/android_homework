package utlis;

import com.google.gson.Gson;
import pojo.test;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.FormatFlagsConversionMismatchException;

public class http_method {

    public static String  doget(String path)
    {
        InputStream in = null;
        test test=new test();
        try
        {
            URL url=new URL(path);
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(3000);
            connection.setRequestProperty("content-type","text/html;charset=utf-8");
            connection.connect();
            if(connection.getResponseCode()==200)
            {
                in = connection.getInputStream();
                byte[] getData = read_utils.readInputStream(in);
                in.read(getData);
                String str = new String(getData);
                test.setData(str);
            }
        }catch (Exception e)
        {
            e.printStackTrace();
        }finally {

        }
        Gson gson=new Gson();
        String data=gson.toJson(test);
        return "";
    }

}
