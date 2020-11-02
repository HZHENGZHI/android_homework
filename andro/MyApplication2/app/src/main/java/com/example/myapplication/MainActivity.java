package com.example.myapplication;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.*;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

     private TextView mTextMessage;
     private boolean ischanged=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView bookclick=(ImageView) findViewById(R.id.bookview);



        bookclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("yes");
                if(v==bookclick)
                {
                    if(ischanged)
                    {
                        bookclick.setImageDrawable(getResources().getDrawable(R.drawable.book_click));
                                        //步骤一：添加一个FragmentTransaction的实例
                                        FragmentManager fragmentManager =getFragmentManager();
                                         FragmentTransaction transaction = fragmentManager.beginTransaction();
                                         //步骤二：用add()方法加上Fragment的对象rightFragment
                                         test_fragement rightFragment = new test_fragement();
                                        transaction.add(R.id.linear, rightFragment);
                                        //步骤三：调用commit()方法使得FragmentTransaction实例的改变生效
                                        transaction.commit();
                    }
                    else
                    {
                        bookclick.setImageDrawable(getResources().getDrawable(R.drawable.book));
                    }
                    ischanged=!ischanged;
                }
            }
        });

        SearchView searchView=(SearchView) findViewById(R.id.search_text);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                System.out.println("yes");
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                {

                }
                return false;
            }
        });


    }

}
