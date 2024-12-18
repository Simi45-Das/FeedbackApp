package com.example.feedbackapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ChooseDept extends AppCompatActivity {

    TextView dept;
    Button next;
    SessionManager sessionManager;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_dept);

        dept = findViewById(R.id.textView6);
        next = findViewById(R.id.button5);

        DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
        reference = rootRef.child("stuDetails");


        sessionManager = new SessionManager(getApplicationContext());

        String de =   sessionManager.getDept();
        dept.setText(de);

  next.setOnClickListener(v -> {


      Intent i = new Intent(ChooseDept.this, ChooseSub.class);
      startActivity(i);

  });

    }
}