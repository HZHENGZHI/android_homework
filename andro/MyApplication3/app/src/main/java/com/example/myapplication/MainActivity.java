package com.example.myapplication;

import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText id=findViewById(R.id.editText2);
        final Button login=findViewById(R.id.button);
        final EditText pw=findViewById(R.id.editText);
        final CheckBox box = findViewById(R.id.checkBox2);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String idtext=id.getText().toString();
                System.out.println(idtext);
                String pwtext=pw.getText().toString();
                System.out.println(pwtext);
                boolean staut=box.isChecked();
                System.out.println(staut);
            }
        });
    }
}
