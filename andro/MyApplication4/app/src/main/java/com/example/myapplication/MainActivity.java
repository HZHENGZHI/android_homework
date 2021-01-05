package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import pojo.test;
import utils.http_method;

public class MainActivity extends AppCompatActivity {
    private EditText id;
    private EditText pw;
    private Button login;
    private Context context;
    Runnable sendable=new Runnable() {
        @Override
        public void run() {
            String data= http_method.doget("http://192.168.19.1:7070/untitled_war_exploded/test");
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login=findViewById(R.id.button);
        id=findViewById(R.id.editText);
        pw=findViewById(R.id.editText2);
        context=getApplicationContext();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String iddata = id.getText().toString();
                String pwdata=pw.getText().toString();
                String checknull="";
                if(iddata.equals(checknull) || pwdata.equals(checknull))
              {
                  Toast.makeText(context, "用户名或者密码未填写", Toast.LENGTH_SHORT).show();
              }
                else
                {
                    new Thread(sendable).start();
                    Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                    startActivity(intent);
                }


            }
        });
    }
}
