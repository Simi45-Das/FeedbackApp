package com.example.feedbackapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView newUser;
    TextView logIn;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        newUser = findViewById(R.id.textView3);
        logIn = findViewById(R.id.textView4);



        newUser.setOnClickListener(v -> {

            Intent i = new Intent(MainActivity.this,PhNumEntry.class);
            startActivity(i);

        });

        logIn.setOnClickListener(v -> {

            Intent i = new Intent(MainActivity.this,StudentLogin.class);
            startActivity(i);

        });
    }


}