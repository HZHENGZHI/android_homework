package com.example.myapplication;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import utlis.read_utils;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Runnable sendable=new Runnable() {
        @Override
        public void run() {
           String path="http://192.168.137.1:7070/test";
           InputStream in = null;
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
               }
           }catch (Exception e)
           {
               e.printStackTrace();
           }finally {

           }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText id=findViewById(R.id.editText);
        EditText pw=findViewById(R.id.editText2);
        Button login=findViewById(R.id.button);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(sendable).start();
            }
        });
    }
}
